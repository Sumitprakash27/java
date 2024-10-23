-- create database db_sgv; --
use db_sgv;
show tables;
create table students (id int primary key, name varchar(100), mobile_no varchar(20), email_id varchar(100));
desc students;
insert into students values (100,"aman","8363748748","aman@gmail.com");
select * from students;
insert into students values (101, "sumit","7739482836","prakashsumit27nov@gmail.com"); -- If you make a class then you cant make another class with the same name --
insert into students values (102, "Ankit" , "825486486183", "ankitkumar7sept@gmail.com"); -- If you have to insert the data into your sql then you have to use the name of the class to specify the table --
create table users (id int primary key auto_increment , username varchar(100) , password varchar (20) , balance decimal(10,2));
insert into users (username , password , balance) values ("sumit" , "4564" , 12999);
select * from users;


create database db_Users;
use db_Users;
show tables;
create table Users (id int primary key auto_increment, username varchar(100), password varchar (20), balance decimal(10,2));
insert into Users (username, password, balance) values ("Sumit", "1234", 5000);
insert into Users (username, password, balance) values ("Samir", "1234", 4956);
insert into Users (username, password, balance) values ("Sumit tak", "6969", 5611);
select * from Users
update users set balance  = '12500' where id = 3;
delete from users where id = 4;