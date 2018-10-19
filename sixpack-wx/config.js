// var root = "https://troytan.club/sixpack/rest"; //prod
// var root = "http://106.14.134.6:8081/sixpack/rest"; //qa
var root = "http://localhost:8080/sixpack/rest"; //dev
var config = {
  loginUrl: `${root}/user/login`,
  updateUserUrl: `${root}/user`,
  getVideosUrl: `${root}/video/videos`,
  getVideoUrl: `${root}/video/`,
  getPreferUrl: `${root}/user/prefer`,
  updatePreferUrl: `${root}/user/prefer/`,
  uploadFormIdsUrl: `${root}/user/form`,

  //封装的请求
  request: function({
    url,
    method = 'GET',
    data = {},
    success,
    showLoading = false
  }) {
    wx.showNavigationBarLoading()
    if (showLoading) {
      wx.showLoading({
        title: '请求数据中...',
        mask: true
      })
    }
    var that = this
    //拼接请求url
    var sessionStr = sessionStr = url.indexOf("?") == -1 ? "?sessionId=" : "&sessionId="
    wx.getStorage({
      key: 'sessionId',
      success: function(res) {
        wx.request({
          url: url + sessionStr + res.data, //带有sessionId的url
          method: method,
          data: data,
          success: function(res) {
            if (res.statusCode == 401) {
              //授权失败，则重新登录
              that.login(function(res) {
                wx.request({
                  url: url + sessionStr + res.data,
                  method: method,
                  data: data,
                  success: function(res) {
                    if (res.statusCode < 300) {
                      that.clearLoading()
                      success(res)
                    } else {
                      that.processError(res)
                    }
                  }
                })
              })
            } else if (res.statusCode < 300) {
              that.clearLoading()
              success(res)
            } else {
              that.processError(res)
            }
          },
          fail: function() {
            that.processFail()
          }
        })
      },
      fail: function() {
        //获取失败，则重新登录
        that.login(function(res) {
          wx.request({
            url: url + sessionStr + res.data,
            method: method,
            data: data,
            success: function(res) {
              if (res.statusCode < 300) {
                that.clearLoading()
                success(res)
              } else {
                that.processError(res)
              }
            },
            fail: function() {
              that.processFail()
            }
          })
        })
      }
    })
  },

  login: function(succCallback) {
    wx.login({
      success: res => {
        wx.request({
          url: config.loginUrl + "?code=" + res.code,
          method: 'PUT',
          success: res => {
            if (res.statusCode < 300) {
              wx.setStorageSync("sessionId", res.data)
              if (succCallback) {
                succCallback(res)
              }
            } else {
              that.processError(res)
            }
          }
        })
      },
      fail: function() {
        that.processFail()
      }
    })
  },
  processFail: function() {
    this.clearLoading()
    this.alertMsg('网络不佳,请稍后再试')
  },
  processError: function(res) {
    this.clearLoading()
    // this.alertMsg(res.data.message)
  },
  alertMsg: function(msg) {
    if (!msg) {
      msg = '未知错误'
    }
    wx.showToast({
      title: msg,
      icon: 'none'
    })
  },
  clearLoading: function() {
    wx.hideLoading()
    wx.hideNavigationBarLoading()
  },
  //后台缓存视频
  downloadVideo: function({
    url,
    sessionKey,
    success
  }) {
    wx.getSavedFileList({
      //缓存空间清理
      success: res => {
        console.log(res)
        let fileList = res.fileList.sort(function(a, b) {
          return a.createTime - b.createTime
        })
        if (fileList.length > 4) {
          for (var index = 0; index < 4; index++) {
            console.log("清理文件")
            wx.removeSavedFile({
              filePath: fileList[index].filePath,
            })
          }
        }
      }
    })
    wx.downloadFile({
      url: url,
      success: function(res) {
        wx.saveFile({
          tempFilePath: res.tempFilePath,
          success: function(res) {
            wx.setStorage({
              key: sessionKey + '',
              data: res.savedFilePath,
              success: function() {
                console.log("缓存成功")
                success(res)
              }
            })
          }
        })
      }
    })
  }

};
module.exports = config