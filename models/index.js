const mongoose = require('mongoose')
const {mongoHost, mongoPort} = require('../server.config')

mongoose.Promise = global.Promise
// 链接数据
mongoose.connect(`mongodb://${mongoHost}:${mongoPort}/myTest`)
// 监听是否链接成功
mongoose.connection.on('connected', () => {
  console.log('MongoDB connected success')
})
// 监听链接失败
mongoose.connection.on('error', () => {
  console.log('MongoDB connected error')
})
// 监听断开
mongoose.connection.on('disconnected', () => {
  console.log('MongoDB connected disconnected')
})

// 导航模型
const Navs = require('./hao.isyxf.com/www')
// 用户模型
const User = require('./admin.isyxf.com/index')
// 文章模型
const Article = require('./www.isyxf.com/index')

module.exports = {
  Navs,
  User,
  Article,
}