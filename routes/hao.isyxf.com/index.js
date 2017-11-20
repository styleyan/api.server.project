/**
 * hao.isyxf.com 相关数据增删改查
 */
const mongoose = require('mongoose')
const {mongoHost, mongoPort} = require('../../server.config')
const Navs = require('../../models/hao.isyxf.com/www')

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

function getData() {
  return new Promise((resolve, reject) => {
    let result = {}
    Navs.find({}, (err, doc) => {
      if (err) {
        result.status = 0
        result.description = err.message
        reject(result)
      } else {
        result.status = 1
        result.result = {
          count: doc.length,
          list: doc,
        }
        resolve(result)
      }
    })
  })
}

module.exports = function (router) {
  // 获取列表
  router.post('/api/hao/list', async (ctx) => {
    const datas = await getData()
    console.log(datas)
    ctx.body = datas
  })

  // 添加导航
  router.post('/api/hao/add', async (ctx) => {
    const {data} =  ctx.request.body
    const navsData = new Navs(data)
    const saveResult = await navsData.save()
    console.log(saveResult)
    ctx.body = {
      status: 1,
    }
  })
}
