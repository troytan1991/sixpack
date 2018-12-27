package com.troytan.sixpack.service;

import java.util.List;

import com.troytan.sixpack.domain.GvoteResult;
import com.troytan.sixpack.dto.GroupDto;
import com.troytan.sixpack.dto.GvoteDto;
import com.troytan.sixpack.dto.GvoteResultDto;
import com.troytan.sixpack.dto.GvoteResultTitle;

public interface GvoteService {

    Integer saveVote(GvoteDto voteDto);

    void userVote(List<GvoteResult> voteResults, Integer gvoteId);

    GvoteResultDto getVoteResult(Integer gvoteId);

    GvoteResultDto getVoteDetail(Integer gvoteId);

    void finishVote(Integer gvoteId);

    String registerGroup(GroupDto groupDto) throws Exception;

    List<GvoteResultTitle> getSendVotes();

    List<GvoteResultTitle> getReceiveVotes();

    void deleteVote(Integer gvoteId);

    Boolean checkVoted(Integer gvoteId);

}
