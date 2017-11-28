module.exports = {
  /**
   * 通过时间戳生成uuid
   */
  createdUuid() {
    const second = Number.parseInt(new Date().getTime() / 1000)
    return second.toString(16)
  },
  /**
   * 生成随机数
   * @param {Number} max - 最大范围
   */
  random(max = 1500) {
    return Math.ceil(Math.random()*max)
  },
}