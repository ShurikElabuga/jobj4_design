create table soldiers(
	id serial primary key,
	name varchar(50)
);

insert into soldiers(name) values('Иванов'), ('Петров'),('Сидоров'),
	('Михалков'), ('Дуров'), ('Максимов'), ('Ляшенко'), ('Борисов'),
	('Баянов'), ('Ахметов'), ('Хилов'), ('Сомов'), ('Чехонин'),
	('Майоров'), ('Ротнов'), ('Мухов'), ('Дубов'), ('Филатов'),
	('Мухаметшин'), ('Фаттахов'), ('Казаков'), ('Купцов'), ('Шицин'),
	('Мошков'), ('Кутепов'), ('Соловьев'), ('Морозов'), ('Гаврилов');

create table battalions(
	id serial primary key,
	name varchar(50)
);

insert into battalions(name) values('Батальон1'), ('Батальон2'), ('Батальон3');

create table companies(
	id serial primary key,
	name varchar(50),
	bat_id int references battalions(id)
);

insert into companies(name, bat_id) values('Рота1', 1),
('Рота2', 1), ('Рота1', 2), ('Рота2', 2),
('Рота1', 3), ('Рота2', 3);

create table platoons(
	id serial primary key,
	name varchar(50),
	com_id int references companies(id)
);

insert into platoons(name, com_id) values('Взвод1', 1),
('Взвод2', 1), ('Взвод1', 2), ('Взвод2', 2), ('Взвод1', 3),
('Взвод2', 3), ('Взвод1', 4), ('Взвод2', 4), ('Взвод1', 5),
('Взвод2', 5), ('Взвод1', 6), ('Взвод2', 6);

create table regiment(
	id serial primary key,
	active boolean default true,
	platoon_id int references platoons(id),
	solder_id int references soldiers(id)
);

insert into regiment(platoon_id, solder_id) 
	values(1, 1), (1, 2), (1, 3), (1, 4), (2, 5), (2, 6), (2, 7), (2, 8), (2, 9), (3, 10), (3, 11), (4, 12), (5, 13),
(5, 14), (5, 15), (6, 16), (6, 17), (6, 18), (6, 19), (6, 20), (6, 21), (6, 22), (6, 23), (7, 24), (7, 25), (7, 26), (8, 27), (8, 28);

-- определение в каком подразделении более трех солдат

select b.name, c.name, p.name, count (s.name)
	from battalions b
	left join companies c on c.bat_id = b.id
	left join platoons p on p.com_id = c.id
	left join regiment r on r.platoon_id = p.id
	left join soldiers s on r.solder_id = s.id
	group by b.name, c.name, p.name
	having count (s.name) > 3;

-- создание представления

	create view which_unit_has_more_than_three_soldiers
	as
select b.name "Батальон", c.name "Рота", p.name "Взвод", count (s.name)
	from battalions b
	left join companies c on c.bat_id = b.id
	left join platoons p on p.com_id = c.id
	left join regiment r on r.platoon_id = p.id
	left join soldiers s on r.solder_id = s.id
	group by b.name, c.name, p.name
	having count (s.name) > 3;


	select * from which_unit_has_more_than_three_soldiers;


