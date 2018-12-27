package com.troytan.sixpack.dto;

import java.util.List;

/**
 * 选项投票结果
 * 
 * @author troytan
 * @date 2018年12月26日
 */
public class GvoteItemResult {

    private Integer        itemId;    // 选项ID
    private String         content;   // 选项内容
    private List<UserVote> userVotes; // 所有投票用户
    private Boolean        myVote;    // 自己是否投的该项
    private String         weight;    // 所占比重

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getMyVote() {
        return myVote;
    }

    public void setMyVote(Boolean myVote) {
        this.myVote = myVote;
    }

    public List<UserVote> getUserVotes() {
        return userVotes;
    }

    public void setUserVotes(List<UserVote> userVotes) {
        this.userVotes = userVotes;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

}
