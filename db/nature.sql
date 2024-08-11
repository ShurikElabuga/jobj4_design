create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);
insert into fauna(name, avg_age, discovery_date) values('bird1', 3650, '1951-08-02');
insert into fauna(name, avg_age, discovery_date) values('bird2', 8000, '1850-05-09');
insert into fauna(name, avg_age, discovery_date) values('bird3', 12000, '1900-01-12');
insert into fauna(name, avg_age, discovery_date) values('fish1', 9000, '1890-06-21');
insert into fauna(name, avg_age, discovery_date) values('fish2', 11000, '1890-07-30');
insert into fauna(name, avg_age, discovery_date) values('fish3', 15000, '1970-09-01');
insert into fauna(name, avg_age, discovery_date) values('deciduata1', 30000, '1910-10-10');
insert into fauna(name, avg_age, discovery_date) values('deciduata2', 15000, '1912-12-12');
insert into fauna(name, avg_age, discovery_date) values('deciduata3', 13000, '1960-11-28');

select * from fauna where name like 'fish%';
select * from fauna where avg_age >= 10000 and avg_age <= 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';