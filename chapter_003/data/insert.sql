insert into roles(name) values ('guest');
insert into roles(name) values ('admin');

insert into rules(name) values ('chat');
insert into rules(name) values ('change');

insert into rules_roles(role_id, rules_id) values (1,1);
insert into rules_roles(role_id, rules_id) values (2,2);

insert into categories(name) values ('warning');
insert into categories(name) values ('usual');

insert into states(name) values ('solved');
insert into states(name) values ('unsolved');

insert into users(name, role_id) values ('ds',1);
insert into users(name, role_id) values ('dss',2);

insert into items(name, categories_id, states_id, user_id) values ('first',1,2,1);
insert into items(name, categories_id, states_id, user_id) values ('second',2,1,2);

insert into comments(name) values ('help');
insert into comments(name) values ('delete');

insert into attaches(name) values ('*.txt');
insert into attaches(name) values ('*.txt');