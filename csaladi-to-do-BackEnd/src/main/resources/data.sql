
insert into user
    (username, password, first_name, role)
values
    ('user1', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'Sanyi', 'ROLE_ADMIN');

insert into user
    (username, password, first_name, role)
values
    ('user2', '$2a$04$YDiv9c./ytEGZQopFfExoOgGlJL6/o0er0K.hiGb5TGKHUL8Ebn..', 'Geza', 'ROLE_USER');

insert into tasks(taskname,lead_id) values ('porszivozas',1);
insert into user_tasks_to_do(workers_id,tasks_to_do_id) values (1,1);
insert into user_tasks_to_do(workers_id,tasks_to_do_id) values (2,1);
