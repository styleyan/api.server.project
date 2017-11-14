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
  router.get('/api/hao/nav', async (ctx) => {
    const datas = await getData()
    console.log(datas)
    ctx.body = datas
  })
}
