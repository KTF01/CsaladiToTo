
insert into user
    (username, password, first_name, role)
values
    ('user1', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'Sanyi', 'ROLE_ADMIN');

insert into user
    (username, password, first_name, role)
values
    ('user2', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'Geza', 'ROLE_USER');

insert into tasks(taskname,text,lead_id) values ('porszivozas','Gezukam porszivozzad mar ki a hazat!',1);
insert into tasks(taskname,text,lead_id) values ('takaritas','Geza takaritsd mar ki a hazat!',1);
insert into tasks(taskname,text,lead_id) values ('rendrakas','Sanyikam rakj rendet a feszerben mert budos!',2);
insert into tasks(taskname,text,lead_id) values ('fozes','Sanyikam fozzel valami finomat!',2);
insert into tasks(taskname,text,lead_id) values ('kutya setaltatas','Vidd el a kutyat setalni.',1);

insert into TAGS values(1, 'surgos');
insert into TAGS values(2, 'raer');
insert into TAGS values(3, 'fontos');
insert into TAGS values(4, 'gyorsan');
insert into TAGS values(5, 'karacsony');

INSERT INTO TASKS_TAGS values(1,1);
INSERT INTO TASKS_TAGS values(1,2);
INSERT INTO TASKS_TAGS values(5,3);
INSERT INTO TASKS_TAGS values(4,4);
INSERT INTO TASKS_TAGS values(5,4);

insert into user_tasks_to_do(workers_id,tasks_to_do_id) values (1,1);
insert into user_tasks_to_do(workers_id,tasks_to_do_id) values (2,1);
insert into user_tasks_to_do(workers_id,tasks_to_do_id) values (2,3);
insert into user_tasks_to_do(workers_id,tasks_to_do_id) values (2,4);
insert into user_tasks_to_do(workers_id,tasks_to_do_id) values (1,5);
