drop database e_learning;
create database e_learning;
use e_learning;

drop table user1;
CREATE TABLE user1 (
    user_id INT AUTO_INCREMENT,
    name VARCHAR(100),
    phone_no BIGINT,
    email VARCHAR(100),
    address VARCHAR(100),
    reg_date DATE,
    password VARCHAR(100),
    photo LONG,
    PRIMARY KEY (user_id)
);
alter table user1 auto_increment=100;
delete from user1;
insert into 
user1(user_id,name,phone_no,email,address,reg_date,password,photo) 
values(101,'Ankit',4578032208234,'ankit@gmail.com','noida','2021-01-01','ankit','img.jpg');
select * from user1;


drop table contact;
CREATE TABLE contact (
    user_id INT,
    name VARCHAR(30),
    email VARCHAR(30),
    phone_no BIGINT,
    message VARCHAR(30),
    contact_id INT,
    PRIMARY KEY (contact_id),
    FOREIGN KEY (user_id)
        REFERENCES user1 (user_id)
);
delete from contact;
insert into contact(user_id, name,email,phone_no,message,contact_id) values (101, 'Ankit', 'ankit@gmail.com', 1234, 'Message',1);
select * from contact;


drop table admin;
CREATE TABLE admin (
    admin_id INT,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    PRIMARY KEY (admin_id)
);
delete from admin;
insert into admin values(1,'rahul','rahul@gmail.com','pass');
select * from admin;





CREATE TABLE feedback (
    user_id INT,
    name VARCHAR(100),
    email VARCHAR(100),
    f_id INT,
    feedback VARCHAR(100),
    PRIMARY KEY (f_id),
    FOREIGN KEY (user_id)
        REFERENCES user1 (user_id)
);
delete from feedback;
insert into feedback(user_id,name,email,f_id,feedback)values(101,'ankit','ankit@gmail.com',1,'good');
select * from feedback;



CREATE TABLE course (
    course_id INT,
    c_name VARCHAR(100),
    c_desp VARCHAR(100),
    c_fees VARCHAR(100),
    c_resource VARCHAR(100),
    PRIMARY KEY (course_id)
);
delete from course;
insert into course values (111,'JAVA','Programing language','299', 'video.mp4');
select * from course;

