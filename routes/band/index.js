/**
 * admin 相关数据增加删改查
 */
 module.exports = function (router) {
  // 上传文件
  router.post('/api/data/temp', async (ctx) => {
    ctx.body = {
      success: true,
      message: "测试",
      data: "2333223",
    }
  })

  // 数据预览
  router.get('/api/data/preview', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: {
        preview: [
          [22,77,55],
          [99,00,001],
          [99,00,001],
          [99,00,001]
        ],
        schema: [
          {name: '栏目1', type: ''},
          {name: '栏目2', type: ''},
          {name: '栏目3', type: ''}
        ],
        hasNextPage: false,
      },
    }
  })


  // 数据管理–数据列表
  router.get('/api/data/tableList', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: {
        total: 100,
        pageSize: 10,
        pageNum: 1,
        list: [
          {
            "table_name": "数据表名1",
            "table_id": 12,
            "status": "success",
            "data_source": "local",
            "size": 10024,
            "gmt_create": "2018-03-23 12:23:11",
            "gmt_modify": "2018-03-23 12:23:11",
            "usage_record": "使用记录",
            "creator": "yaxf",
            "org": "导入机构",
            "row_nums": "1000"
          },
          {
            "table_name": "数据表名2",
            "table_id": 13,
            "status": "pending",
            "data_source": "local",
            "size": 10024,
            "gmt_create": "2018-03-23 12:23:11",
            "gmt_modify": "2018-03-23 12:23:11",
            "usage_record": "使用记录",
            "creator": "yaxf",
            "org": "导入机构",
            "row_nums": "1000"
          }
        ],
      },
    }
  })

  // 数据预览
  router.get('/api/data/tablePreview', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: {
        preview: [
          [22,77,55],
          [99,00,001],
          [99,00,001],
          [99,00,001]
        ],
        schema: [
          {name: '栏目1', type: ''},
          {name: '栏目2', type: ''},
          {name: '栏目3', type: ''}
        ],
        hasNextPage: false,
      },
    }
  })

  // 数据管理–表数据编辑
  router.post('/api/data/tableUpdate', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: {},
    }
  })

  // 数据管理–删除表
  router.get('/api/data/tableDelete', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: {},
    }
  })


  // 项目中心–创建项目
  router.post('/api/project/add', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: {},
    }
  })

  // 项目中心–项目树菜单
  router.get('/api/project/tree', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        "create_projects": [
          {
            "id": 1,
            "name": "天启",
            "dags": [
              {
                "id": 23,
                "name": "天启1期"
              },
              {
                "id": 3,
                "name": "天启2期"
              }
            ]
          }
        ],
        "join_projects": [
          {
            "id": 4,
            "name": "攀登者",
            "dags": [
              {
                "id": 5,
                "name": "攀登这1期"
              }
            ]
          }
        ]
      }
    }
  })


  // 项目中心–项目状态
  router.get('/api/project/status', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        "status": "ready",
        "dags": [
          {
            "id": 1,
            "name": "深度学习神经网络",
            "status": "running"
          },
          {
            "id": 2,
            "name": "卷积型神经网络",
            "status": "completed"
          },
          {
            "id": 3,
            "name": "xxxx神经",
            "status": "init"
          }
        ],
        "partners": [
          {
            "id": 1,
            "code": "",
            "name": "招联",
            "role": "",
            "status": "joined"
          },
          {
            "id": 2,
            "code": "",
            "name": "招联aaa",
            "role": "",
            "status": "joined"
          }
        ]
      }
    }
  })


  // 项目中心–参与机构
  router.post('/api/org/list', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: [
        {code: '1', name: '招联aaa', 'party_id': 111},
        {code: '2', name: '招联', 'party_id': 112}
      ],
    }
  })

  // 项目中心–场景选择
  router.get('/api/scenario/list', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: [
        {code: '1', name: '天天分'},
        {code: '2', name: '智查分'}
      ],
    }
  })

  // 项目中心–项目删除
  router.post('/api/project/delete', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: {},
    }
  })

  // 项目中心–场景选择
  router.get('/api/project/list', async (ctx) => {
    ctx.body = {
      success: true,
      message: "",
      data: {
        list: [
          {
            id: '233',
            uuid: 'sdfsdf23',
            name: '天河一期',
            status: 'ready',
            dag_template_code: '模板编码',
            scenario_name: '场景名称',
            creator: 'user_aa',
            creator_name: '张三',
            org_code: '机构编码',
            org_name: '招联aaa机构',
            gmt_create: '2017-11-1 12:20:11',
            gmt_modify: '2017-11-2 09:11:01',
            description: '项目描述, 233',
            // 参与方列表
            partners: [{
              id: 1,
              code: '233',
              party_id: 'sdfs233',
              name: '招联',
              role: 'host',
              status: 'invite',
              data_id: '2333'
            }, {
              id: 2,
              code: '233',
              party_id: 'sdfs233',
              name: '招联aaa',
              role: 'host',
              status: 'invite',
              data_id: '2333'
            }],
          },
        ],
        total: 20,
        pageSize: 10,
        pageNum: 1,
      },
    }
  })

  // 训练平台--学习流详情查询
  router.get('/api/dag/detail', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        "id": 1,
        "name": "天启学习流",
        "dag_conf_yaml": "",
        "gmt_create": "2019-01-11 12:33:22",
        "gmt_modify": "",
        "project_id": 1,
        "project_name": "天启",
        "task_status": "init",
        "dag_template_code": "",
        "scenario_name": "天天分",
        "project_description": "项目名称233",
        "creator": "",
        "creator_name": "",
        "org_code": "",
        "org_name": "",
        "party_id": "",
        "operators": [
          {
            "name": '数据清洗22',
            "operator_code": "",
            "status": "running",
            "inputs": "",
            "outputs": "",
            "id": 122222,
            "operator_params": [
              {
                "code": "aaaa",
                "value": "233",
                "data_type": "",
                "read_only": false,
                "default_value": "",
                "not_null": false,
                "name": "ewwww",
                "description": ""
              },
              {
                "code": "bbb",
                "value": "233",
                "data_type": "",
                "read_only": false,
                "default_value": "233",
                "not_null": false,
                "name": "eee",
                "description": "we"
              }
            ],
          },
          {
            "name": '模型训练33',
            "operator_code": "",
            "status": "running",
            "inputs": "",
            "outputs": "",
            "id": 22222,
            "operator_params": [
              {
                "code": "aaaa",
                "value": "233",
                "data_type": "",
                "read_only": false,
                // placeholder
                "default_value": "请输入xxxx",
                "not_null": false,
                "name": "样本每批个数",
                "description": ""
              },
              {
                "code": "bbb",
                "value": "2222",
                "data_type": "",
                "read_only": false,
                // placeholder
                "default_value": "请输入xxxx",
                "not_null": false,
                "name": "学习率",
                "description": "we"
              }
            ],
          }
        ],
        "partners": [
          {
            "id": 1,
            "code": "",
            "party_id": "",
            "name": "招联aaa",
            "role": "",
            "status": "",
            "data_id": 1
          }
        ],
        "task_current_epoch_num": 39,
        "task_epoch_total": 100
      }
    }
  })

  // 训练进度
  router.get('/api/monitor/dag_task/train_progress', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        "num_epoches": 6,
        "eta": 1,
        "epoch_total": 10
      }
    }
  })

  // 训练平台--项目列表
  router.get('/api/dag/manage', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        my: [
          {code: 0, name: '天启一期'}
        ],
        participation: [
          {code: 1, name: '突破三期'}
        ],
      },
    }
  })


  // 训练平台--运行学习流
  router.post('/api/dag_task/run', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {},
    }
  })

  // 训练平台--学习流停止
  router.post('/api/dag_task/stop', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {},
    }
  })

  // 训练平台--修改模型训练参数
  router.post('/api/operator/update_params', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {},
    }
  })

  // 训练平台--算子任务日志
  router.get('/api/monitor/dag_task/log', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": [
        '# python 作业入口函数为main，代码请写入main 函数中，也可以定义自己的函数，在main函数中调用',
        '# 不需要创建SparkSession，main函数中sparkSession 直接使用',
        '# set spark.driver.memory = 2G'
      ]
    }
  })

  // 训练平台--Loss指标分析
  router.get('/api/monitor/dag_task/loss', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": [
        {
          "epoch": 'sss',
          "iteration": 1,
          "loss": 1
        },
        {
          "epoch": 'sss',
          "iteration": 2,
          "loss": 3
        }
      ]
    }
  })

  // 训练平台--参与方状态
  router.get('/api/monitor/dag_task/partners_progress', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": [
        {
          "code": "xp233",
          "party_id": "b2323",
          "name": "招联",
          "role": "xxxx",
          "task_status": "local_calc"
        },
        {
          "code": "xp233",
          "party_id": "b2323",
          "name": "招联aaa",
          "role": "xxxx",
          "task_status": "aggregate"
        }
      ]
    }
  })

  // 消息记录
  router.get('/api/message/list', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        list: [
          { title: '收到招联aaa科技发来的联邦请求', timer: '2019-8-12 13:00' },
          { title: 'Jack已经接受您发起的联邦请求', timer: '2019-8-12 14:00' },
        ],
        total: 20,
        pageSize: 10,
        pageNum: 1,
        hasNextPage: true,
      },
    }
  })

  /**=====================================模型中心–模型管理========================================**/
  // 获取学习流实例列表
  router.get('/api/model/manager/dag_task/info', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        list: [
          {
            "dag_task_id": "2333",
            "model_name": "深度学习模型",
            "creator": "张三"
          }
        ],
        total: 20,
        pageSize: 10,
        pageNum: 1,
        hasNextPage: true,
      },
    }
  })

  // 模型中心–模型管理-项目列表
  router.get('/api/model/manager/model/info', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        "list": [
          {
            "dag_task_id": "223",
            "uuid": "22",
            "model_name": "深度学习模型v1",
            "creator": "张三",
            "creator_org": "sdf.asd",
            "algo_name": "招联模型类型",
            "generate_time": '2019-12-10 20:11:22',
            'status': 'saved',
            'test_status': 0,
            'version': 'v2',
          },
          {
            "dag_task_id": "332",
            "uuid": "11",
            "model_name": "深度学习模型v2",
            "creator": "李四",
            "creator_org": "sdf.asdff",
            "algo_name": "招联aaa模型类型",
            "generate_time": '2019-11-10 21:10:22',
            'status': 'deployed',
            'test_status': 1,
            'version': 'v1',
          },
          {
            "dag_task_id": "332222",
            "uuid": "21",
            "model_name": "深度学习模型v5",
            "creator": "王五",
            "creator_org": "sdf.asdff",
            "algo_name": "76sdfsdf",
            "generate_time": '2019-11-10 21:10:22',
            'status': 'deployed',
            'test_status': 2,
            'version': 'v6',
          }
        ],
        "total": 20,
        "pageSize": 10,
        "pageNum": 1
      },
    }
  })

  // 模型中心–模型管理-项目列表
  router.post('/api/model/manager/deploy/execute', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": { id: 233 },
    }
  })

  // 模型中心–模型管理-获取模型详情
  router.get('/api/model/manager/model/detail', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        "model_name": "深度学习模型",
        "epoch_times": 1,
        "data_name": "ccc_bbb",
        "fed_num_id": 1,
        "fed_num_x": 1,
        "fed_num_y": 1
      },
    }
  })

  // 发起模型预测
  router.post('/api/model/manager/predict/execute', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        'id': '233',
      },
    }
  })

  // 模型预测结果
  router.get('/api/model/manager/predict/result', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": [
        {
          "data_ids": "233dff",
          "result_fed": 856
        },
        {
          "data_ids": "221dfd",
          "result_fed": 322
        }
      ]
    }
  })

  // 模型预测结果
  router.get('/api/model/manager/predict/result/history', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        "list": [
          {
            "data_ids": "233dff",
            "result_fed": 856
          },
          {
            "data_ids": "221dfd",
            "result_fed": 322
          }
        ],
        "total": 20,
        "pageSize": 10,
        "pageNum": 1
      }
    }
  })

  // 获取最新的测试dag_task_id
  router.get('/api/model/manager/test/new/info', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {
        "dag_task_id": "22222"
      }
    }
  })

  // 验证评估报告(对应页面上【验证报告】
  router.get('/api/validation/report/preview', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": [
        {
          "algo_name": "",
          "data": [
            {
              "chartData": {
                "title": "",
                "coordinates": [
                  {
                    "cum_good": 0,
                    "cum_bad": 4
                  },
                  {
                    "cum_good": 8,
                    "cum_bad": 3
                  }
                ]
              },
              "chartType": "ROC"
            }
          ],
          // 模型id
          "model_id": "aaaaa"
        },
      ]
    }
  })

  // 获取对比测试评估报告
  router.get('/api/model/manager/test/eval/contrast', async (ctx) => {
    debugger
    ctx.body = {
      "success": true,
      "message": "",
      "data": [
        {
          "algo_name": "",
          "data": [
            {
              "chartData": {
                "title": "",
                "coordinates": [
                  {
                    "cum_good": 0,
                    "cum_bad": 0
                  },
                  {
                    "cum_good": 2,
                    "cum_bad": 3
                  }
                ]
              },
              "chartType": "ROC"
            }
          ],
          // 模型id
          "model_test_id": "aaaaa"
        },
        {
          "algo_name": "",
          "data": [
            {
              "chartData": {
                "title": "",
                "coordinates": [
                  {
                    "cum_good": 1,
                    "cum_bad": 0
                  },
                  {
                    "cum_good": 3,
                    "cum_bad": 2
                  }
                ]
              },
              "chartType": "ROC"
            }
          ],
          // 模型id
          "model_test_id": "bbbbb"
        }
      ]
    }
  })

  // 发起测试
  router.post('/api/model/manager/test/launch', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {},
    }
  })

  // 拒绝测试
  router.post('/api/model/manager/test/refuse', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {},
    }
  })

  // 接受测试
  router.post('/api/model/manager/test/accept', async (ctx) => {
    ctx.body = {
      "success": true,
      "message": "",
      "data": {},
    }
  })
 }