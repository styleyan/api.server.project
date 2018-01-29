const { Link } = require('../../models')
const moment = require('moment')

module.exports = function (router) {
  // 增加友链
  router.post('/api/blog/add/link', async(ctx) => {
    const data = ctx.request.body
    const linkData = new Link(data)
    const saveResult = await linkData.save()
    let result
    if (saveResult) {
      result = {
        msg: '',
        code: '',
        result: {},
        status: 1,
      }
    } else {
      result = {
        msg: '服务器错误',
        code: '1007',
        result: null,
        status: 0
      }
    }
    ctx.body = result
  })

  // 删除友链
  router.post('/api/blog/delete/link', async(ctx) => {
    const uuid = ctx.request.body.uuid
    const removeResult = Link.remove({uuid})
    let result
    if (removeResult) {
      result = {
        code: '',
        msg: '',
        result: {},
        status: 1,
      }
    } else {
      result = {
        code: '1008',
        msg: 'uuid不存在',
        result: null,
        status: 0,
      }
    }

    ctx.body = result
  })

  // 更新友链
  router.post('/api/blog/update/link', async(ctx) => {
    const data = ctx.request.body
    const updateResult = await Link.update({uuid: data.uuid}, data)
    let result
    if (updateResult) {
      result = {
        code: '',
        msg: '',
        result: {},
        status: 1,
      }
    } else {
      result = {
        code: '1008',
        msg: 'uuid不才在',
        result: null,
        status: 0,
      }
    }

    ctx.body = result
  })

  // 查询友链
  router.post('/api/blog/get/link', async(ctx) => {
    const data = ctx.request.body
    const limit = data.pageSize
    let skip
    if (data.pageActive > 0) {
      skip = (data.pageActive - 1) * data.pageSize
    } else {
      skip = 0
    }

    const docs = await Link.find({}, {}, {skip, limit, sort: {createTime: 'desc'}}).lean().exec()
    const count = await Link.count().exec()
    const result = {}
    
    if (docs) {
      docs.forEach((item) => {
        item.createTime = moment(item.createTime).format('YYYY-MM-DD HH:mm:ss')
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
      result.errorMsg = '查询失败',
      result.code = '10003'
    }

    ctx.body = result
  })
}