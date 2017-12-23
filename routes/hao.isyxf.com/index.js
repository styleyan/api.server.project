/**
 * hao.isyxf.com 相关数据增删改查
 */
const {Navs} = require('../../models')
const { createdUuid, random } = require('../../utils')
const moment = require('moment')

module.exports = function (router) {
  // 获取列表
  router.post('/api/hao/list', async (ctx) => {
    const paramData = ctx.request.body
    const limit = paramData.pageSize
    let skip
    if (paramData.pageActive > 0) {
      skip = (paramData.pageActive - 1) * paramData.pageSize
    } else {
      skip = 0
    }

    const docs = await Navs.find({}, null, {skip, limit, sort:{createTime:'desc'}}).lean().exec()
    const count = await Navs.count().exec()
    const result = {}

    if (docs) {
      docs.forEach((item) => {
        item.createTime = moment(item.createTime).format('YYYY-MM-DD HH:mm:ss')
      })
      result.status = 1
      result.result = {
        list: docs,
        pageTotal: count,
      }
    } else {
      result.status = 0
      result.errorMsg = '查询失败'
      result.code = '10003'
    }

    ctx.body = result
  })

  // 添加导航
  router.post('/api/hao/add', async (ctx) => {
    const {data} =  ctx.request.body
    data.createTime = Date.now()
    data.id = createdUuid()
    data.watch = random(3000)
    data.favour = random(1500)
    const navsData = new Navs(data)
    const saveResult = await navsData.save()
    
    ctx.body = {
      status: 1,
    }
  })
}
