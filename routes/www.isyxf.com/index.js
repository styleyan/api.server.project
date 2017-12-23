/**
 * www.isyxf.com
 */

 module.exports = function (router) {
   router.post('/api/blog/add', async (ctx) => {
     console.log(ctx.request.body)
     ctx.body = {
       gg: 'yxf',
       pp: 'wn',
     }
   })
 }