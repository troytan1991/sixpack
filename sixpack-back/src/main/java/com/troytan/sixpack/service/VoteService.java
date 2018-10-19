package com.troytan.sixpack.service;

import java.util.List;

import com.troytan.sixpack.domain.VoteSubject;
import com.troytan.sixpack.dto.VoteResult;

public interface VoteService {

    void voteSubject(Integer subjectId, Short value);

    VoteResult getVoteResult(Integer subjectId);

    int createSubject(VoteSubject subject);

    VoteSubject getSubject(Integer subjectId);

    List<VoteSubject> listSendSubject();

    List<VoteSubject> listPaticipateSubject();
}
