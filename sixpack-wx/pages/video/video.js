var config = require('../../config.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    video: {}
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

    var that = this,
      videoRcId = options.videoRcId
    wx.getSystemInfo({
      success: function(res) {
        that.setData({
          scrollHeight: res.windowHeight - res.windowWidth / 750 * 440
        })
      },
    })
    config.request({
      url: config.getVideoUrl + videoRcId,
      success: res => {
        let video = res.data
        wx.setNavigationBarTitle({
          title: video.chnName,
        })
        that.setData({
          video: video
        })
        /******视频缓存逻辑******** */
        // wx.getStorage({
        //   key: videoRcId,
        //   success: function(res) {
        //     let videoPath = res.data
        //     wx.getSavedFileInfo({
        //       filePath: videoPath,
        //       success: function(res) {
        //         that.setData({
        //           localVideo: videoPath
        //         })
        //       },
        //       fail: function(res) {
        //         that.setData({
        //           localVideo: video.videoUrl
        //         })
        //         that.cacheVideo(video)
        //       }
        //     })
        //   },
        //   fail: function() {
        //     that.setData({
        //       localVideo: video.videoUrl
        //     })
        //     that.cacheVideo(video)

        //   }
        // })
      }
    })
  },
  cacheVideo: function(video) {
    setTimeout(function() {
      config.downloadVideo({
        url: video.videoUrl,
        sessionKey: video.videoRcId,
        success: function(res) {
          console.log(res)
          that.setData({
            localVideo: res
          })
        }
      })
    }, 3000)

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
    var videoContext = wx.createVideoContext("videoId");
    videoContext.play()
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