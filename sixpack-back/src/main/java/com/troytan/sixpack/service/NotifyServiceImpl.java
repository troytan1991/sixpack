package com.troytan.sixpack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.domain.Form;
import com.troytan.sixpack.dto.FormDto;
import com.troytan.sixpack.manager.WechatManager;
import com.troytan.sixpack.repository.FormMapper;

@Service
@Transactional
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private FormMapper    formMapper;
    @Autowired
    private UserService   userService;
    @Autowired
    private WechatManager wechatManager;

    @Override
    public void uploadFormIds(List<String> formIds) {
        Integer userId = userService.getCurrentUser();
        for (String formId : formIds) {
            Form form = new Form();
            form.setCreateBy(userId);
            form.setFormId(formId);
            form.setUserId(userId);
            try {
                formMapper.insert(form);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public int notifyUser() {
        List<FormDto> formDtos = formMapper.listFormId();
        String accessToken = wechatManager.getAccessToken();
        // 遍历发送消息
        return formDtos.parallelStream().mapToInt(formDto -> {
            if (wechatManager.sendTemplateMsg(accessToken, formDto)) {
                // 清除已使用的formId
                formMapper.deleteByPrimaryKey(formDto.getId());
                return 1;
            }
            return 0;
        }).sum();
    }

}
