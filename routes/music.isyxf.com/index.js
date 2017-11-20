const axios = require('axios')
module.exports = function (router) {
  router.get('/api/getDiscList', async (ctx, next) => {
    const url = 'https://c.y.qq.com/splcloud/fcgi-bin/fcg_get_diss_by_tag.fcg'
    const response = await axios.get(url, {
      headers: {
        referer: 'https://c.y.qq.com',
        host: 'c.y.qq.com'
      },
      params: ctx.query,
    })
    ctx.body = response.data
  })

  router.get('/api/lyric', async (ctx, next) => {
    const url = 'https://c.y.qq.com/lyric/fcgi-bin/fcg_query_lyric_new.fcg'
    const response = await axios.get(url, {
      headers: {
        referer: 'https://c.y.qq.com',
        host: 'c.y.qq.com'
      },
      params: ctx.query,
    })
  
    let ret = response.data
    if (typeof ret === 'string') {
      var reg = /^\w+\(({[^()]+})\)$/
      var matches = ret.match(reg)
      if (matches) {
        ret = JSON.parse(matches[1])
      }
    }
    ctx.body = ret
  })

  router.get('/api/getSongList', async (ctx, next) => {
    const url = 'https://c.y.qq.com/qzone/fcg-bin/fcg_ucc_getcdinfo_byids_cp.fcg'
    const response = await axios.get(url, {
      headers: {
        referer: 'https://c.y.qq.com',
        host: 'c.y.qq.com'
      },
      params: ctx.query,
    })
  
    let ret = response.data
    if (typeof ret === 'string') {
      let reg = /^\w+\(({[^()]+})\)$/
      const matches = ret.match(reg)
      if (matches) {
        ret = JSON.parse(matches[1])
      }
    }
    ctx.body = ret
  })
  
}