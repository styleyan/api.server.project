/**
 * admin 相关数据增加删改查
 */
const { User } = require('../../models')

 module.exports = function (router) {
  // 登录
  router.post('/api/admin/login', async (ctx) => {
    const param = {...ctx.request.body}
    const query = await User.findOne(param).exec()
    let responsData = {}
    if (query) {
      responsData.status = 1
      responsData.result = {
        userName: query.userName
      }
      ctx.cookies.set('_userId', query.userId, {
        path: '/',
        maxAge: 10 * 60 * 1000 * 1000,
        httpOnly: false,
        overwrite: false
      })
    } else {
      responsData.status = 0
      responsData.errorMsg = '用户名/密码错误'
      responsData.code = '10002'
    }
    ctx.body = responsData
  })

  // 登出
  router.post('/api/admin/logout', async (ctx) => {
    ctx.cookies.set('_userId', '', {
      path: '/',
      maxAge: -1,
    })
    ctx.body = {
      status: 1,
    }
  })
 }