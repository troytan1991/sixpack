package com.troytan.sixpack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.troytan.sixpack.domain.Debate;
import com.troytan.sixpack.dto.DebateResult;
import com.troytan.sixpack.service.DebateService;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/debate", produces = "application/json;charset=UTF-8")
public class DebateController {

    @Autowired
    private DebateService debateService;

    /**
     * 创建辩论主题
     *
     * @author troytan
     * @date 2018年10月25日
     * @return
     */
    @PostMapping
    public Integer createDebate(@RequestBody Debate debate) {

        return debateService.createDebate(debate);
    }

    /**
     * 删除辩论主题
     * 
     * @author troytan
     * @date 2018年10月25日
     * @param debateId
     */
    @DeleteMapping("/{debateId}")
    public void deleteDebate(@PathVariable("debateId") Integer debateId) {
        debateService.deleteDebate(debateId);
    }

    /**
     * 辩论投票
     *
     * @author troytan
     * @date 2018年10月25日
     * @param debateId
     */
    @PutMapping("/vote/{debateId}")
    public void voteDebate(@PathVariable("debateId") Integer debateId, @RequestParam("value") Short value) {
        debateService.voteDebate(debateId, value);
    }

    /**
     * 获取辩论详情
     *
     * @author troytan
     * @date 2018年10月25日
     * @param debateId
     * @return
     */
    @GetMapping("/{debateId}")
    public Debate getDebate(@PathVariable("debateId") Integer debateId) {
        return debateService.getDebate(debateId);
    }

    /**
     * 获取所有发送的辩论
     *
     * @author troytan
     * @date 2018年10月25日
     * @return
     */
    @GetMapping("/sendDebates")
    public List<Debate> getSendDebates() {
        return debateService.getSendDebates();
    }

    @GetMapping("/result/{debateId}")
    public DebateResult getDebateResult(@PathVariable("debateId") Integer debateId) {
        return debateService.getDebateResult(debateId);
    }
}
