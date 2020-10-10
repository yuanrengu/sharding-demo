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

## 逻辑表
水平拆分的数据库（表）的相同逻辑和数据结构表的总称。例：订单数据根据主键尾数拆分为10张表，分别是t_order_0到t_order_9，他们的逻辑表名为t_order。

## 真实表
在分片的数据库中真实存在的物理表。即上个示例中的t_order_0到t_order_9。

## 数据节点
数据分片的最小单元。由数据源名称和数据表组成，例：ds_0.t_order_0。

## 广播表
指**所有的分片数据源中都存在的表**，表结构和表中的数据在每个数据库中均完全一致。适用于数据量不大且需要与海量数据的表进行关联查询的场景，例如：字典表。
  
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
