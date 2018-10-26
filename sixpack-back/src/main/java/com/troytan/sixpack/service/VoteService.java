package com.troytan.sixpack.service;

import java.util.List;

import com.troytan.sixpack.domain.VoteSubject;
import com.troytan.sixpack.dto.GroupDto;
import com.troytan.sixpack.dto.VoteResult;

public interface VoteService {

    void voteSubject(Integer subjectId, Short value);

    VoteResult getVoteResult(Integer subjectId);

    VoteSubject getSubject(Integer subjectId);

    String registerGroup(GroupDto groupDto) throws Exception;

    List<VoteSubject> getSendSubjects();

    void deleteSubject(Integer subjectId);

}
