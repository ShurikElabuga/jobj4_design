create table car_bodies (
	id serial primary key,
	name text
);

create table car_engines (
	id serial primary key,
	name text
);

create table car_transmissions (
	id serial primary key,
	name text
);

create table cars (
	id serial primary key,
	name text,
	body_id int references car_bodies(id),
	engine_id int references car_engines(id), 
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values('седан'), ('пикап'),
	('внедорожник'),  ('кроссовер'), ('хэтчбек'),
	('универсал'), ('лифтбек'), ('минивен'), ('купе');

insert into car_engines(name) values('бензин_4'),
	('бензин_V6'), ('дизель_4'), ('дизель_V8'),
	('электрический'), ('гибрид');

insert into car_transmissions(name) values('M5'), ('M6'), ('A6'),
	('A8'), ('R7'), ('V');

insert into cars(name, body_id, engine_id, transmission_id)
	values ('Nissan', 3, 4, 4), ('KIA', 5, 1, 2),
			('Toyota', 1, 1, 6), ('Mitsubishi', 2, 2, 2),
			('Hyundai', 4, 3, 5), ('Wolksvagen', 6, 1, 5),
			('Nissan', 1, 1, 6), ('Opel', 8, 3, 2),
			('Nissan', null, 3, 4), ('KIA', 1, null, 2),
			('Toyota', 4, 3, null), ('Toyota', 3, 2, null);

select c.name as car_name, b.name as body_name, e.name as engine_name, tr.name as transmission_name
	from cars c
	left join car_bodies b on c.body_id = b.id
	left join car_engines e on c.engine_id = e.id
	left join car_transmissions tr on c.transmission_id = tr.id;

select b.name from car_bodies b
	left join cars cr on b.id = cr.body_id
	where cr.id is null;

select e.name from car_engines e
	left join cars cr on e.id = cr.engine_id
	where cr.id is null;

select tr.name from car_transmissions tr
	 left join cars cr on tr.id = cr.transmission_id
	 where cr.id is null;


