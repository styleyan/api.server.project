# 接口封装统一返回格式
[参考文章](https://blog.csdn.net/qidasheng2012/article/details/86736351)

#### 单条数据
1. 成功
````json
{
    "code": 200,
    "msg": "成功",
    "status": 1,
    "result": {
      "id": "001"
    }
}
````

#### 多条数据
```json
{
  "code": 0, 
  "msg": "成功", 
  "status": 1, 
  "result": {
    "total": 200,
    "currentPage": 2,
    "pageSize": 20,
    "totalPage":10,
    "list": [
      {
        "id": "001"
      }, 
      {
        "id": "002"
      }
    ]
  }
}
```