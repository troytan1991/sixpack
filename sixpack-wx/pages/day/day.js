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
    excStatus: [true], //动作选中状态
    restStatus: [] //休息选中状态
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
        });
        that.setData({
          planId: detail.planId,
          detail: detail,
          currentExc: detail.vocation ? {} : detail.excercises[0],
          videoContext: wx.createVideoContext('videoId')
        });
        // if (!detail.vocation) {
        //   config.downloadVideos({
        //     excercises: detail.excercises,
        //     success: function() {
        //       wx.hideLoading()
        //       that.loadVideo();
        //     }
        //   })
        // }
      }
    })
  },
  loadVideo: function() {
    var detail = this.data.detail
    for (var i in detail.excercises) {
      detail.excercises[i].cachedFile = wx.getStorageSync(detail.excercises[i].videoId + '')
    }
    this.setData({
      detail: detail,
      currentExc: detail.excercises[0]
    })
  },

  onExcTap: function(e) {
    var i = e.currentTarget.dataset.index,
      excStatus = []
    excStatus[i] = true
    this.setData({
      currentExc: e.currentTarget.dataset.exc,
      pause: false,
      excStatus: excStatus,
      restStatus: []
    })
    this.data.videoContext.play()
  },
  onRestTap: function(e) {
    var i = e.currentTarget.dataset.index,
      restStatus = [];
    restStatus[i] = true
    this.data.videoContext.pause()
    this.setData({
      pause: true,
      restStatus: restStatus,
      excStatus: []
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
  },
})