insert into roles (id,name) values (1,'USER');
insert into roles (id,name) values (2,'ADMIN');
insert into roles (id,name) values (3,'ANONYMOUS');

insert into users(id,username,email,password) values(123,'farith','farvher@gmail.com','$2a$10$q3Tg7UdOsUzmgWuBx8fWy.gnUWmQNYeRqhjxAVf0NGr053k/J2uYS');
insert into user_role (user_id, role_id) values (123,1);
insert into contacts(id,user_id,name,last_name,phone,email) values(1,1,'wendy','mantilla','412312312','wendy@email.om');
insert into contacts(id,user_id,name,last_name,phone,email) values(2,1,'issac','mantilla','412312312','wendy@email.om');
insert into contacts(id,user_id,name,last_name,phone,email) values(3,1,'tatiana','mantilla','412312312','wendy@email.om');

