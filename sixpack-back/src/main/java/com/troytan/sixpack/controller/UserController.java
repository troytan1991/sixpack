package com.troytan.sixpack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.troytan.sixpack.aspect.NoAuth;
import com.troytan.sixpack.dto.OauthDto;
import com.troytan.sixpack.dto.UserSessionDto;
import com.troytan.sixpack.manager.WechatManager;
import com.troytan.sixpack.service.NotifyService;
import com.troytan.sixpack.service.UserService;

@RestController
@RequestMapping(path = "/user", produces = "application/json;charset=UTF-8")
public class UserController {

    @Autowired
    private UserService   userService;
    @Autowired
    private WechatManager wechatManager;
    @Autowired
    private NotifyService notifyService;

    @GetMapping("/persist")
    @NoAuth
    public String cachePersist() {
        return "persist success";
    }

    /**
     * 用户登录
     *
     * @author troytan
     * @date 2018年10月9日
     * @param code 授权 码
     * @return 认证sessionId
     */

    @PutMapping("/login")
    @NoAuth
    public String getSessionId(@RequestParam("code") String code) {
        OauthDto oauthDto = wechatManager.requestOauth(code);

        return userService.logUser(oauthDto);
    }

    @GetMapping("/check")
    @NoAuth
    public UserSessionDto checkSession(@RequestParam("sessionId") String sessionId) {
        return userService.getSession(sessionId);
    }

    /**
     * 群发通知
     *
     * @author troytan
     * @date 2018年10月12日
     * @return
     */
    @GetMapping("/sendMsg")
    public int sendMsg() {
        // 仅管理员调用
        if (userService.getCurrentUser() != 1) {
            return 0;
        }
        return notifyService.notifyUser();
    }

    /**
     * 获取用户教练
     *
     * @author troytan
     * @date 2018年10月12日
     * @return
     */
    @GetMapping("/prefer")
    public Short getPrefer() {
        return userService.getPrefer();
    }

    /**
     * 更新用户教练
     *
     * @author troytan
     * @date 2018年10月12日
     * @param gender
     */
    @PutMapping("/prefer/{gender}")
    public void updatePrefer(@PathVariable("gender") Short gender) {
        userService.updatePrefer(gender);
    }

    /**
     * 保存formId
     *
     * @author troytan
     * @date 2018年10月12日
     * @param formIds
     */
    @PostMapping("/form")
    public void saveFormIds(@RequestBody List<String> formIds) {
        notifyService.uploadFormIds(formIds);
    }

}
