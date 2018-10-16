package com.troytan.sixpack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.troytan.sixpack.dto.VideoDetailDto;
import com.troytan.sixpack.dto.VideoMainDto;
import com.troytan.sixpack.service.VideoService;

@RestController
@RequestMapping(path = "/video", produces = "application/json;charset=UTF-8")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 获取主页视频
     *
     * @author troytan
     * @date 2018年10月9日
     * @return
     */
    @GetMapping("/videos")
    public List<VideoMainDto> getVideos() {
        return videoService.listMainVideo();
    }

    @GetMapping("/{videoRcId}")
    public VideoDetailDto getVideoDetail(@PathVariable("videoRcId") Integer videoRcId) {
        return videoService.getVideoDetail(videoRcId);
    }
}
