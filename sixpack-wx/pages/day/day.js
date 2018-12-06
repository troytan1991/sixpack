var config = require('../../config.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    detail: null,
    planId: null,
    currentExc: null,
    pause: false,
    excercises: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    config.request({
      url: config.getPlanDetailUrl + options.planId,
      success: function(res) {
        var detail = res.data;
        wx.setNavigationBarTitle({
          title: 'level' + detail.level + ' - ' + detail.trainingDay + "/" + detail.totalDay,
        })
        that.setData({
          excercises: detail.excercises,
          planId: detail.planId,
          detail: detail,
          currentExc: detail.excercises[0],
          videoContext: wx.createVideoContext('videoId')
        })
      }
    })
  },

  onExcTap: function(e) {
    this.setData({
      currentExc: e.currentTarget.dataset.exc,
      pause: false
    })
    this.data.videoContext.play()
  },
  onRestTap: function(e) {
    this.data.videoContext.pause()
    this.setData({
      pause: true
    })
  },
  onCancelMark: function() {
    this.markPlan(0);
  },
  onCompletedMark: function() {
    //标记该训练日
    this.markPlan(2);
  },
  markPlan: function(status) {
    var msg = status === 0 ? '取消标记成功,完成度重置为0%' : '标记完成,完成度已置为100%'
    config.request({
      url: config.markPlanUrl + this.data.planId + "/" + status,
      method: 'PUT',
      success: function() {
        wx.showModal({
          title: '提示',
          content: msg,
          cancelText: "返回",
          confirmText: "继续训练",
          success: function(res) {
            if (!res.confirm) {
              wx.navigateBack({})
            }
          }
        })
      }
    })
  }
})