const haoWebsite = require('./hao.isyxf.com')
const musicWebsite = require('./music.isyxf.com')

module.exports = function (router) {
  haoWebsite(router)
  musicWebsite(router)
}
