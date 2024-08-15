create table departments (
	id serial primary key,
	name text
);

create table employees (
	id serial primary key,
	name text,
	dep_id int references departments(id)
);
 
insert into departments(name) 
	values('dep1'), ('dep2'), ('dep3'),('dep4');
insert into employees(name, dep_id) 
	values('Ivan', 1), ('Piter', 1), ('Igor', 2), ('Boris', 3), ('Sergey', 3), ('Dima', null), ('Misha', null);

select * from departments d
	left join employees e on e.dep_id = d.id;

select * from departments d
	right join employees e on e.dep_id = d.id;

select d.name, e.name from departments d
	full join employees e on e.dep_id = d.id;

select e.name, d.name from departments d
	cross join employees e;

-- департаменты без работников

select d.name from departments d
	left join employees e on d.id = e.dep_id
	where e.dep_id is null;

-- вывод одинакового результата

select e.name, d.name from employees e
	left join departments d on e.dep_id = d.id;

select e.name, d.name from departments d
	right join employees e on e.dep_id = d.id;

create table teens(
	id serial primary key,
	name text,
	gender text
);

insert into teens(name, gender)
	values('Саша', 'м'), ('Миша', 'м'),
	('Оля', 'ж'), ('Вася', 'м'), ('Марина', 'ж'),
	('Зина', 'ж'), ('Ирина', 'ж'), ('Олег', 'м');

select distinct t1.name "М", t2.name "Ж",
	(t1.name, t2.name) "ПАРА"
	from teens t1
	cross join teens t2
	where t1.gender = 'м' and t2.gender = 'ж';