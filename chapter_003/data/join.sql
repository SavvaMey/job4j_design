-- Создать таблицы и заполнить их начальными данными
create table departments(
    id serial primary key ,
    name varchar(255)
);

create table employees(
    id serial primary key ,
    name varchar(255),
    department_id int references departments(id)
);

insert into departments(name) values ('it');
insert into departments(name) values ('sell');
insert into departments(name) values ('management');
insert into departments(name) values ('bb');

insert into employees(name, department_id) values ('vova', 1);
insert into employees(name, department_id) values ('nik', 1);
insert into employees(name, department_id) values ('sav', 1);
insert into employees(name, department_id) values ('dmit', 1);
insert into employees(name, department_id) values ('vo', null);

insert into employees(name, department_id) values ('lev', 2);
insert into employees(name, department_id) values ('alex', 2);

insert into employees(name, department_id) values ('petr', 3);
insert into employees(name, department_id) values ('ivan', 3);
--Выполнить запросы с left, rigth, full, cross соединениями
select * from employees e left join departments d on d.id = e.department_id;
select * from employees e right join departments d on d.id = e.department_id;
select * from employees e full join departments d on d.id = e.department_id;
select * from employees e cross join departments d;
--. Используя left join найти работников, которые не относятся ни к одну из департаментов
select * from employees e left join departments d on d.id = e.department_id where e.department_id is null;
--Используя left и right join написать запросы, которые давали бы одинаковый результат.
select * from employees e left join departments d on d.id = e.department_id;
select * from departments d right join  employees e on d.id = e.department_id;
--Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары
create table teens(
    id serial primary key,
    name varchar(255),
    gender varchar(255)
);
insert into teens(name, gender) values ('vova', 'male');
insert into teens(name, gender) values ('dmitr', 'male');
insert into teens(name, gender) values ('ivan', 'male');
insert into teens(name, gender) values ('nik', 'male');

insert into teens(name, gender) values ('alina', 'female');
insert into teens(name, gender) values ('zhena', 'female');
insert into teens(name, gender) values ('nata', 'female');
insert into teens(name, gender) values ('sara', 'female');
select name from teens  cross join departments d;
SELECT t1.name, t2.name FROM teens t1 CROSS JOIN teens t2
WHERE t1.gender <> t2.gender;