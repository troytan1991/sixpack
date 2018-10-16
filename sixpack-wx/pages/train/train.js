var config = require('../../config.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    day: 1,
    cacheVideos: [],
    currentVideo: '',
    totalTime: 0,
    pause: false,
    videos: [{
        url: 'http://troytan1991.club/sixpack/20_male_muscle.mp4',
        repetition: 8,
        sets: 3,
        duration: 3200
      },
      {
        url: 'http://troytan1991.club/sixpack/11_male_muscle.mp4',
        repetition: 8,
        sets: 3,
        duration: 3200
      },
      {
        url: 'http://troytan1991.club/sixpack/07_male_muscle.mp4',
        repetition: 8,
        sets: 3,
        duration: 3200
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var videos = this.data.videos,
      that = this
    for (var i in videos) {
      config.downloadVideo({
        url: videos[i].url,
        sessionKey: i + '',
        success: function(res) {
          console.log(res)
          that.data.cacheVideos.push(res.savedFilePath)
        }
      })
    }

  },
  onUpdate: function(e) {

  },
  onBtnTap: function() {
    var that = this
    setInterval(function() {
      if (!that.data.pause) {
        let totalTime = that.data.totalTime + 100,
          currentVideo, videos = that.data.cacheVideos
        that.setData({
          totalTime: totalTime
        })
        if (totalTime > 0 && totalTime <= 3200 * 2) {
          currentVideo = videos[0]
        } else if (totalTime > 3200 * 2 && totalTime <= 3200 * 5) {
          currentVideo = videos[1]
        } else {
          currentVideo = videos[2]
        }
        if (that.data.currentVideo != currentVideo) {}
        that.setData({
          currentVideo: currentVideo
        })
        let videoContext = wx.createVideoContext("videoId", this)
        setTimeout(function() {
          videoContext.play()
        }, 50)
      }
    }, 100)
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