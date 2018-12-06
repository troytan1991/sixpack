package com.troytan.sixpack.service;

import java.util.List;

import com.troytan.sixpack.dto.PlanDetailDto;
import com.troytan.sixpack.dto.PlanDto;

public interface PlanService {

    List<PlanDto> listPlan();

    PlanDetailDto getPlanDetail(Integer planId);

    void markPlan(Integer planId, Short status);

}
