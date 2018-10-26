package com.troytan.sixpack.dto;

import java.util.List;

import com.troytan.sixpack.domain.User;

public class GroupResult {

    private Integer    totalAmount; // 收到总投票金额
    private List<User> users;       // 用户列表

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

}
