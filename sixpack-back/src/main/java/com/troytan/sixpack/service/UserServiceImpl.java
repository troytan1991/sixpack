package com.troytan.sixpack.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.domain.User;
import com.troytan.sixpack.dto.OauthDto;
import com.troytan.sixpack.dto.UserSessionDto;
import com.troytan.sixpack.repository.UserMapper;
import com.troytan.sixpack.util.SHAUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private ThreadLocal<UserSessionDto> userHolder = new ThreadLocal<>();

    @Autowired
    private UserMapper                  userMapper;
    @Autowired
    private UserService                 userService;

    /**
     * 记录用户认证信息
     *
     * @author troytan
     * @date 2018年10月10日
     * @param oauthDto
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.UserService#logUser(com.troytan.sixpack.dto.OauthDto)
     */
    @Override
    public String logUser(OauthDto oauthDto) {
        User user = userMapper.selectByOpenId(oauthDto.getOpenid());
        if (user == null) {
            // 插入user表
            user = new User();
            user.setOpenId(oauthDto.getOpenid());
            user.setCreateBy(1);
            userMapper.insert(user);
        }
        String shaKey = null;
        try {
            shaKey = SHAUtils.getSha1(oauthDto.getOpenid() + oauthDto.getSession_key());
            userService.putSession(shaKey, new UserSessionDto(user.getUserId(), user.getOpenId(), shaKey));
        } catch (NoSuchAlgorithmException e) {

        }
        return shaKey;
    }

    /**
     * 获取当前用户
     *
     * @author troytan
     * @date 2018年10月10日
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.UserService#getCurrentUser()
     */
    @Override
    public Integer getCurrentUser() {
        return userHolder.get().getUserId();
    }

    /**
     * 更新用户教练
     *
     * @author troytan
     * @date 2018年10月10日
     * @param gender (non-Javadoc)
     * @see com.troytan.sixpack.service.UserService#updatePrefer(short)
     */
    @Override
    public void updatePrefer(short gender) {
        userMapper.updatePreferByUserId(getCurrentUser(), gender);
    }

    /**
     * 获取用户教练性别
     *
     * @author troytan
     * @date 2018年10月10日
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.UserService#getPrefer()
     */
    @Override
    public Short getPrefer() {
        User user = userMapper.selectByPrimaryKey(getCurrentUser());
        if (user != null) {
            return user.getPrefer();
        }
        return null;
    }

    /**
     * 设置当前线程的用户
     *
     * @author troytan
     * @date 2018年10月10日
     * @param user (non-Javadoc)
     * @see com.troytan.sixpack.service.UserService#setCurrentUser(com.troytan.sixpack.dto.UserSessionDto)
     */
    @Override
    public void setCurrentUser(UserSessionDto user) {
        userHolder.set(user);
    }

    /**
     * 缓存授权信息
     *
     * @author troytan
     * @date 2018年10月10日
     * @param sessionId
     * @param user
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.UserService#putSession(java.lang.String, com.troytan.sixpack.dto.UserSessionDto)
     */
    @Override
    @CachePut(value = "session", key = "#sessionId")
    public UserSessionDto putSession(String sessionId, UserSessionDto user) {
        return user;
    }

    /**
     * 从缓存中读取授权信息
     *
     * @author troytan
     * @date 2018年10月10日
     * @param sessionId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.UserService#getSession(java.lang.String)
     */
    @Override
    @Cacheable(value = "session", key = "#sessionId")
    public UserSessionDto getSession(String sessionId) {
        return null;
    }

}
