create table roles (
    id serial primary key,
    name varchar(100)
);

create table rules (
    id serial primary key,
    name varchar(100)
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

create table users (
    id serial primary key,
    name varchar(100),
    role_id int references roles(id)
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


