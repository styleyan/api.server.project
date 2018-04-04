const mongoose = require('mongoose')
const { mongo } = require('../server.config')

mongoose.Promise = global.Promise

/**
 * TODO: mongodb数据库链接有2种
 * ①、mongoose.connect(`mongodb://${mongo.user}:${mongo.pwd}@${mongo.host}:${mongo.port}/${mongo.db}`) 缺点:密码不能出现@字符
 * ②、
 */
mongoose.connect(`mongodb://${mongo.host}:${mongo.port}/${mongo.db}`, {
  user: mongo.user,
  pass: mongo.pwd,
})

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
// 文章模型
const Link = require('./www.isyxf.com/link')
// 专题模型
const Series = require('./www.isyxf.com/series')

module.exports = {
  Navs,
  User,
  Article,
  Link,
  Series,
}