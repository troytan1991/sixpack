package com.troytan.sixpack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.troytan.sixpack.constant.BusinessConst;
import com.troytan.sixpack.domain.Gvote;
import com.troytan.sixpack.domain.GvoteReceive;
import com.troytan.sixpack.domain.GvoteResult;
import com.troytan.sixpack.dto.GroupDto;
import com.troytan.sixpack.dto.GvoteDto;
import com.troytan.sixpack.dto.GvoteItemResult;
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
        if (gvote.getStatus().equals(BusinessConst.VOTE_STATUS_FINISHED)) {
            throw new RequestException("投票已结束");
        }
        // tt_gvote_result表
        voteResults.forEach(item -> {
            item.setUserId(userId);
            resultMapper.insert(item);
        });
        // tt_gvote_receive表
        GvoteReceive receive = new GvoteReceive();
        receive.setCreateBy(userId);
        receive.setDeleted(false);
        receive.setGvoteId(gvoteId);
        receive.setUserId(userId);

        receiveMapper.insert(receive);
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
        // 获取投票头信息
        int userId = userService.getCurrentUser();
        GvoteResultDto result = voteMapper.selectVoteDetail(gvoteId);
        List<GvoteItemResult> itemResults = itemMapper.listResultByVoteId(gvoteId);
        itemResults.forEach(item -> {
            List<Integer> userIds = item.getUserVotes().stream().map(userVote -> userVote.getUserId()).collect(Collectors.toList());
            item.setMyVote(userIds.contains(userId));
        });
        result.setItemResults(itemResults);
        return result;
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

        voteMapper.updateStatusByUserAndId(userService.getCurrentUser(), gvoteId, BusinessConst.VOTE_STATUS_FINISHED);
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
        voteMapper.updateStatusByUserAndId(userService.getCurrentUser(), gvoteId, BusinessConst.VOTE_STATUS_DELETED);
    }

    /**
     * 删除接收的投票
     *
     * @author troytan
     * @date 2018年12月27日
     * @param gvoteId (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#deleteReceiveVote(java.lang.Integer)
     */
    @Override
    public void deleteReceiveVote(Integer gvoteId) {
        receiveMapper.deleteByUserAndId(userService.getCurrentUser(), gvoteId);
    }

    /**
     * 校验投票状态
     *
     * @author troytan
     * @date 2018年12月27日
     * @param gvoteId
     * @param groupId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.GvoteService#checkVote(java.lang.Integer, java.lang.String)
     */
    @Override
    public Short checkVote(Integer gvoteId, String groupId) {
        int userId = userService.getCurrentUser();
        Gvote vote = voteMapper.selectByPrimaryKey(gvoteId);
        // 获取投票记录
        int count = receiveMapper.countByUserAndVoteId(userService.getCurrentUser(), gvoteId);
        if (groupId == null || vote.getGroupId().equals(groupId)) {
            // groupId不匹配
            if (!vote.getOwner().equals(userId) && count <= 0) {
                // 不是onwer或者接收列表不存在,则无权限访问
                return BusinessConst.VOTE_STATUS_NOAUTH;
            }
        }
        if (vote.getStatus().equals(BusinessConst.VOTE_STATUS_DELETED)) {
            // vote已删除
            return BusinessConst.VOTE_STATUS_DELETED;
        }
        if (vote.getStatus().equals(BusinessConst.VOTE_STATUS_FINISHED)) {
            // vote已结束
            return BusinessConst.VOTE_STATUS_FINISHED;
        }
        if (count > 0) {
            // 已投票
            return BusinessConst.VOTE_STATUS_VOTED;
        }
        // 未投票
        return BusinessConst.VOTE_STATUS_UNVOTE;
    }

    /**
     * 更新groupId
     *
     * @author troytan
     * @date 2018年12月27日
     * @param gvoteId
     * @param groupDto
     * @return (non-Javadoc)
     * @throws Exception
     * @see com.troytan.sixpack.service.GvoteService#updateGroupId(java.lang.Integer, com.troytan.sixpack.dto.GroupDto)
     */
    @Override
    public String updateGroupId(Integer gvoteId, GroupDto groupDto) {
        if (groupDto == null) {
            // groupDto为空，表示从发送/接收列表中进入
            return null;
        }
        String groupId = userService.decreptGroupId(groupDto);
        Gvote gvote = voteMapper.selectByPrimaryKey(gvoteId);
        if (gvote.getGroupId() == null) {
            gvote.setGroupId(groupId);
            gvote.setUpdateBy(userService.getCurrentUser());

            voteMapper.updateByPrimaryKey(gvote);
            return groupId;
        }
        return gvote.getGroupId();
    }

}
