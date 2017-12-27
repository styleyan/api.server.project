/**
 * www.isyxf.com
 */
const { Article } = require('../../models')
const { createdUuid } = require('../../utils')
const moment = require('moment')

module.exports = function (router) {
  // 增加文章
  router.post('/api/blog/add', async(ctx) => {
    const data = ctx.request.body
    data.id = createdUuid('www')
    const articleData = new Article(data)
    const saveResult = await articleData.save()
    ctx.body = {
      gg: 'yxf',
      pp: 'wn',
    }
  })

  // 查询文章列表
  router.post('/api/blog/list', async(ctx) => {
    const data = ctx.request.body
    const limit = data.pageSize
    let skip
    if (data.pageActive > 0) {
      skip = (data.pageActive - 1) * data.pageSize
    } else {
      skip = 0
    }

    const docs = await Article.find({}, null, {skip, limit, sort: {createTime: 'desc'}}).lean().exec()
    const count = await Article.count().exec()
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
}