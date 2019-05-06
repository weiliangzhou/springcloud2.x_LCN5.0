# springcloud-lcn
基于springcloud的lcn分布式事务处理

https://www.txlcn.org/en-us/

demo环境
TM:
###1、配置TM之前需要准备中间件 JRE1.8+, Mysql5.6+, Redis3.2+
###2、创建MySQL数据库, 名称为: tx-manager sql问如下
CREATE TABLE `t_tx_exception`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `unit_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `mod_id` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `transaction_state` tinyint(4) NULL DEFAULT NULL,
  `registrar` tinyint(4) NULL DEFAULT NULL,
  `remark` varchar(4096) NULL DEFAULT  NULL,
  `ex_state` tinyint(4) NULL DEFAULT NULL COMMENT '0 未解决 1已解决',
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
创建MySQL数据库, 名称为: bank-a 
创建MySQL数据库, 名称为: bank-a 
###3、添加完以上配置后启动，
      1.eureka
      2.tx_manager  浏览器访问TxManager管理后台http://localhost:7970，默认密码为:codingapi.
      3.bank-a
      4.bank-b
      
作者:二师兄 QQ382308664      
      
      

