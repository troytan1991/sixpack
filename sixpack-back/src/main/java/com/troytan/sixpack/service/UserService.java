package com.troytan.sixpack.service;

import com.troytan.sixpack.domain.User;
import com.troytan.sixpack.dto.GroupDto;
import com.troytan.sixpack.dto.OauthDto;
import com.troytan.sixpack.dto.UserDto;
import com.troytan.sixpack.dto.UserSessionDto;

public interface UserService {

    String logUser(OauthDto oauthDto);

    Integer getCurrentUser();

    void setCurrentUser(UserSessionDto user);

    void updatePrefer(short gender);

    UserSessionDto getSession(String sessionId);

    UserSessionDto putSession(String sessionId, UserSessionDto user);

    Short getPrefer();

    void updateUser(UserDto userDto);

    String registerGroup(GroupDto groupDto) throws Exception;

    String registerGroupUser(GroupDto groupDto) throws Exception;

    String decreptGroupId(GroupDto groupDto);

    User getUser();

}
