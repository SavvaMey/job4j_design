create database elements_items;

create table roles (
    id serial primary key,
    role varchar(100)
);

create table rules (
    id serial primary key,
    rule varchar(100)
);

create table rules_roles (
    id serial primary key,
    role_id int references roles(id),
    rules_id int references rules(id)
);

create table categories (
    id serial primary key,
    name varchar(100)
);

create table states (
    id serial primary key,
    name varchar(100)
);

create table items (
    id serial primary key,
    name varchar(100),
    categories_id int references categories(id),
    states_id int references states(id),
    user_id int references users(id)
);

create table comments (
    id serial primary key,
    name varchar(100),
    item_id int references items(id)
);

create table attaches (
    id serial primary key,
    name varchar(100),
    item_id int references items(id)
);

create table users (
    id serial primary key,
    name varchar(100),
    role_id int references roles(id)
);

insert into roles(role) values ('guest');
insert into roles(role) values ('admin');

insert into rules(rule) values ('chat');
insert into rules(rule) values ('change');

insert into rules_roles(role_id, rules_id) values (1,1);
insert into rules_roles(role_id, rules_id) values (2,2);

insert into categories(name) values ('warning');
insert into categories(name) values ('usual');

insert into states(name) values ('solved');
insert into states(name) values ('unsolved');

insert into items(name, categories_id, states_id, user_id) values ('first',1,2,1);
insert into items(name, categories_id, states_id, user_id) values ('second',2,1,2);

insert into comments(name) values ('help');
insert into comments(name) values ('delete');

insert into attaches(name) values ('*.txt');
insert into attaches(name) values ('*.txt');

insert into users(name, role_id) values ('ds',1);
insert into users(name, role_id) values ('dss',2);