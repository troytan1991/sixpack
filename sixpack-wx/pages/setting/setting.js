var config = require('../../config.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    prefer: 0,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    config.request({
      url: config.getPreferUrl,
      success: function(res) {
        that.setData({
          prefer: res.data
        })
      }
    })
  },
  radioChange: function(e) {
    config.request({
      url: config.updatePreferUrl + e.detail.value,
      method: 'PUT',
      success: function(res) {
        getApp().globalData.needRefresh = true
        wx.navigateBack({})
      }
    })
  },


  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})