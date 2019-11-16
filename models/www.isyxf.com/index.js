const mongoose = require('mongoose')
const {Schema} = mongoose

// 建模型
const articleSchema = new Schema({
  "isShow": Boolean,
  "updateTime": Date,
  "createTime": Date,
  "uuid": String,

  "classify": String,
  "content": String,
  "title": String,
  "render": String,
  "articleId": String,
  "preMore": String,
})

module.exports = mongoose.model('Article', articleSchema)