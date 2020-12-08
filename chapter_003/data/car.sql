create table body(
    id serial primary key,
    name varchar(255)
);
create table engine(
    id serial primary key,
    name varchar(255)
);
create table transmission(
    id serial primary key,
    name varchar(255)
);
create table car(
    id serial primary key,
    name varchar(255),
    body_id int references body(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);
insert into body(name) values ('big');
insert into body(name) values ('small');
insert into body(name) values ('hatchback');
insert into body(name) values ('sedan');
insert into body(name) values ('jeep');
insert into body(name) values ('truck');

insert into engine(name) values ('Gas');
insert into engine(name) values ('Diesel');
insert into engine(name) values ('Electric');
insert into engine(name) values ('Steam');

insert into transmission(name) values ('Mechanical');
insert into transmission(name) values ('Automatic');
insert into transmission(name) values ('Variable');
insert into transmission(name) values ('empty');

insert into car(name, body_id, engine_id, transmission_id) values ('volvo', 3, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('Mechanical', 4, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('Mechanical', 4, 3, 3);
-- Вывести список всех машин и все привязанные к ним детали.
SELECT car.name,body.name, engine.name, transmission.name FROM car
INNER JOIN body on car.body_id = body.id
INNER JOIN engine on car.engine_id = engine.id
INNER JOIN transmission on car.transmission_id = transmission.id;

--  Вывести отдельно детали, которые не используются в
--  машине, кузова, двигатели, коробки передач.
select b.name from body b
left join car c on c.body_id = b.id where c.body_id is null;

select e.name from engine e
left join car c on c.engine_id = e.id where c.engine_id is null;

select t.name from transmission t
left join car c on c.transmission_id = t.id where c.transmission_id is null;