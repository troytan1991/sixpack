package com.troytan.sixpack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.dto.VideoDetailDto;
import com.troytan.sixpack.dto.VideoMainDto;
import com.troytan.sixpack.repository.UserMapper;
import com.troytan.sixpack.repository.VideoMapper;
import com.troytan.sixpack.repository.VideoRcMapper;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper   videoMapper;
    @Autowired
    private VideoRcMapper videoRcMapper;

    @Autowired
    private UserService   userService;
    @Autowired
    private UserMapper    userMapper;

    @Override
    public List<VideoMainDto> listMainVideo() {
        Integer userId = userService.getCurrentUser();
        Short prefer = null;
        if (userId != null) {
            prefer = userMapper.getPreferByUserId(userId);
        }
        if (prefer == null || prefer <= 0) {
            prefer = 1;
        }

        return videoMapper.listByPrefer(prefer);
    }

    @Override
    public VideoDetailDto getVideoDetail(Integer videoRcId) {

        return videoRcMapper.getVideoDetail(videoRcId);
    }

}
