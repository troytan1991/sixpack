package com.troytan.sixpack.repository;

import com.troytan.sixpack.domain.Form;
import com.troytan.sixpack.dto.FormDto;

import java.util.List;

public interface FormMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_form
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_form
     *
     * @mbg.generated
     */
    int insert(Form record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_form
     *
     * @mbg.generated
     */
    Form selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_form
     *
     * @mbg.generated
     */
    List<Form> selectAll();

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tt_form
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Form record);

    /**
     * 查找所有可用的用户提交码
     *
     * @author troytan
     * @date 2018年10月12日
     * @return
     */
    List<FormDto> listFormId();
}
