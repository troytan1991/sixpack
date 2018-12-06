package com.troytan.sixpack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.troytan.sixpack.dto.PlanDetailDto;
import com.troytan.sixpack.dto.PlanDto;
import com.troytan.sixpack.service.PlanService;

@RestController
@RequestMapping(path = "/plan", produces = "application/json;charset=UTF-8")
public class PlanController {

    @Autowired
    private PlanService planService;

    /**
     * 获取所有的计划与状态
     *
     * @author troytan
     * @date 2018年12月6日
     * @return
     */
    @GetMapping("/plans")
    public List<PlanDto> getPlans() {
        return planService.listPlan();
    }

    /**
     * 获取某次训练日的详情
     *
     * @author troytan
     * @date 2018年12月6日
     * @param planId
     * @return
     */
    @GetMapping("/detail/{planId}")
    public PlanDetailDto getPlanDetail(@PathVariable("planId") Integer planId) {
        return planService.getPlanDetail(planId);
    }

    /**
     * 标记训练日的状态
     *
     * @author troytan
     * @date 2018年12月6日
     * @param status
     */
    @PutMapping("/mark/{planId}/{status}")
    public void markPlan(@PathVariable("planId") Integer planId, @PathVariable("status") Short status) {
        planService.markPlan(planId, status);
    }

}
