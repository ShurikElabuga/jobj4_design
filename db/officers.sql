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
insert into military(name, rank_id) VALUES ('Ivanov', 2);
insert into military(name, rank_id) VALUES ('Petrov', 1);

select * from military;

select * from rank where id in (select rank_id from military);