/**
 * mongodb定时备份，并把备份压缩打包发送到指定邮箱
 */

require('shelljs/global')
const cronJob = require("cron").CronJob;
const nodemailer = require("nodemailer");
const smtpTransport = require('nodemailer-smtp-transport');
const promiseExec = require('util').promisify(exec)

// 配置 SMTP 连接池
const transport = nodemailer.createTransport(smtpTransport({
  // 主机，各服务商的主机地址不同，比如qq的是smtp.qq.com
  host: "smtp.163.com",
  // 使用 SSL 
  secure: true,
  // 使用 SSL 
  secureConnection: true,
  // 网易的SMTP端口，各个服务商端口号不同，比如qq的是465 
  port: 465,
  // 用户配置
  auth: {
    user: "*********@163.com",
     // 如果是网易邮箱，这个并不是登录密码，而是授权码
    pass: "*********"
  }
}));

// 开启定时任务
new cronJob('*/30 * * * * *', async () => {
  const date = new Date()
  const currDate = `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`
  const dbName = 'myTest'

  // 备份目录
  const dumpDir = '/data/mongodb/dump'
  // 压缩zip名称
  const zipName = `${currDate}.zip`
  // 压缩文件存放地址
  const zipDirName = `./mongodb-backups/${zipName}`
  

  /************************ 备份数据 ***************************/
  const dumpResult = await promiseExec(`mongodump -h 127.0.0.1:27017 -d ${dbName} -o ${dumpDir}`)
  if (dumpResult) {
    console.log('备份错误：', dumpResult)
    return
  }


  /************** 压缩，waait返回的是文件压缩率 ****************/
  await promiseExec(`zip -r ${zipDirName} ${dumpDir}`)

  /******* TODO: 发送邮件,看下sendMail是否有第三个参数 *********/
  transport.sendMail({
    // 发件人地址
    from: "*********<*********@163.com>",
    // 收件人列表,逗号分隔，可以放多个
    to: "*********@qq.com",
    // 设置邮件标题
    subject: `${dbName}数据库备份(${zipName})`,
    // 邮件内容
    html: "<b>该邮件由阿里云服务器发送，请勿回复！</b>",
    // 添加附件
    attachments: [{
      filename: zipName,
      path: zipDirName,
    }],
  }, function(error, response) {
    if (error) {
      console.log('发送邮件错误：', error)
    }
    transport.close();
  })
}, null, true, 'Asia/Shanghai');