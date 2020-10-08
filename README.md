ShardingSphere 入门demo
# demo
- 数据分片（分表、分库分表）
- 读写分离
- 广播表
- 自定义分库分表策略
- SPI
- 自定义主键生成策略
- 数据脱敏
- 分布式事务

# 环境
| 依赖 | 版本 |
|:-----:|:-----:|
| spring-boot | 2.3.3.RELEASE  |
| sharding-jdbc-spring-boot-starter | 4.1.1   |
| mybatis-spring-boot-starter | 2.1.3 |
| druid | 1.1.23 |

# 数据库
## 用到4个库，每个库两张表
```
db_00
  ├── t_order_0
  └── t_order_1 
db_01
  ├── t_order_0
  └── t_order_1 
db_02
  ├── t_order_0
  └── t_order_1 
db_03
  ├── t_order_0
  └── t_order_1 
```

  
## 建表sql：
```sql
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT DEFAULT NULL,
  `order_id` BIGINT DEFAULT NULL,
  `remark` VARCHAR(50) DEFAULT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT DEFAULT NULL,
  `order_id` BIGINT DEFAULT NULL,
  `remark` VARCHAR(50) DEFAULT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
```
