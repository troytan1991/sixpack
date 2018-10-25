package com.troytan.sixpack.dto;

public class DebateResult {

    private Integer obverseCount; // 正方票数
    private Integer reverseCount; // 反方票数
    private Integer leftCount;    // 剩余人数
    private Integer totalCount;   // 总人数

    public Integer getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(Integer leftCount) {
        this.leftCount = leftCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

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
