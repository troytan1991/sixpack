package com.troytan.sixpack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.domain.Debate;
import com.troytan.sixpack.domain.Vote;
import com.troytan.sixpack.dto.DebateResult;
import com.troytan.sixpack.dto.GroupDto;
import com.troytan.sixpack.repository.DebateMapper;
import com.troytan.sixpack.repository.VoteMapper;

@Service
@Transactional
public class DebateServiceImpl implements DebateService {

    @Autowired
    private UserService  userService;
    @Autowired
    private DebateMapper debateMapper;
    @Autowired
    private VoteMapper   voteMapper;

    /**
     * 创建辩论
     *
     * @author troytan
     * @date 2018年10月25日
     * @param debate
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.DebateService#createDebate(com.troytan.sixpack.domain.Debate)
     */
    @Override
    public Integer createDebate(Debate debate) {
        debate.setCreateBy(userService.getCurrentUser());
        debate.setStatus((short) 1);
        debateMapper.insert(debate);
        return debate.getDebateId();
    }

    /**
     * 删除辩论
     *
     * @author troytan
     * @date 2018年10月25日
     * @param debateId (non-Javadoc)
     * @see com.troytan.sixpack.service.DebateService#deleteDebate(java.lang.Integer)
     */
    @Override
    public void deleteDebate(Integer debateId) {
        debateMapper.deleteByStatus(debateId);
    }

    /**
     * 辩论投票
     *
     * @author troytan
     * @date 2018年10月25日
     * @param debateId
     * @param value (non-Javadoc)
     * @see com.troytan.sixpack.service.DebateService#voteDebate(java.lang.Integer, java.lang.Short)
     */
    @Override
    public void voteDebate(Integer debateId, Short value) {
        Integer userId = userService.getCurrentUser();
        voteMapper.deleteByUserAndId(userId, debateId);

        Vote vote = new Vote();
        vote.setCreateBy(userId);
        vote.setDebateId(debateId);
        vote.setUserId(userId);
        vote.setValue(value);

        voteMapper.insert(vote);
    }

    /**
     * 获取辩论
     *
     * @author troytan
     * @date 2018年10月25日
     * @param debateId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.DebateService#getDebate(java.lang.Integer)
     */
    @Override
    public Debate getDebate(Integer debateId) {
        return debateMapper.getDebateDto(debateId, userService.getCurrentUser());
    }

    /**
     * 获取创建列表
     *
     * @author troytan
     * @date 2018年10月25日
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.DebateService#getSendDebates()
     */
    @Override
    public List<Debate> getSendDebates() {
        return debateMapper.listByUserId(userService.getCurrentUser());
    }

    /**
     * 获取辩论投票结果
     *
     * @author troytan
     * @date 2018年10月25日
     * @param debateId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.DebateService#getDebateResult(java.lang.Integer)
     */
    @Override
    public DebateResult getDebateResult(Integer debateId) {
        DebateResult debateResult = voteMapper.getDebateResult(debateId);
        Integer totalCount = debateMapper.selectByPrimaryKey(debateId).getTotalCount();
        debateResult.setTotalCount(totalCount);
        debateResult.setLeftCount(totalCount - debateResult.getObverseCount() - debateResult.getReverseCount());
        return debateResult;
    }

    @Override
    public String registerGroup(GroupDto groupDto) throws Exception {
        String groupId = userService.registerGroupUser(groupDto);
        Debate debate = debateMapper.selectByPrimaryKey(groupDto.getDebateId());
        if (debate.getGroupId() == null) {
            debate.setGroupId(groupId);
            debate.setUpdateBy(userService.getCurrentUser());
            debateMapper.updateByPrimaryKey(debate);
        }

        return groupId;
    }

}
