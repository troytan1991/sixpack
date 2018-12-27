package com.troytan.sixpack.dto;

import java.util.List;

public class GvoteResultDto extends GvoteResultTitle {

    private List<GvoteItemResult> itemResults;

    public List<GvoteItemResult> getItemResults() {
        return itemResults;
    }

    public void setItemResults(List<GvoteItemResult> itemResults) {
        this.itemResults = itemResults;
    }

}
