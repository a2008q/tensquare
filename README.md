# tensquare-1024社区

![IDE](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-brightgreen.svg) ![Java](https://img.shields.io/badge/Java-1.8-blue.svg) ![Database](https://img.shields.io/badge/Database-MySQL-lightgrey.svg)

## 运行环境

[jdk1.8] https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

[Mysql5.7] https://dev.mysql.com/downloads/mysql/

[Redis5] https://github.com/tporadowski/redis

[MongoDB] https://www.mongodb.com/try/download/community

[ElasticSearch] https://www.elastic.co/downloads/past-releases/elasticsearch-5-6-8

[RabbitMQ] https://www.rabbitmq.com/

[配置文件] https://github.com/a2008q/tensquare-config

## 实现功能

1. 活动信息和文章的缓存，分别用Redis和Spring Cache实现
2. 吐槽、文章评论使用MongoDB进行存储，减轻Mysql服务器压力
3. 使用ElasticSearch作为社区搜索服务器，为符合中文习惯，使用IK分词器插件
4. 使用RabbitMQ实现用户模块与短信模块的通讯，发送验证码
5. 使用BCrypt对密码进行加密，并使用jwt鉴权
6. 使用SpringCloudConfig将配置放置仓库，并通过消息总线同步

## 开始使用

导入仓库内sql文件夹中的数据，配置上方相关环境，创建/导入对应Maven项目，修改对应配置后使用,短信模块腾讯云短信配置参考下方

## 其他

[代码生成器] https://gitee.com/chuanzhiliubei/codeutil

[腾讯云短信配置文件(txcloud.properties)]

``` properties
sms.appId: 短信应用ID
sms.sign: 短信签名内容
sms.templateId: 短信模板ID
sms.secretId: 账户secretID
sms.secretKey: 账户Key
```
