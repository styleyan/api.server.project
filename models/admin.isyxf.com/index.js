const mongoose = require('mongoose')
const Schema = mongoose.Schema

// 建立模型
const userSchema = new Schema({
  "userName": String,
  "userPwd": String,
  "userId": Number,
})

module.exports = mongoose.model('User', userSchema)