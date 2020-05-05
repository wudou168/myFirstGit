	create database if not exists studentManage;
	use studentManage;
	
	create table user(
		uid int(10) primary key not null auto_increment comment 'userID',
		uname varchar(20) not null comment 'user姓名',
		upassword varchar(20) unique COMMENT 'user密码',
		uinterests varchar(100) comment 'user爱好'
	)

	create table student(
		sid int(10) primary key not null auto_increment comment '学生ID',
		sno varchar(20) unique comment '学生学号',
		sname varchar(20) not null comment '学生姓名',
		semail varchar(20) comment '学生邮箱',
		sphone_number varchar(20) unique comment '学生电话号码',
		sclass varchar(20) not null comment '学生班级'
	);
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (5, '1007', '王五', 'ww@163.com', '1598898466', '信计19-2班');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (6, '2008', '张飞', 'zf@163.com', '15966456', '蜀国');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (8, '2002', '刘备', 'lb@163.com', '665847', '蜀国');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (9, '2010', '赵云', 'zy@163.com', '9584627', '蜀国');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (10, '2011', '关羽', 'gy@163.com', '6648521', '蜀国');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (11, '2012', '孙权', 'sq@126.com', '9541468', '吴国');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (12, '2013', '周瑜', 'zyu@163.com', '66451187', '吴国');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (13, '6001', '张三', 'zs@163.com', '15900536', '信计19-2班');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (14, '7001', '李四', 'ls@163.com', '15885466', '网络18-2班');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (15, '8001', '李飞', 'lf@163.com', '159005466', '信计19-2班');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (16, '9001', '赵六', 'zl@163.com', '15900966', '通信19-2班');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (17, '6002', '张二', 'ze@163.com', '1585466', '信计19-2班');
INSERT INTO `student` (`sid`, `sno`, `sname`, `semail`, `sphone_number`, `sclass`) VALUES (18, '6003', '李三', 'ls@163.com', '159006666', '网络18-2班');
