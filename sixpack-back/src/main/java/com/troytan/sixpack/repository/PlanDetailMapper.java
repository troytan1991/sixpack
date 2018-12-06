package com.troytan.sixpack.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.troytan.sixpack.domain.PlanDetail;
import com.troytan.sixpack.dto.PlanDetailDto;

public interface PlanDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_plan_detail
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer planDetailId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_plan_detail
     *
     * @mbg.generated
     */
    int insert(PlanDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_plan_detail
     *
     * @mbg.generated
     */
    PlanDetail selectByPrimaryKey(Integer planDetailId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_plan_detail
     *
     * @mbg.generated
     */
    List<PlanDetail> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_plan_detail
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PlanDetail record);

    PlanDetailDto selectByPlanId(@Param("planId") Integer planId,@Param("userId") Integer userId);
}