const mongoose = require('mongoose')
const moment = require('moment')
const Schema = mongoose.Schema

// 建模型
const navSchema = new Schema({
  "websiteUrl": String,
  "websiteName": String,
  "watch": Number,
  "favour": Number,
  "websiteDesc": String,
  "websiteLogo": String,
  "createTime": Date,
  "typeName": String,
  "type": Number,
  "id": String,
})

// 输出模型
module.exports = mongoose.model('Nav', navSchema, 'Navs')
