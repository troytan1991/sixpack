package com.troytan.sixpack.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.troytan.sixpack.repository.GvoteMapper;

@Component
public class GvoteJob {

    @Autowired
    private GvoteMapper voteMapper;

    /**
     * 每5min轮询一次
     */
    @Scheduled(cron = "0 */5 * * * ?")
    public void voteFinish() {
        voteMapper.updateStatusByEndtime();
    }
}
