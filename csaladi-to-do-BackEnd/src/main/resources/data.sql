insert into users(id, name, status) values (1,'Sanyi','PARENT');
insert into users(id, name, status) values (3,'Adel','PARENT');
insert into users(id, name, status) values (2,'Alex','CHILD');
insert into tasks(id,taskname,lead_id) values (1,'porszivozas',1);
insert into tasks values(2, 'mosogatás', 3);
insert into comments(id,author,text,task_id) values (1,'Geza','Ez egy comment',1);

insert into users_tasks_to_do values(1,1);

insert into users_tasks_to_do(workers_id,tasks_to_do_id) values (2,1);

