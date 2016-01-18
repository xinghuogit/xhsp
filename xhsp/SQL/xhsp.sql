--数据库的命名全部小写
create database xhspsql;
use xhspsql;
set names gdb;
--创建用户的表格
create table ruser
(
id int primary key auto_increment,
username varchar(40),
password varchar(40),
phone varchar(40),
nickname varchar(16),
addr varchar(255),
rdate datetime,
cpdate datetime
);

--创建商品类别的表格
create table category
(
id int primary key auto_increment,
name varchar(255),
descr varchar(255),
orderby int,
pid int,
isleaf int, #0表示leaf 1表示非leaf
grade int
);

--创建商品信息的表格
create table product
(
id int primary key auto_increment,

);