create database xhsp;
use xhsp;
set names gdb;
--创建用户的表格
create table ruser
(
id int primary key auto_increment,
username varchar(40),
password varchar(40),
phone varchar(40),
auth varchar(20),
name varchar(16),
pid varchar(40),
addr varchar(255),
rdate datetime,
cpdate datetime
);