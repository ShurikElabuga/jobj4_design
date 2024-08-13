create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) values('ноутбук', 90000);
insert into devices(name, price) values('смартфон', 40800);
insert into devices(name, price) values('роутер', 3200);
insert into devices(name, price) values('принтер', 4300);
insert into devices(name, price) values('камера', 1900);
insert into devices(name, price) values('аудиосистема', 3000);
insert into devices(name, price) values('PlayStation', 15000);
insert into devices(name, price) values('Xbox', 51000);
insert into devices(name, price) values('МФУ', 9000);
insert into devices(name, price) values('Часы', 5000);
insert into devices(name, price) values('Наушники', 1000);
insert into devices(name, price) values('Видеорегистратор', 2100);

insert into people(name) values('Василий');
insert into people(name) values('Александр');
insert into people(name) values('Сергей');

insert into devices_people(device_id, people_id) 
	values(1, 1), (2, 1), (3, 1), (5, 1), (8, 1); 
insert into devices_people(device_id, people_id) 
	values(5, 2), (6, 2), (10, 2);
insert into devices_people(device_id, people_id) 
	values(2, 3), (4, 3), (7, 3), (9, 3), (11, 3), (12, 3);

select avg(price) from devices;

select p.name "Имя", avg(d.price) as "Средняя цена девайсов"
	from devices_people as dp
	join people p
	on dp.id = p.id
	join devices d
	on dp.device_id = d.id
group by p.name;

select p.name "Имя", avg(d.price) as "Средняя цена девайсов"
	from devices_people as dp
	join people p
	on dp.id = p.id
	join devices d
	on dp.device_id = d.id
group by p.name
	having avg(d.price) > 5000;