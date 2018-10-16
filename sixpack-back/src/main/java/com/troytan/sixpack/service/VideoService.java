package com.troytan.sixpack.service;

import java.util.List;

import com.troytan.sixpack.dto.VideoDetailDto;
import com.troytan.sixpack.dto.VideoMainDto;

public interface VideoService {

    List<VideoMainDto> listMainVideo();

    VideoDetailDto getVideoDetail(Integer videoRcId);

}
