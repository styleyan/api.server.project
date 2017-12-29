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

  // 删除文章
  router.post('/api/blog/delete/:articleId', async(ctx) => {
    const data = ctx.params
    const removeResult = await Article.remove({id: data.articleId})
    let { result } = removeResult
    let respon
    if (result.ok && result.n) {
      respon = {
        msg: '',
        code: '',
        result: {},
        status: 1
      }
    } else {
      respon = {
        msg: '服务器错误',
        code: '10007',
        result: {},
        status: 0
      }
    }
    ctx.body = respon
  })

  // 更新文章
  router.post('/api/blog/update', async(ctx) => {
    const data = ctx.request.body
    const updateResult = await Article.update({id: data.id}, data)
    let result
    if (updateResult.ok && updateResult.n) {
      result = {
        status: 1,
        msg: '',
        code: '',
        result: {},
      }
    } else {
      result = {
        status: 0,
        msg: '更新失败，检查id是否正确',
        code: '1008',
      }
    }
    ctx.body = result
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
    // TODO: 通过设置find方法第二个参数，排除返回的字段
    const docs = await Article.find({}, {_id: false, __v: false, content: false}, {skip, limit, sort: {createTime: 'desc'}}).lean().exec()
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

  // 查询文章详情
  router.post('/api/blog/detail/:articleId', async(ctx) => {
    const data = ctx.params
    const result = await Article.findOne({id: data.articleId}, {_id: false, __v: false}).exec()
    ctx.body = {
      status: 1,
      msg: '',
      result,
    }
  })
}