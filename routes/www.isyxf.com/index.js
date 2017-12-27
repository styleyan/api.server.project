/**
 * www.isyxf.com
 */
const {Article} = require('../../models')
const {createdUuid} = require('../../utils')

 module.exports = function (router) {
   router.post('/api/blog/add', async (ctx) => {
     const data = ctx.request.body
     data.id = createdUuid('www')
     data.createTime = Date.now()
     console.log(data)
     const articleData = new Article(data)
     const saveResult = await articleData.save()
     console.log('l14:', saveResult)
     ctx.body = {
       gg: 'yxf',
       pp: 'wn',
     }
   })
 }