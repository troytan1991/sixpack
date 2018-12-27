package com.troytan.sixpack.dto;

import java.util.List;

import com.troytan.sixpack.domain.Gvote;
import com.troytan.sixpack.domain.GvoteItem;

public class GvoteDto extends Gvote {

    private List<GvoteItem> voteItems;

    public List<GvoteItem> getVoteItems() {
        return voteItems;
    }

    public void setVoteItems(List<GvoteItem> voteItems) {
        this.voteItems = voteItems;
    }

}
