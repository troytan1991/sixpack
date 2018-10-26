package com.troytan.sixpack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.troytan.sixpack.aspect.NoAuth;
import com.troytan.sixpack.domain.VoteSubject;
import com.troytan.sixpack.dto.GroupDto;
import com.troytan.sixpack.dto.VoteResult;
import com.troytan.sixpack.service.VoteService;

@RestController
@RequestMapping(path = "/vote", produces = "application/json;charset=UTF-8")
public class VoteController {

    @Autowired
    private VoteService voteService;

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
     * 获取发送列表
     *
     * @author troytan
     * @date 2018年10月26日
     * @return
     */
    @GetMapping("/sendVotes")
    public List<VoteSubject> getSendSubjects() {
        return voteService.getSendSubjects();
    }

    /**
     * 删除投票主题
     *
     * @author troytan
     * @date 2018年10月26日
     * @param subjectId
     */
    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable("subjectId") Integer subjectId) {
        voteService.deleteSubject(subjectId);
    }

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

    /**
     * 关联群组
     *
     * @author troytan
     * @date 2018年10月26日
     * @param groupDto
     * @return
     * @throws Exception
     */
    @PostMapping("/group")
    public String registerGroup(@RequestBody GroupDto groupDto) throws Exception {

        return voteService.registerGroup(groupDto);
    }

}
