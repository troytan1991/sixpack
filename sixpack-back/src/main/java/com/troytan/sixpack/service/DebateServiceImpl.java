package com.troytan.sixpack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.domain.Debate;
import com.troytan.sixpack.domain.Vote;
import com.troytan.sixpack.dto.DebateResult;
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

    @Override
    public Integer createDebate(Debate debate) {
        debate.setCreateBy(userService.getCurrentUser());
        debate.setStatus((short) 1);
        debateMapper.insert(debate);
        return debate.getDebateId();
    }

    @Override
    public void deleteDebate(Integer debateId) {
        debateMapper.deleteByStatus(debateId);
    }

    @Override
    public void voteDebate(Integer debateId, Short value) {
        Integer userId = userService.getCurrentUser();
        Vote vote = new Vote();
        vote.setCreateBy(userId);
        vote.setDebateId(debateId);
        vote.setUserId(userId);
        vote.setValue(value);

        voteMapper.insert(vote);
    }

    @Override
    public Debate getDebate(Integer debateId) {
        return debateMapper.getDebateDto(debateId, userService.getCurrentUser());
    }

    @Override
    public List<Debate> getSendDebates() {
        return debateMapper.listByUserId(userService.getCurrentUser());
    }

    @Override
    public DebateResult getDebateResult(Integer debateId) {
        DebateResult debateResult = voteMapper.getDebateResult(debateId);
        Debate debate = debateMapper.selectByPrimaryKey(debateId);
        return voteMapper.getDebateResult(debateId);
    }

}
