ShardingSphere 入门demo

# 环境
| 依赖 | 版本 |
|:-----:|:-----:|
| spring-boot | 2.3.3.RELEASE  |
| sharding-jdbc-spring-boot-starter | 4.1.1   |
| mybatis-spring-boot-starter | 2.1.3 |
| druid | 1.1.23 |

# 数据库
## 用到4个库，每个库两张表
- db_00
  - t_order_0
  - t_order_1
- db_01
  - t_order_0
  - t_order_1  
- db_02
  - t_order_0
  - t_order_1  
- db_03
  - t_order_0
  - t_order_1  
  
## 建表sql：
```sql
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
```
