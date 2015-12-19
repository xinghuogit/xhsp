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