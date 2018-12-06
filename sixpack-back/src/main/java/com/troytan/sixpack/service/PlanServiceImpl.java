package com.troytan.sixpack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.domain.UserPlan;
import com.troytan.sixpack.dto.PlanDetailDto;
import com.troytan.sixpack.dto.PlanDto;
import com.troytan.sixpack.repository.PlanDetailMapper;
import com.troytan.sixpack.repository.PlanMapper;
import com.troytan.sixpack.repository.UserPlanMapper;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper       planMapper;
    @Autowired
    private PlanDetailMapper detailMapper;
    @Autowired
    private UserPlanMapper   userPlanMapper;
    @Autowired
    private UserService      userService;

    @Override
    public List<PlanDto> listPlan() {

        return planMapper.listPlanByUser(userService.getCurrentUser());
    }

    /**
     * 获取训练日详情
     *
     * @author troytan
     * @date 2018年12月6日
     * @param planId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.PlanService#getPlanDetail(java.lang.Integer)
     */
    @Override
    public PlanDetailDto getPlanDetail(Integer planId) {
        PlanDetailDto detail = detailMapper.selectByPlanId(planId, userService.getCurrentUser());
        short totalDay = planMapper.countByLevel(detail.getLevel());
        detail.setTotalDay(totalDay);
        return detail;
    }

    /**
     * 标记训练日状态
     *
     * @author troytan
     * @date 2018年12月6日
     * @param planId
     * @param status (non-Javadoc)
     * @see com.troytan.sixpack.service.PlanService#markPlan(java.lang.Integer, java.lang.Short)
     */
    @Override
    public void markPlan(Integer planId, Short status) {
        Integer userId = userService.getCurrentUser();
        UserPlan userPlan = userPlanMapper.selectByPlanAndUser(planId, userId);
        if (userPlan != null) {
            userPlan.setStatus(status);
            userPlanMapper.updateByPrimaryKey(userPlan);
        } else {
            userPlan = new UserPlan();
            userPlan.setPlanId(planId);
            userPlan.setStatus(status);
            userPlan.setUserId(userId);
            userPlan.setCreateBy(userId);

            userPlanMapper.insert(userPlan);
        }
        // 若为完成状态，则解锁下一个训练日
        if (status == 2) {
            userPlan = userPlanMapper.selectByPlanAndUser(planId + 1, userId);
            if (userPlan == null) {
                userPlan = new UserPlan();
                userPlan.setPlanId(planId + 1);
                userPlan.setStatus((short) 0);
                userPlan.setUserId(userId);
                userPlan.setCreateBy(userId);
                try {
                    userPlanMapper.insert(userPlan);
                } catch (Exception e) {
                }
            }
        }
    }

}
