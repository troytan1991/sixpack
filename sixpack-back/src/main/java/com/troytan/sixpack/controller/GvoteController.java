package com.troytan.sixpack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.troytan.sixpack.dto.GroupDto;
import com.troytan.sixpack.dto.GvoteDto;
import com.troytan.sixpack.dto.GvoteResultDto;
import com.troytan.sixpack.dto.GvoteResultTitle;
import com.troytan.sixpack.dto.UserVote;
import com.troytan.sixpack.service.GvoteService;

/**
 * "投投是道"相关接口
 * 
 * @author troytan
 * @date 2018年12月26日
 */
@RestController
@RequestMapping("/gvote")
public class GvoteController {

    @Autowired
    private GvoteService gvoteService;

    /**
     * 创建投票主题
     *
     * @author troytan
     * @date 2018年12月26日
     * @param voteDto
     * @return
     */
    @PostMapping
    public Integer createVote(@RequestBody GvoteDto voteDto) {

        return gvoteService.saveVote(voteDto);
    }

    /**
     * 用户投票
     *
     * @author troytan
     * @date 2018年12月26日
     * @param voteResults
     * @param gvoteId
     */
    @PutMapping("/{gvoteId}")
    public void userVote(@RequestBody List<Integer> itemIds, @PathVariable("gvoteId") Integer gvoteId) {

        gvoteService.userVote(itemIds, gvoteId);
    }

    /**
     * 获取投票结果
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId
     * @return
     */
    @GetMapping("/result/{gvoteId}")
    public GvoteResultDto getVoteResult(@PathVariable("gvoteId") Integer gvoteId) {
        return gvoteService.getVoteResult(gvoteId);
    }

    /**
     * 获取投票详情，准备投票
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId
     * @return
     */
    @GetMapping("/{gvoteId}")
    public GvoteResultDto getVoteDetail(@PathVariable("gvoteId") Integer gvoteId) {

        return gvoteService.getVoteDetail(gvoteId);
    }

    /**
     * 结束投票
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId
     */
    @PutMapping("/finish/{gvoteId}")
    public void finishVote(@PathVariable("gvoteId") Integer gvoteId) {

        gvoteService.finishVote(gvoteId);
    }

    /**
     * 获取发送列表
     *
     * @author troytan
     * @date 2018年12月26日
     * @return
     */
    @GetMapping("/sendVotes")
    public List<GvoteResultTitle> getSendVotes() {
        return gvoteService.getSendVotes();
    }

    /**
     * 获取接收列表
     *
     * @author troytan
     * @date 2018年12月26日
     * @return
     */
    @GetMapping("/receiveVotes")
    public List<GvoteResultTitle> getReceiveVotes() {

        return gvoteService.getReceiveVotes();
    }

    /**
     * 删除发起的投票
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId
     */
    @DeleteMapping("/{gvoteId}")
    public void deleteVote(@PathVariable("gvoteId") Integer gvoteId) {

        gvoteService.deleteVote(gvoteId);
    }

    /**
     * 删除接收的投票
     *
     * @author troytan
     * @date 2018年12月27日
     * @param gvoteId
     */
    @DeleteMapping("/receive/{gvoteId}")
    public void deleteReceiveVote(@PathVariable("gvoteId") Integer gvoteId) {

        gvoteService.deleteReceiveVote(gvoteId);
    }

    /**
     * 校验访问权限
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId
     * @return
     */
    @PostMapping("/check/{gvoteId}")
    public Short voteCheck(@PathVariable("gvoteId") Integer gvoteId, @RequestBody GroupDto groupDto) {
        String groupId = gvoteService.updateGroupId(gvoteId, groupDto);
        return gvoteService.checkVote(gvoteId, groupId);
    }

    /**
     * 获取选项的投票人员
     *
     * @author troytan
     * @date 2019年1月2日
     * @param itemId
     * @return
     */
    @GetMapping("/itemResult/{itemId}")
    public List<UserVote> getItemUsers(@PathVariable("itemId") Integer itemId) {

        return gvoteService.getItemUsers(itemId);
    }

}
