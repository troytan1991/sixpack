package com.troytan.sixpack.repository;

import com.troytan.sixpack.domain.Debate;
import java.util.List;

public interface DebateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_debate
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer debateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_debate
     *
     * @mbg.generated
     */
    int insert(Debate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_debate
     *
     * @mbg.generated
     */
    Debate selectByPrimaryKey(Integer debateId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_debate
     *
     * @mbg.generated
     */
    List<Debate> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_debate
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Debate record);
}