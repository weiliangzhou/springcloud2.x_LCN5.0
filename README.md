# springcloud2.x+lcn5.0
1. 基于springcloud的lcn分布式事务处理
2. 官方文档https://www.txlcn.org/en-us/
##配置TM之前需要准备中间件 JRE1.8+, Mysql5.6+, Redis3.2+
##创建MySQL数据库
1. 创建MySQL数据库, 名称为:tx-manager
```txt
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
```
2. 创建MySQL数据库, 名称为:名称为: bank-a 
```txt
DROP TABLE IF EXISTS `bank_a`;
CREATE TABLE `bank_a`  (
  `money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
INSERT INTO `bank_a` VALUES ('1', '1');
```
3.创建MySQL数据库, 名称为: bank-b
```txt
DROP TABLE IF EXISTS `bank_b`;
CREATE TABLE `bank_b`  (
  `money` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `bank_b` VALUES ('1', '1');
```
##添加完以上配置后启动，
  ```txt
      1.eureka
      2.tx_manager  浏览器访问TxManager管理后台http://localhost:7970，默认密码为:codingapi.
      3.bank-a
      4.bank-b
      5.测试分布式localhost:7071/start?money=70&user=1
  ```    
#作者:二师兄 QQ382308664      
      
      

