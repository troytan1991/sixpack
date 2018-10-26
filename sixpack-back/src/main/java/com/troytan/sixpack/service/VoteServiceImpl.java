package com.troytan.sixpack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.domain.User;
import com.troytan.sixpack.domain.Vote;
import com.troytan.sixpack.domain.VoteSubject;
import com.troytan.sixpack.dto.AnonymousVoteResult;
import com.troytan.sixpack.dto.GroupDto;
import com.troytan.sixpack.dto.GroupResult;
import com.troytan.sixpack.dto.RealVoteResult;
import com.troytan.sixpack.dto.VoteResult;
import com.troytan.sixpack.repository.VoteMapper;
import com.troytan.sixpack.repository.VoteSubjectMapper;

@Service
@Transactional
public class VoteServiceImpl implements VoteService {

    @Autowired
    private UserService       userService;
    @Autowired
    private VoteMapper        voteMapper;
    @Autowired
    private VoteSubjectMapper voteSubjectMapper;
    private final String      ANONYMOUS_URL  = "http://troytan.club/vote/anonymous.png";
    private final String      ANONYMOUS_NAME = "anonymous";

    /**
     * 向主题投票
     *
     * @author troytan
     * @date 2018年10月18日
     * @param subjectId (non-Javadoc)
     * @see com.troytan.sixpack.service.VoteService#voteSubject(java.lang.Integer)
     */

    @Override
    public void voteSubject(Integer subjectId, Short value) {
        Integer userId = userService.getCurrentUser();
        // voteMapper.deleteByUserAndSubjectId(userId, subjectId);

        Vote vote = new Vote();
        vote.setSubjectId(subjectId);
        vote.setUserId(userId);
        vote.setValue(value);
        vote.setCreateBy(userId);
        voteMapper.insert(vote);
    }

    /**
     * 获取投票结果
     *
     * @author troytan
     * @date 2018年10月18日
     * @param subjectId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.VoteService#getVoteResult(java.lang.Integer)
     */
    @Override
    public VoteResult getVoteResult(Integer subjectId) {
        VoteResult voteResult = new VoteResult();
        VoteSubject subject = voteSubjectMapper.selectByPrimaryKey(subjectId);
        int unitPrice = subject.getUnitPrice();
        int votedCount = 0;
        if (subject.getAnonymous()) {
            // 匿名投票
            AnonymousVoteResult aResult = voteMapper.getVoteResultWithOutUser(subjectId);
            voteResult.setSide1(generateAnonyResult(aResult.getGroup1Count(), unitPrice));
            voteResult.setSide2(generateAnonyResult(aResult.getGroup2Count(), unitPrice));
            voteResult.setSide3(generateAnonyResult(aResult.getGroup3Count(), unitPrice));
            voteResult.setSide4(generateAnonyResult(aResult.getGroup4Count(), unitPrice));
            votedCount = aResult.getGroup1Count() + aResult.getGroup2Count() + aResult.getGroup3Count()
                         + aResult.getGroup4Count();
        } else {
            // 非匿名投票
            List<RealVoteResult> rResults = voteMapper.getVoteResultWithUser(subjectId);
            voteResult.setSide1(generateRealResult(rResults, (short) 1, unitPrice));
            voteResult.setSide2(generateRealResult(rResults, (short) 2, unitPrice));
            voteResult.setSide3(generateRealResult(rResults, (short) 3, unitPrice));
            voteResult.setSide4(generateRealResult(rResults, (short) 4, unitPrice));
            votedCount = rResults.stream().mapToInt(result -> result.getUsers().size()).sum();

        }
        voteResult.setVotedCount(votedCount);
        voteResult.setUnvoteCount(subject.getTotalNum() - votedCount);
        voteResult.setLeftAmount((subject.getTotalNum() - votedCount) * unitPrice);
        return voteResult;
    }

    /**
     * 生成实名投票结果
     *
     * @author troytan
     * @date 2018年10月22日
     * @param realVote
     * @param unitPrice
     * @return
     */
    private GroupResult generateRealResult(List<RealVoteResult> realResults, short value, int unitPrice) {
        GroupResult groupResult = new GroupResult();
        boolean flag = false;
        for (RealVoteResult realVoteResult : realResults) {
            if (realVoteResult.getValue().equals(value)) {
                List<User> users = realVoteResult.getUsers();
                int totalAmount = users.stream().mapToInt(user -> user.getVoteWeight() * unitPrice).sum();
                groupResult.setTotalAmount(totalAmount);
                groupResult.setUsers(users);
                flag = true;
                break;
            }
        }
        if (!flag) {
            // 未找到相关value
            groupResult.setTotalAmount(0);
            groupResult.setUsers(new ArrayList<>());
        }
        return groupResult;
    }

    /**
     * 生成匿名投票结果
     *
     * @author troytan
     * @date 2018年10月22日
     * @param count
     * @param unitPrice
     * @return
     */
    private GroupResult generateAnonyResult(int count, int unitPrice) {
        GroupResult groupResult = new GroupResult();
        groupResult.setTotalAmount(unitPrice * count);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setAvatarUrl(ANONYMOUS_URL);
            user.setNickname(ANONYMOUS_NAME);

            users.add(user);
        }
        groupResult.setUsers(users);
        return groupResult;
    }

    /**
     * 获取主题,为空则表示无权限访问
     * 
     * @author troytan
     * @date 2018年10月18日
     * @param subjectId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.VoteService#getSubject(java.lang.Integer)
     */
    @Override
    public VoteSubject getSubject(Integer subjectId) {

        return voteSubjectMapper.getSubjectDto(subjectId, userService.getCurrentUser());
    }

    @Override
    public String registerGroup(GroupDto groupDto) throws Exception {
        // 群用户关联
        String groupId = userService.registerGroupUser(groupDto);
        // 投票主题-群ID关联
        VoteSubject dbSubject = voteSubjectMapper.selectByPrimaryKey(groupDto.getSubjectId());
        if (dbSubject.getGroupId() == null) {
            dbSubject.setGroupId(groupId);
            dbSubject.setUpdateBy(userService.getCurrentUser());
            voteSubjectMapper.updateByPrimaryKey(dbSubject);
        }

        return groupId;
    }

}
