const mongoose = require('mongoose')
const Schema = mongoose.Schema

// 建模型
const navSchema = new Schema({
  "url": String,
  "name": String,
  "watch": Number,
  "favor": Number,
  "desc": String,
  "logo": String
})

// 输出模型
module.exports = mongoose.model('Nav', navSchema, 'Navs')
