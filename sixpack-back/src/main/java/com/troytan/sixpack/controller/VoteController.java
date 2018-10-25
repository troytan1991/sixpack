package com.troytan.sixpack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.troytan.sixpack.aspect.NoAuth;
import com.troytan.sixpack.domain.VoteSubject;
import com.troytan.sixpack.dto.VoteResult;
import com.troytan.sixpack.service.VoteService;

@RestController
@RequestMapping(path = "/vote", produces = "application/json;charset=UTF-8")
public class VoteController {

    @Autowired
    private VoteService voteService;

    /**
     * 创建主题
     *
     * @author troytan
     * @date 2018年10月18日
     * @param subject
     * @return
     */
    // @PostMapping("/subject")
    // public int createSubject(@RequestBody VoteSubject subject) {
    // return voteService.createSubject(subject);
    // }

    /**
     * 删除主题
     *
     * @author troytan
     * @date 2018年10月19日
     * @param subjectId
     */
    // @DeleteMapping("/subject/{subjectId}")
    // public void deleteSubject(@PathVariable("subjectId") Integer subjectId) {
    // voteService.deleteSubject(subjectId);
    // }

    /**
     * 获取主题与个人投票信息
     *
     * @author troytan
     * @date 2018年10月18日
     * @param subjectId
     * @return
     */
    @GetMapping("/{subjectId}")
    public VoteSubject getSubject(@PathVariable("subjectId") Integer subjectId) {
        return voteService.getSubject(subjectId);
    }

    /**
     * 获取发起列表
     *
     * @author troytan
     * @date 2018年10月19日
     * @return
     */
    // @GetMapping("/send/subjects")
    // public List<VoteSubject> getSendSubjects() {
    // return voteService.listSendSubject();
    // }

    /**
     * 获取参与列表
     *
     * @author troytan
     * @date 2018年10月19日
     * @return
     */
    // @GetMapping("/participate/subjects")
    // public List<VoteSubject> getParticipateSubject() {
    // return voteService.listPaticipateSubject();
    // }

    /**
     * 投票
     * 
     * @author troytan
     * @date 2018年10月18日
     * @param subjectId
     * @param voteValue 1:正方,2反方
     */
    @PostMapping("/{subjectId}")
    public void voteSubject(@PathVariable("subjectId") Integer subjectId, @RequestParam("value") Short voteValue) {
        voteService.voteSubject(subjectId, voteValue);
    }

    /**
     * 获取投票结果
     *
     * @author troytan
     * @date 2018年10月18日
     * @param subjectId
     * @return
     */
    @CrossOrigin("*")
    @NoAuth
    @GetMapping("/result/{subjectId}")
    public VoteResult getVoteResult(@PathVariable("subjectId") Integer subjectId) {
        return voteService.getVoteResult(subjectId);
    }

}
