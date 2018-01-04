const mongoose = require('mongoose')
const {Schema} = mongoose

// 建模型
const articleSchema = new Schema({
  "classify": Number,
  "content": String,
  "createTime": Date,
  "id": String,
  "isShow": Boolean,
  "title": String,
  "render": String,
})

module.exports = mongoose.model('Article', articleSchema)