/**
 * hao.isyxf.com 相关数据增删改查
 */
const mongoose = require('mongoose')
const {mongoHost, mongoPort} = require('../../server.config')
// 导航模型
const Navs = require('../../models/hao.isyxf.com/www')
// 用户名模型
const User = require('../../models/admin.isyxf.com/index')
const { createdUuid, random } = require('../../utils')
const moment = require('moment')
mongoose.Promise = global.Promise
// 链接数据
mongoose.connect(`${mongoHost}:${mongoPort}/hao_isyxf_com/navs`)

// 监听是否链接成功
mongoose.connection.on('connected', () => {
  console.log('MongoDB connected success')
})

// 监听链接失败
mongoose.connection.on('error', () => {
  console.log('MongoDB connected success')
})

// 监听断开
mongoose.connection.on('disconnected', () => {
  console.log('MongoDB connected disconnected')
})

module.exports = function (router) {
  // 获取列表
  router.post('/api/hao/list', async (ctx) => {
    const paramData = ctx.request.body
    const limit = paramData.pageSize
    let skip
    if (paramData.pageActive > 0) {
      skip = (paramData.pageActive - 1) * paramData.pageSize
    } else {
      skip = 0
    }

    const docs = await Navs.find({}, null, {skip, limit, sort:{createTime:'desc'}}).lean().exec()
    const count = await Navs.count().exec()
    const result = {}

    if (docs) {
      docs.forEach((item) => {
        item.createTime = moment(item.createTime).format('YYYY-MM-DD HH:mm:ss')
      })
      result.status = 1
      result.result = {
        list: docs,
        pageTotal: count,
      }
    } else {
      result.status = 0
      result.errorMsg = '查询失败'
      result.code = '10003'
    }

    ctx.body = result
  })

  // 添加导航
  router.post('/api/hao/add', async (ctx) => {
    const {data} =  ctx.request.body
    data.createTime = Date.now()
    data.id = createdUuid()
    data.watch = random(3000)
    data.favour = random(1500)
    const navsData = new Navs(data)
    const saveResult = await navsData.save()
    
    ctx.body = {
      status: 1,
    }
  })

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
