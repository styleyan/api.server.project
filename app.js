const Koa = require('koa')
const app = new Koa()
const views = require('koa-views')
const json = require('koa-json')
const onerror = require('koa-onerror')
const bodyparser = require('koa-bodyparser')
const logger = require('koa-logger')
const router = require('koa-router')()

require('./routes/index')(router)

// 错误处理中间件
onerror(app)

// 解析参数中间件
app.use(bodyparser({
  enableTypes:['json', 'form', 'text']
}))

app.use(logger())
app.use(json())
app.use(views(__dirname + '/views', {
  extension: 'ejs'
}))

// 日志中间件
app.use(async (ctx, next) => {
  const start = new Date()
  await next()
  const ms = new Date() - start
  console.log(`${ctx.method} ${ctx.url} - ${ms}ms`)
})

// 路由api
app.use(router.routes(), router.allowedMethods())

module.exports = app
