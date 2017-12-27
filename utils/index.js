module.exports = {
  /**
   * 通过时间戳生成uuid
   */
  createdUuid(pre = '') {
    const second = Number.parseInt(new Date().getTime() / 1000)
    return `${pre}${second.toString(16)}`
  },
  /**
   * 生成随机数
   * @param {Number} max - 最大范围
   */
  random(max = 1500) {
    return Math.ceil(Math.random()*max)
  },
}