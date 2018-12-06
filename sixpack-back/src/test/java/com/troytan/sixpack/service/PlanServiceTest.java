package com.troytan.sixpack.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.troytan.sixpack.dto.PlanDetailDto;
import com.troytan.sixpack.dto.PlanDto;
import com.troytan.sixpack.dto.UserSessionDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanServiceTest {

    @Autowired
    private PlanService planService;
    @Autowired
    private UserService userService;

    @Test
    public void listPlanTest() {
        userService.setCurrentUser(new UserSessionDto(1, "123", "lasdjfqwe"));
        List<PlanDto> list = planService.listPlan();
        System.out.println(list.size());
    }

    @Test
    public void getPlanDetailTest() {
        userService.setCurrentUser(new UserSessionDto(1, "123", "lasdjfqwe"));
        PlanDetailDto detailDto = planService.getPlanDetail(1);
        System.out.println(detailDto.getPlanId());
    }

    @Test
    public void markPlanTest() {
        userService.setCurrentUser(new UserSessionDto(1, "123", "lasdjfqwe"));
        planService.markPlan(1, (short) 1);
    }
}
