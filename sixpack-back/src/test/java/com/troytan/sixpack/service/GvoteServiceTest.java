package com.troytan.sixpack.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.troytan.sixpack.domain.GvoteItem;
import com.troytan.sixpack.dto.GvoteDto;
import com.troytan.sixpack.dto.GvoteResultDto;
import com.troytan.sixpack.dto.GvoteResultTitle;
import com.troytan.sixpack.dto.UserSessionDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GvoteServiceTest {

    @Autowired
    private GvoteService gvoteService;
    @Autowired
    private UserService  userService;

    @Before
    public void initUser() {
        userService.setCurrentUser(new UserSessionDto(1, "123134", "aasdfa"));
    }

    @Test
    public void testSaveVote() {
        GvoteDto vote = new GvoteDto();
        vote.setTitle("单元测试1");
        vote.setMulti(false);
        vote.setAnonymous(false);
        List<GvoteItem> items = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            GvoteItem item = new GvoteItem();
            item.setContent("单元测试1-选项" + i);
            items.add(item);
        }
        vote.setVoteItems(items);
        gvoteService.saveVote(vote);
    }

    @Test
    public void testFinishVote() {
        gvoteService.finishVote(1);
    }

    @Test
    public void testDeleteVote() {
        gvoteService.deleteVote(1);
    }

    @Test
    public void testDeleteReceiveVote() {
        gvoteService.deleteReceiveVote(1);
    }

    @Test
    public void testCheckVote() {
        System.out.println(gvoteService.checkVote(1, "abc"));
    }

    @Test
    public void testGetVoteResult() {
        GvoteResultDto result = gvoteService.getVoteResult(1);
        System.out.println(result.getTitle());
    }

    @Test
    public void testGetVoteDetail() {
        GvoteResultDto result = gvoteService.getVoteResult(1);
        System.out.println(result.getTitle());
    }

    @Test
    public void testGetSendVotes() {
        List<GvoteResultTitle> results = gvoteService.getSendVotes();
        System.out.println(results.size());
    }

    @Test
    public void testGetReceiveVotes() {
        List<GvoteResultTitle> results = gvoteService.getReceiveVotes();
        System.out.println(results.size());
    }

    @Test
    public void testUpdateGroupId() {
        String groupId = gvoteService.updateGroupId(1, null);
        System.out.println(groupId);
    }
}
