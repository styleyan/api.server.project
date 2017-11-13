/**
 * hao.isyxf.com 相关数据增删改查
 */
const mongoose = require('mongoose')
const {mongodb} = require('../../server.config')
const Navs = require('../../models/hao.isyxf.com/navs')

// 链接数据
mongoose.connect(`${mongodb.ip}/hao_isyxf_com/navs`)

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
  router.get('/haoApi/example', async (ctx) => {
    const datas = await getData()
    console.log(datas)
    ctx.body = datas
  })
}
