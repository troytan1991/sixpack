package com.troytan.sixpack.repository;

import com.troytan.sixpack.domain.UserPlan;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserPlanMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_user_plan
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer userPlanId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_user_plan
     *
     * @mbg.generated
     */
    int insert(UserPlan record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_user_plan
     *
     * @mbg.generated
     */
    UserPlan selectByPrimaryKey(Integer userPlanId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_user_plan
     *
     * @mbg.generated
     */
    List<UserPlan> selectAll();

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_user_plan
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserPlan record);

    UserPlan selectByPlanAndUser(@Param("planId") Integer planId, @Param("userId") Integer userId);
}