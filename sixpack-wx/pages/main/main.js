var config = require('../../config.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    level: '简单',
    easyVideos: [],
    midVideos: [],
    hardVideos: []
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
    //TODO:获取用户教练信息
    config.request({
      url: config.getPreferUrl,
      success: function(res) {
        if (res.data) {
          that.refreshData()
        } else {
          wx.showModal({
            title: '请选择教练',
            content: '在我的->设置中可以修改教练!',
            cancelText: '帅哥',
            confirmText: '美女',
            success: res => {
              let prefer = res.cancel ? 1 : 2
              config.request({
                url: config.updatePreferUrl + prefer,
                method: 'PUT',
                success: function(res) {
                  that.refreshData()
                }
              })
            }
          })
        }
      }
    });
  },
  refreshData: function() {
    var that = this
    config.request({
      url: config.getVideosUrl,
      success: res => {
        wx.hideLoading()
        let videos = res.data,
          easys = [],
          mids = [],
          hards = []
        for (var i in videos) {
          let video = videos[i]
          switch (video.difficulty) {
            case 1:
              easys.push(video)
              break
            case 2:
              mids.push(video)
              break
            case 3:
              hards.push(video)
              break
          }
        }
        that.setData({
          easyVideos: easys,
          midVideos: mids,
          hardVideos: hards
        })

      }
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
              level: '困难'
            })
          } else {
            that.setData({
              level: '一般'
            })
          }
        })
      } else {
        that.setData({
          level: '简单'
        })
      }
    })
  },
  onVideoTap: function(e) {
    getApp().globalData.formIds.push(e.detail.formId)
    wx.navigateTo({
      url: '/pages/video/video?videoRcId=' + e.currentTarget.dataset.id,
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
    if (getApp().globalData.needRefresh || !this.data.easyVideos) {
      this.refreshData()
      getApp().globalData.needRefresh = false
    }
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {
    var formIds = getApp().globalData.formIds
    if (formIds) {
      config.request({
        url: config.uploadFormIdsUrl,
        method: 'POST',
        data: formIds,
        success: res => {
          if (res.statusCode == 200) {
            getApp().globalData.formIds = []
          }
        }
      })
    }
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {
    var formIds = getApp().globalData.formIds
    if (formIds) {
      config.request({
        url: config.uploadFormIdsUrl,
        method: 'POST',
        data: formIds,
        success: res => {
          if (res.statusCode == 200) {
            getApp().globalData.formIds = []
          }
        }
      })
    }
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