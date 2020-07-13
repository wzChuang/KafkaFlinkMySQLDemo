# Flink从Kafka读取数据存入MySQL
## 运行环境
```
    os Version:win10
    Flink Version:1.6.2
    Kafka Version:0.9.0.0
    MySQL Version:5.6.21

```

## 数据格式
1.74.103.143    2018-12-20 18:12:00    "GET /class/130.html HTTP/1.1"    404    https://search.yahoo.com/search?p=Flink实战


# zookeeper
## 启动zookeeper
命令行输入zkserver(设置好环境变量)
```shell script
> zkserver
```

# kafka

## 启动kafka
kafka 安装目录
```shell script
.\bin\windows\kafka-server-start.bat .\config\server.properties
```
     
## 创建topic
>.\bin\windows\ 目录下
```shell script
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test001
```

## 打开生产者
```shell script
kafka-console-producer.bat --broker-list localhost:9092 --topic test
```

## 打开消费者
```shell script
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test001 --from-beginning
```

# mysql 建表
```mysql
create table log_info(
ID INT NOT NULL AUTO_INCREMENT,
IP VARCHAR(50),
TIME VARCHAR(50),
CourseID VARCHAR(10),
Status_Code VARCHAR(10),
Referer VARCHAR(100),
PRIMARY KEY ( ID )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

```

## 查看表数据
```mysql
select count(*) from log_info;
```
[kafka,zookeeper安装](https://www.cnblogs.com/lnice/p/9668750.html)

[flink清洗数据](https://blog.csdn.net/Gavin_chun/article/details/85132425?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-19.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-19.nonecase)