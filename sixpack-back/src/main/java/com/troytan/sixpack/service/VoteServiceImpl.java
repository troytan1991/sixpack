package com.troytan.sixpack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.troytan.sixpack.domain.Vote;
import com.troytan.sixpack.domain.VoteSubject;
import com.troytan.sixpack.dto.VoteResult;
import com.troytan.sixpack.repository.VoteMapper;
import com.troytan.sixpack.repository.VoteSubjectMapper;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private UserService       userService;
    @Autowired
    private VoteMapper        voteMapper;
    @Autowired
    private VoteSubjectMapper voteSubjectMapper;

    /**
     * 向主题投票
     *
     * @author troytan
     * @date 2018年10月18日
     * @param subjectId (non-Javadoc)
     * @see com.troytan.sixpack.service.VoteService#voteSubject(java.lang.Integer)
     */

    @Override
    public void voteSubject(Integer subjectId, Short value) {
        Integer userId = userService.getCurrentUser();
        // voteMapper.deleteByUserAndSubjectId(userId, subjectId);

        Vote vote = new Vote();
        vote.setSubjectId(subjectId);
        vote.setUserId(userId);
        vote.setValue(value);
        vote.setCreateBy(userId);
        voteMapper.insert(vote);
    }

    /**
     * 获取投票结果
     *
     * @author troytan
     * @date 2018年10月18日
     * @param subjectId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.VoteService#getVoteResult(java.lang.Integer)
     */
    @Override
    public VoteResult getVoteResult(Integer subjectId) {

        return voteMapper.getVoteResult(subjectId);
    }

    /**
     * 创建投票主题
     *
     * @author troytan
     * @date 2018年10月18日
     * @param subject
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.VoteService#createSubject(com.troytan.sixpack.domain.VoteSubject)
     */
    // @Override
    // public int createSubject(VoteSubject subject) {
    // subject.setCreateBy(userService.getCurrentUser());
    // subject.setStatus((short) 1);
    // voteSubjectMapper.insert(subject);
    // return subject.getSubjectId();
    // }

    /**
     * 获取主题,为空则表示无权限访问
     * 
     * @author troytan
     * @date 2018年10月18日
     * @param subjectId
     * @return (non-Javadoc)
     * @see com.troytan.sixpack.service.VoteService#getSubject(java.lang.Integer)
     */
    @Override
    public VoteSubject getSubject(Integer subjectId) {

        return voteSubjectMapper.getSubjectDto(subjectId, userService.getCurrentUser());
    }

    // @Override
    // public List<VoteSubject> listSendSubject() {
    //
    // return voteSubjectMapper.listByUserId(userService.getCurrentUser());
    // }

    // @Override
    // public List<VoteSubject> listPaticipateSubject() {
    // // TODO Auto-generated method stub
    // return null;
    // }

    /**
     * 删除主题
     *
     * @author troytan
     * @date 2018年10月19日
     * @param subjectId (non-Javadoc)
     * @see com.troytan.sixpack.service.VoteService#deleteSubject(java.lang.Integer)
     */
    // @Override
    // public void deleteSubject(Integer subjectId) {
    // voteSubjectMapper.deleteByUserAndId(subjectId, userService.getCurrentUser());
    // }

}
