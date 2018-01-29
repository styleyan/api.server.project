/**
 * 友情链接建模
 */

const mongoose = require('mongoose')
const {Schema} = mongoose

// 建模
const linkSchema = new Schema({
  "createTime": Date,
  "websiteName": String,
  "websiteUrl": String,
  "classify": Number,
  "classifyName": String,
  "desc": String,
})

module.exports = mongoose.model('Link', linkSchema)