use shop_commerce;

insert into role(code,name) values('ADMIN','Quản trị');
insert into role(code,name) values('USER','Người dùng');

insert into user(username,password,fullname,status,phone,email)
values('admin','123456','Nguyễn Hữu Quang',1,'0123456789','abc@gmail.com');
insert into user(username,password,fullname,status,phone,email)
values('abc','123456','nguyễn văn A',1,'09999999','abc1@gmail.com');
insert into user(username,password,fullname,status,phone,email)
values('abc147','123456','nguyễn văn B',1,'088888888','abc147@gmail.com');

INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);
INSERT INTO user_role(userid,roleid) VALUES (3,2);