const { Series } = require('../../models')

module.exports = function (router) {
  // 增加专题
  router.post('/api/blog/add/series', async(ctx) => {
    const data = ctx.request.body
    const linkData = new Series(data)
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

  // 删除专题
  router.post('/api/blog/delete/series', async(ctx) => {
    const classify = ctx.request.body.classify
    const removeResult = Series.remove({classify})
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
        msg: 'classify不存在',
        result: null,
        status: 0,
      }
    }

    ctx.body = result
  })

  // 更新专题
  router.post('/api/blog/update/series', async(ctx) => {
    const data = ctx.request.body
    let result
    await Series.remove({})
    const updateResult = await Series.create(data)
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
        msg: 'classify不存在',
        result: null,
        status: 0,
      }
    }

    ctx.body = result
  })

  // 查询专题
  router.post('/api/blog/get/series', async(ctx) => {
    const data = ctx.request.body
    const docs = await Series.find({}, {_id: false, __v: false}).lean().exec()
    let result
    if (docs) {
      result = {
        code: '',
        msg: '',
        result: {
          list: docs,
        },
        status: 1,
      }
    } else {
      result = {
        code: '1008',
        msg: 'classify不存在',
        result: null,
        status: 0,
      }
    }

    ctx.body = result
  })
}