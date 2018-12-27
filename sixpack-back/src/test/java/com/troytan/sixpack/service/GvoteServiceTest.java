package com.troytan.sixpack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.troytan.sixpack.dto.GvoteResultDto;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GvoteServiceTest {

    @Autowired
    private GvoteService gvoteService;

    @Test
    public void testGetVoteDetail() {
        GvoteResultDto result = gvoteService.getVoteDetail(1);
        System.out.println(result.getGvoteId());
    }
}
