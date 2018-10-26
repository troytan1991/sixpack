package com.troytan.sixpack.service;

import java.util.List;

import com.troytan.sixpack.domain.Debate;
import com.troytan.sixpack.dto.DebateResult;
import com.troytan.sixpack.dto.GroupDto;

public interface DebateService {

    Integer createDebate(Debate debate);

    void deleteDebate(Integer debateId);

    void voteDebate(Integer debateId, Short value);

    Debate getDebate(Integer debateId);

    List<Debate> getSendDebates();

    DebateResult getDebateResult(Integer debateId);

    String registerGroup(GroupDto groupDto) throws Exception;

}
