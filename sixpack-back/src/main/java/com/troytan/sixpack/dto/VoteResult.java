package com.troytan.sixpack.dto;

public class VoteResult {

    private Integer obverseCount; // 正方票数
    private Integer reverseCount; // 反方票数

    public Integer getObverseCount() {
        return obverseCount;
    }

    public void setObverseCount(Integer obverseCount) {
        this.obverseCount = obverseCount;
    }

    public Integer getReverseCount() {
        return reverseCount;
    }

    public void setReverseCount(Integer reverseCount) {
        this.reverseCount = reverseCount;
    }
}
