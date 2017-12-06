const haoWebsite = require('./hao.isyxf.com')
const musicWebsite = require('./music.isyxf.com')

module.exports = function (router) {
  haoWebsite(router)
  musicWebsite(router)

  router.get('/', async (ctx, next) => {
    await ctx.render('index/index', {
      title: 'Hello Koa 2!--yxf',
    })
  })
}
