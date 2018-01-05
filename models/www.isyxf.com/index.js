const mongoose = require('mongoose')
const {Schema} = mongoose

// 建模型
const articleSchema = new Schema({
  "classify": Number,
  "content": String,
  "createTime": Date,
  "isShow": Boolean,
  "title": String,
  "render": String,
  "articleId": String,
  "preMore": String,
})

module.exports = mongoose.model('Article', articleSchema)