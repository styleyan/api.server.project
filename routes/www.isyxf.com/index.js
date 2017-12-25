/**
 * www.isyxf.com
 */
const {Article} = require('../../models')

 module.exports = function (router) {
   router.post('/api/blog/add', async (ctx) => {
     console.log(ctx.request.body)
     const lists = await Article.find({}, null, {skip:0, limit:20, sort:{createTime:'desc'}}).lean().exec()
     console.log(lists)
     ctx.body = {
       gg: 'yxf',
       pp: 'wn',
     }
   })
 }