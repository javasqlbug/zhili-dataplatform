# zhili-dataplatform

目前国内数据中台建设如火如荼，作为近20年的java开发经验的java程序员老兵，结合多年的数据中台建设经验，

仅以此开源数据中台项目纪念袁隆平先生，以开源精神回馈社区，让数据就像粮食一样，让中小企业有数据可用，数据能吃饱，推动社会多一点点进步！

数据中台项目结构复杂，开发工作量巨大，一般中小创业公司是承担不起独立开发的成本。

本着空谈误国，实干兴邦的宗旨，我们利用工作闲暇时间，来一点一点用程序实现我们的梦想。日积月累，坚持就是胜利！

急需产品人员（Axure等）,前端设计人员（sketch等）、前端开发人员（Vue.js等）一起加入进来。

## zhili-dataplatform数据中台总体架构

见同目录zhili-dataplatform.jpg

为方便国内用户下载，码云地址：https://gitee.com/javasqlbug/zhili-dataplatform.git

## zhili-dataplatform数据中台技术架构

Java后端使用目前主流Spring Cloud Gateway + Spring Cloud Alibaba + Mybatis的Java微服务架构,
数据库使用Mysql，缓存使用Redis,注册中心和配置中心使用Nacos,
底层大数据平台使用Hadoop、Hive、Spark、Flink、HBase等，统一权限底层组件使用Ranger，
账号体系先写入Mysql，最终使用OpenLDAP，底层大数据组件认证以OpenLDAP为中心，
前端使用Vue.js，前后端代码分离。

## zhili-dataplatform数据中台(Go语言版)
目前云原生概念越来越火，Java在大数据生态有越来越被Go超越的趋势，未来将会是Go语言的天下。
云原生基本都是Go生态，后续将会提供zhili-dataplatform-go工程，
将会采用k8s+istio主流Go云原生微服务网格架构开发和部署，敬请期待！
