package com.troytan.sixpack.dto;

import com.troytan.sixpack.domain.Gvote;

public class GvoteResultTitle extends Gvote {

    private String  avatarUrl;
    private String  nickName;
    private Integer totalNum;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

}
