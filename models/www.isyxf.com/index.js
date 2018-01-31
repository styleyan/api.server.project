const mongoose = require('mongoose')
const {Schema} = mongoose

// 建模型
const articleSchema = new Schema({
  "classify": String,
  "content": String,
  "createTime": Date,
  "isShow": Boolean,
  "title": String,
  "render": String,
  "articleId": String,
  "preMore": String,
  "updateTime": Date,
  "uuid": String,
})

module.exports = mongoose.model('Article', articleSchema)