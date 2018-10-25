package com.troytan.sixpack.dto;

import com.troytan.sixpack.domain.Debate;

public class DebateDto extends Debate {

    private Integer value; // 投票结果

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
