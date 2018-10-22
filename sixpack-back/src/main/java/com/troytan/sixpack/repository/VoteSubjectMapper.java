package com.troytan.sixpack.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.troytan.sixpack.domain.VoteSubject;
import com.troytan.sixpack.dto.VoteSubjectDto;

public interface VoteSubjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_vote_subject
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer subjectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_vote_subject
     *
     * @mbg.generated
     */
    int insert(VoteSubject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_vote_subject
     *
     * @mbg.generated
     */
    VoteSubject selectByPrimaryKey(Integer subjectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_vote_subject
     *
     * @mbg.generated
     */
    List<VoteSubject> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tt_vote_subject
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VoteSubject record);

    VoteSubjectDto getSubjectDto(@Param("subjectId")Integer subjectId, @Param("userId")Integer userId);
}