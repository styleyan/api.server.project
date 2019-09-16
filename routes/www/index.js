/**
 * 首页请求
 */
module.exports = function (router) {
  /**
   * post 请求
   */
  router.post('/api/blog/add', async(ctx) => {
    // 获取 post 请求数据
    const data = ctx.request.body

    ctx.body = {
      msg: '',
      code: '',
      result: {
        'name': 'yxf'
      },
      status: 1
    }
  })

  /**
   * get 请求
   */
  router.get('/api/boxshare', async(ctx) => {
    ctx.body = {
      code: '',
      status: 0,
      data: {
        text: '魔盒分享233111',
      },
    }
  })
}