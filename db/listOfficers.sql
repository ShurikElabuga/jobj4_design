create table rank(
    id serial primary key,
    name varchar(255)
);

create table military(
    id serial primary key,
    name varchar(255),
    rank_id int references rank(id)
);

insert into rank(name) values ('major');
insert into rank(name) values ('captain');
insert into rank(name) values ('lieutenant');
insert into rank(name) values ('colonel');
insert into military(name, rank_id) VALUES ('Ivanov', 2);
insert into military(name, rank_id) VALUES ('Petrov', 1);
insert into military(name, rank_id) VALUES ('Borisov', 3);
insert into military(name, rank_id) VALUES ('Popov', 4);

select m.name, r.name
from military m join rank r on m.rank_id = r.id;

select m.name Имя, r.name Звание
from military m join rank r on m.rank_id = r.id;

select m.name as "Фамилия военнослужащего", r.name as "Воинское звание"
from military m join rank r on m.rank_id = r.id;