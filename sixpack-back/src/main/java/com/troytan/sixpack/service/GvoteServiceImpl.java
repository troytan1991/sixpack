package com.troytan.sixpack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.domain.Gvote;
import com.troytan.sixpack.domain.GvoteReceive;
import com.troytan.sixpack.domain.GvoteResult;
import com.troytan.sixpack.dto.GroupDto;
import com.troytan.sixpack.dto.GvoteDto;
import com.troytan.sixpack.dto.GvoteResultDto;
import com.troytan.sixpack.dto.GvoteResultTitle;
import com.troytan.sixpack.exception.RequestException;
import com.troytan.sixpack.repository.GvoteItemMapper;
import com.troytan.sixpack.repository.GvoteMapper;
import com.troytan.sixpack.repository.GvoteReceiveMapper;
import com.troytan.sixpack.repository.GvoteResultMapper;

@Service
@Transactional
public class GvoteServiceImpl implements GvoteService {

    @Autowired
    private GvoteMapper        voteMapper;
    @Autowired
    private GvoteItemMapper    itemMapper;
    @Autowired
    private GvoteResultMapper  resultMapper;
    @Autowired
    private GvoteReceiveMapper receiveMapper;

    @Autowired
    private UserService        userService;

    /**
     * 投票主题新建
     *
     * @author troytan
     * @date 2018年12月26日
     * @param voteDto
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#saveVote(com.troytan.sixpack.dto.GvoteDto)
     */
    @Override
    public Integer saveVote(GvoteDto voteDto) {
        // tt_gvote表
        voteMapper.insert(voteDto);
        // tt_gvote_item表
        voteDto.getVoteItems().forEach(item -> {
            item.setGvoteId(voteDto.getGvoteId());
            itemMapper.insert(item);
        });
        return voteDto.getGvoteId();
    }

    /**
     * 用户确认投票
     *
     * @author troytan
     * @date 2018年12月26日
     * @param voteResults
     * @param gvoteId (non-Javadoc)
     * @throws RequestException
     * @see com.troytan.sixpack.service.GvoteService#userVote(java.util.List, java.lang.Integer)
     */
    @Override
    public void userVote(List<GvoteResult> voteResults, Integer gvoteId) {
        int userId = userService.getCurrentUser();
        // 校验投票是否已结束
        Gvote gvote = voteMapper.selectByPrimaryKey(gvoteId);
        if (gvote.getFinished()) {
            throw new RequestException("投票已结束");
        }
        // 投票记录表
        voteResults.forEach(item -> {
            item.setUserId(userId);
            resultMapper.insert(item);
        });
        // 接收表记录
        if (gvote.getOwner() != userId) {
            // 如果不为owner，新增接收记录
            GvoteReceive receive = new GvoteReceive();
            receive.setCreateBy(userId);
            receive.setDeleted(false);
            receive.setGvoteId(gvoteId);
            receive.setUserId(userId);

            receiveMapper.insert(receive);
        }
    }

    /**
     * 获取投票结果
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#getVoteResult(java.lang.Integer)
     */
    @Override
    public GvoteResultDto getVoteResult(Integer gvoteId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 获取投票详情
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#getVoteDetail(java.lang.Integer)
     */
    @Override
    public GvoteResultDto getVoteDetail(Integer gvoteId) {

        return voteMapper.selectVoteDetail(gvoteId);
    }

    /**
     * 结束投票
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#finishVote(java.lang.Integer)
     */
    @Override
    public void finishVote(Integer gvoteId) {

        voteMapper.finishVote(gvoteId);
    }

    /**
     * 关联投票主题与群Id
     *
     * @author troytan
     * @date 2018年12月26日
     * @param groupDto
     * @return (non-Javadoc)
     * @throws Exception
     * @see com.troytan.sixpack.service.GvoteService#registerGroup(com.troytan.sixpack.dto.GroupDto)
     */
    @Override
    public String registerGroup(GroupDto groupDto) throws Exception {
        String groupId = userService.registerGroupUser(groupDto);
        Gvote gvote = voteMapper.selectByPrimaryKey(groupDto.getGvoteId());
        if (gvote.getGroupId() == null) {
            gvote.setGroupId(groupId);
            gvote.setUpdateBy(userService.getCurrentUser());

            voteMapper.updateByPrimaryKey(gvote);
        }
        return groupId;
    }

    /**
     * 获取发送列表
     *
     * @author troytan
     * @date 2018年12月26日
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#getSendVotes()
     */
    @Override
    public List<GvoteResultTitle> getSendVotes() {
        List<Integer> ids = voteMapper.listIdByOwner(userService.getCurrentUser());
        return voteMapper.listVoteByIds(ids);
    }

    /**
     * 获取参与列表
     *
     * @author troytan
     * @date 2018年12月26日
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#getReceiveVotes()
     */
    @Override
    public List<GvoteResultTitle> getReceiveVotes() {
        List<Integer> ids = receiveMapper.listIdByReceiver(userService.getCurrentUser());
        return voteMapper.listVoteByIds(ids);
    }

    /**
     * 删除发起的投票
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#deleteVote(java.lang.Integer)
     */
    @Override
    public void deleteVote(Integer gvoteId) {
        voteMapper.deleteByUserAndId(userService.getCurrentUser(), gvoteId);
    }

    /**
     * 校验是否已投票
     *
     * @author troytan
     * @date 2018年12月26日
     * @param gvoteId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#checkVoted(java.lang.Integer)
     */
    @Override
    public Boolean checkVoted(Integer gvoteId) {
        int count = resultMapper.countUserVote(gvoteId, userService.getCurrentUser());
        return count > 0 ? true : false;
    }

}
