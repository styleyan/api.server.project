/**
 * hao.isyxf.com 相关数据增删改查
 */
const mongoose = require('mongoose')
const {mongoHost, mongoPort} = require('../../server.config')
const Navs = require('../../models/hao.isyxf.com/www')
const { createdUuid, random } = require('../../utils')
const moment = require('moment')

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
    Navs.find({}).lean().exec((err, doc) => {
      if (err) {
        result.status = 0
        result.description = err.message
        reject(result)
      } else {
        result.status = 1
        result.result = {
          pageTotal: doc.length,
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
    datas.result.list.forEach((item) => {
      item.createTime = moment(item.createTime).format('YYYY-MM-DD HH:mm:ss')
    })
    ctx.body = datas
  })

  // 添加导航
  router.post('/api/hao/add', async (ctx) => {
    const {data} =  ctx.request.body
    data.createTime = Date.now()
    data.id = createdUuid()
    data.watch = random(3000)
    data.favour = random(3000)
    const navsData = new Navs(data)
    const saveResult = await navsData.save()
    
    ctx.body = {
      status: 1,
    }
  })
}
