module.exports = function(params) {
  return async function(ctx, next) {
    const _userId = ctx.cookies.get('_userId')
    const { url } = ctx.request
    if (_userId || url === '/api/admin/login' || url === '/api/admin/logout') {
      return next()
    }
    ctx.body = {
      status: 0,
      code: '10001',
      errorMsg: '请先登录',
      result: '',
    }
  }
}
