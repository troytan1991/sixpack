var config = require('../../config.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    level: '等级一',
    plan_1s: [],
    plan_2s: [],
    plan_3s: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    wx.getSystemInfo({
      success: function(res) {
        that.setData({
          scrollHeight: res.windowHeight - res.windowWidth / 750 * 60
        })
      },
    })
  },
  onWrapScroll: function(e) {
    var queryMid = wx.createSelectorQuery().in(this),
      queryHard = wx.createSelectorQuery().in(this),
      level = this.data.level,
      that = this
    queryMid.select('#mid-line').boundingClientRect()
    queryMid.exec(res => {
      let midTop = res[0].top
      if (midTop < 0) {
        queryHard.select('#hard-line').boundingClientRect()
        queryHard.exec(res => {
          let hardTop = res[0].top
          if (hardTop < 0) {
            that.setData({
              level: '等级三'
            })
          } else {
            that.setData({
              level: '等级二'
            })
          }
        })
      } else {
        that.setData({
          level: '等级一'
        })
      }
    })
  },
  onDayTap: function(e) {
    var item = e.currentTarget.dataset.item;
    if (item.status === null) {
      wx.showToast({
        title: '请完成前一天任务解锁',
        icon: 'none'
      })
      return
    }
    wx.navigateTo({
      url: '/pages/day/day?planId=' + item.planId,
    })
  },
  refreshData: function() {
    var that = this;
    config.request({
      url: config.getPlansUrl,
      success: function(res) {
        var plan1s = [],
          plan2s = [],
          plan3s = [];
        for (var i in res.data) {
          var item = res.data[i];
          switch (item.level) {
            case 1:
              plan1s.push(item)
              break;
            case 2:
              plan2s.push(item)
              break;
            case 3:
              plan3s.push(item)
              break;
          }
        }
        that.setData({
          plan_1s: plan1s,
          plan_2s: plan2s,
          plan_3s: plan3s
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    this.refreshData()
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})