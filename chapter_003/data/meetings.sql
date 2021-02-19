create table meetings (
    id serial primary key,
    name varchar(255)
);

create table users (
    id serial primary key,
    name varchar(255)
);

create table user_meeting (
    user_id int references users(id),
    meeting_id int references meetings(id),
    status varchar(255),
    CONSTRAINT order_details_pk PRIMARY KEY (user_id, meeting_id)
);
insert into users(name) values ('sav');
insert into users(name) values ('savva');
insert into users(name) values ('koja');
insert into users(name) values ('sas');
insert into users(name) values ('ivan');
insert into users(name) values ('zxcv');
insert into users(name) values ('qwer');
insert into users(name) values ('opa');

insert into meetings(name) values ('arch_meet');
insert into meetings(name) values ('debian_meet');
insert into meetings(name) values ('ubuntu_meet');
insert into meetings(name) values ('win_meet');

insert into user_meeting(user_id, meeting_id, status) values (1, 2, 'ok');
insert into user_meeting(user_id, meeting_id, status) values (1, 3, 'no');
insert into user_meeting(user_id, meeting_id, status) values (2, 4, 'ok');
insert into user_meeting(user_id, meeting_id, status) values (3, 4, 'ok');
insert into user_meeting(user_id, meeting_id, status) values (3, 1, 'no');
insert into user_meeting(user_id, meeting_id, status) values (4, 4, 'ok');
insert into user_meeting(user_id, meeting_id, status) values (5, 4, 'ok');
insert into user_meeting(user_id, meeting_id, status) values (5, 2, 'no');
insert into user_meeting(user_id, meeting_id, status) values (6, 1, 'ok');
insert into user_meeting(user_id, meeting_id, status) values (7, 3, 'no');
insert into user_meeting(user_id, meeting_id, status) values (8, 4, 'ok');