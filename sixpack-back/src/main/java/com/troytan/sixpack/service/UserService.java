package com.troytan.sixpack.service;

import com.troytan.sixpack.dto.OauthDto;
import com.troytan.sixpack.dto.UserSessionDto;

public interface UserService {

    String logUser(OauthDto oauthDto);

    Integer getCurrentUser();

    void setCurrentUser(UserSessionDto user);

    void updatePrefer(short gender);

    UserSessionDto getSession(String sessionId);

    UserSessionDto putSession(String sessionId, UserSessionDto user);

    Short getPrefer();

}
