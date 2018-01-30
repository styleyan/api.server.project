/**
 * 专题建模
 */

const mongoose = require('mongoose')
const {  Schema } = mongoose

// 建模
const seriesSchema = new Schema({
  "classify": String,
  "classifyName": String,
  "desc": String,
})

module.exports = mongoose.model('Series', seriesSchema)