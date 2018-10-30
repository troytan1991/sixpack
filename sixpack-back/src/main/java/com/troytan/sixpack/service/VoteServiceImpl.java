package com.troytan.sixpack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.domain.User;
import com.troytan.sixpack.domain.Vote;
import com.troytan.sixpack.domain.VoteSubject;
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
    // private final String ANONYMOUS_URL = "http://troytan.club/vote/anonymous.png";
    // private final String ANONYMOUS_NAME = "anonymous";

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
        if (subject == null) {
            return null;
        }
        List<RealVoteResult> results = voteMapper.getVoteResultWithUser(subjectId);
        voteResult.setSide1(generateSideResult(results, subject, (short) 1));
        voteResult.setSide2(generateSideResult(results, subject, (short) 2));
        voteResult.setSide3(generateSideResult(results, subject, (short) 3));
        voteResult.setSide4(generateSideResult(results, subject, (short) 4));
        int votedCount = results.stream().mapToInt(result -> result.getUsers().size()).sum();
        int votedAmount = voteResult.getSide1().getTotalAmount() + voteResult.getSide2().getTotalAmount()
                          + voteResult.getSide3().getTotalAmount() + voteResult.getSide4().getTotalAmount();
        voteResult.setVotedCount(votedCount);
        voteResult.setUnvoteCount(subject.getTotalNum() - votedCount);

        voteResult.setLeftAmount(subject.getFundPool() - votedAmount);
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
    private GroupResult generateSideResult(List<RealVoteResult> realResults, VoteSubject subject, short value) {
        GroupResult groupResult = new GroupResult();
        boolean flag = false;
        for (RealVoteResult realVoteResult : realResults) {
            if (realVoteResult.getValue().equals(value)) {
                List<User> users = realVoteResult.getUsers();
                int voteCount = users.stream().mapToInt(user -> user.getVoteWeight()).sum();
                groupResult.setVoteCount(voteCount);
                groupResult.setTotalAmount(voteCount * subject.getUnitPrice());
                flag = true;
                break;
            }
        }
        if (!flag) {
            // 未找到相关value
            groupResult.setTotalAmount(0);
            groupResult.setVoteCount(0);
        }
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
        if (dbSubject != null && dbSubject.getGroupId() == null) {
            dbSubject.setGroupId(groupId);
            dbSubject.setUpdateBy(userService.getCurrentUser());
            voteSubjectMapper.updateByPrimaryKey(dbSubject);
        }

        return groupId;
    }

    @Override
    public List<VoteSubject> getSendSubjects() {

        return voteSubjectMapper.listByUserId(userService.getCurrentUser());
    }

    @Override
    public void deleteSubject(Integer subjectId) {
        voteSubjectMapper.deleteById(subjectId);
    }

}
