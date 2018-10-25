package com.troytan.sixpack.dto;

public class VoteResult {

    private Integer     unvoteCount;// 未投票人数
    private Integer     votedCount; // 已投票人数
    private Integer     leftAmount; // 剩余资金
    // 各小组投票结果
    private GroupResult side1;
    private GroupResult side2;
    private GroupResult side3;
    private GroupResult side4;

    public Integer getUnvoteCount() {
        return unvoteCount;
    }

    public void setUnvoteCount(Integer unvoteCount) {
        this.unvoteCount = unvoteCount;
    }

    public Integer getVotedCount() {
        return votedCount;
    }

    public void setVotedCount(Integer votedCount) {
        this.votedCount = votedCount;
    }

    public Integer getLeftAmount() {
        return leftAmount;
    }

    public void setLeftAmount(Integer leftAmount) {
        this.leftAmount = leftAmount;
    }

    public GroupResult getSide1() {
        return side1;
    }

    public void setSide1(GroupResult side1) {
        this.side1 = side1;
    }

    public GroupResult getSide2() {
        return side2;
    }

    public void setSide2(GroupResult side2) {
        this.side2 = side2;
    }

    public GroupResult getSide3() {
        return side3;
    }

    public void setSide3(GroupResult side3) {
        this.side3 = side3;
    }

    public GroupResult getSide4() {
        return side4;
    }

    public void setSide4(GroupResult side4) {
        this.side4 = side4;
    }
}
