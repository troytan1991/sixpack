package com.troytan.sixpack.repository;

import java.util.List;

import com.troytan.sixpack.domain.Video;
import com.troytan.sixpack.dto.VideoMainDto;

public interface VideoMapper {

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tm_video
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer videoId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tm_video
     *
     * @mbg.generated
     */
    int insert(Video record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tm_video
     *
     * @mbg.generated
     */
    Video selectByPrimaryKey(Integer videoId);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tm_video
     *
     * @mbg.generated
     */
    List<Video> selectAll();

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tm_video
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Video record);

    /**
     * 根据教练获取所有视频
     *
     * @author troytan
     * @date 2018年10月9日
     * @param prefer
     * @return
     */
    List<VideoMainDto> listByPrefer(Short prefer);
}
