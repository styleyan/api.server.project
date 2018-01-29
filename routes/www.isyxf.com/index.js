/**
 * www.isyxf.com
 */
const { Article } = require('../../models')
const moment = require('moment')

module.exports = function (router) {
  // 增加文章
  router.post('/api/blog/add', async(ctx) => {
    const data = ctx.request.body
    data.updateTime = new Date()
    const articleData = new Article(data)
    const saveResult = await articleData.save()
    let result
    if (saveResult) {
      result = {
        msg: '',
        code: '',
        result: {
          articleId: saveResult.articleId
        },
        status: 1
      }
    } else {
      result = {
        msg: '服务器错误',
        code: '10007',
        result: null,
        status: 0
      }
    }
    console.log('ddddd', result)
    ctx.body = result
  })

  // 更新文章
  router.post('/api/blog/update', async(ctx) => {
    const data = ctx.request.body
    data.updateTime = new Date()
    const updateResult = await Article.update({articleId: data.articleId}, data)
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

  
  // 删除文章
  router.post('/api/blog/delete/:articleId', async(ctx) => {
    const data = ctx.params
    const removeResult = await Article.remove({articleId: data.articleId})
    let respon
    if (removeResult.ok && removeResult.n) {
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
    const docs = await Article.find({}, {_id: false, __v: false, content: false, render: false}, {skip, limit, sort: {createTime: 'desc'}}).lean().exec()
    const count = await Article.count().exec()
    const result = {}

    if (docs) {
      docs.forEach((item) => {
        item.createTime = moment(item.createTime).format('YYYY-MM-DD HH:mm:ss')
        item.updateTime = moment(item.updateTime).format('YYYY-MM-DD HH:mm:ss')
      })
      result.status = 1
      result.result = {
        list: docs,
        pageTotal: count,
        pageActive: data.pageActive,
        pageSize: data.pageSize,
      }
    } else {
      result.status = 0
      result.errorMsg = '查询失败'
      result.code = '10003'
    }

    ctx.body = result
  })

  // 上一条，下一条排除的字段
  const exclude = {
    _id: false, 
    __v: false, 
    preMore: false, 
    content: false, 
    render:false,
    createTime:false,
    classify:false,
    isShow: false,
  }
  // 查询文章详情
  router.post('/api/blog/detail/:articleId', async(ctx) => {
    const data = ctx.params
    const article = await Article.findOne({articleId: data.articleId}, {_id: false, __v: false, preMore: false}).lean().exec()
    const prevTo = await Article.find({'articleId': {'$lt': data.articleId}}, exclude).exec()
    const nextTo = await Article.find({'articleId': {'$gt': data.articleId}}, exclude).exec()
    console.log(article.updateTime)
    article.updateTime = moment(article.updateTime).format('YYYY-MM-DD HH:mm:ss')
    article.createTime = moment(article.createTime).format('YYYY-MM-DD HH:mm:ss')
    ctx.body = {
      status: 1,
      msg: '',
      result: {
        article,
        prevTo: prevTo[0] || null,
        nextTo: nextTo[0] || null,
      },
    }
  })
}