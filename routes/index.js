const wwwWebsite = require('./www')

module.exports = function (router) {
  wwwWebsite(router)

  router.get('/', async (ctx, next) => {
    await ctx.render('index/index', {
      title: 'Hello Koa 2!--yxf',
    })
  })
}
