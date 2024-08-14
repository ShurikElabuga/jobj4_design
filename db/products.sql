create table type (
	id serial primary key,
	name text
);

create table product (
	id serial primary key,
	name text,
	type_id int references type (id),
	expired_date date,
	price float
);

insert into type(name) values('СЫР'), ('МОЛОКО'), ('МОРОЖЕНОЕ'), ('КОЛБАСА');

insert into product(name, type_id, expired_date, price)
	values('адыгейский', 1, '2024-08-13', 320);
insert into product(name, type_id, expired_date, price)
	values('пошехонский', 1, '2024-08-15', 550);
insert into product(name, type_id, expired_date, price)
	values('плавленный', 1, '2024-08-21', 150);
insert into product(name, type_id, expired_date, price)
	values('тильзитер', 1, '2024-08-31', 600);
insert into product(name, type_id, expired_date, price)
	values('маасдам', 1, '2024-08-30', 850);
insert into product(name, type_id, expired_date, price)
	values('сметанковый', 1, '2024-08-28', 660);
insert into product(name, type_id, expired_date, price)
	values('пармезан', 1, '2024-08-28', 1100);
insert into product(name, type_id, expired_date, price)
	values('с плесенью', 1, '2024-08-12', 990);
insert into product(name, type_id, expired_date, price)
	values('российский', 1, '2024-08-19', 590);
insert into product(name, type_id, expired_date, price)
	values('голландский', 1, '2024-08-23', 480);
insert into product(name, type_id, expired_date, price)
	values('моцарелла', 1, '2024-08-30', 780);
insert into product(name, type_id, expired_date, price)
	values('мраморный', 1, '2024-08-30', 640);

insert into product(name, type_id, expired_date, price)
	values('молоко-2.5%', 2, '2024-08-13', 80);
insert into product(name, type_id, expired_date, price)
	values('молоко-3.2%', 2, '2024-08-23', 90);
insert into product(name, type_id, expired_date, price)
	values('молоко-1.5%', 2, '2024-08-20', 75);

insert into product(name, type_id, expired_date, price)
	values('эскимо', 3, '2024-08-23', 100);
insert into product(name, type_id, expired_date, price)
	values('пломбир', 3, '2024-08-23', 120);
insert into product(name, type_id, expired_date, price)
	values('сливочное мороженое', 3, '2024-08-13', 80);
insert into product(name, type_id, expired_date, price)
	values('мороженое шоколадное', 3, '2024-08-30', 110);

insert into product(name, type_id, expired_date, price)
	values('сервелат', 4, '2024-08-23', 700);
insert into product(name, type_id, expired_date, price)
	values('молочная', 4, '2024-08-30', 550);
insert into product(name, type_id, expired_date, price)
	values('докторская', 4, '2024-08-20', 600);
insert into product(name, type_id, expired_date, price)
	values('охотничья', 4, '2024-08-23', 800);
insert into product(name, type_id, expired_date, price)
	values('салями', 4, '2024-08-23', 1100);
insert into product(name, type_id, expired_date, price)
	values('краковская', 4, '2024-08-23', 1100);

select * from product where type_id = 1;

select * from product where name like '%мороженое%';

select *from product where expired_date < '2024-08-14';

select max(price) from product;

select name from product where price = (select max(price) from product);

select type.name as "Имя типа", count(product.id) as "Количество"
from product
join type
on product.type_id = type.id
group by type.name;

select * from product where type_id = 1 or type_id = 2;

select type.name as "Имя типа", count(product.id) as "Количество"
from product
join type
on product.type_id = type.id
group by type.name
	having count(product.id) < 10;

select product.name as "Название продукта", type.name as "Тип продукта"
from product
join type on product.type_id = type.id;
