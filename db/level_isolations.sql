create table items (
	id serial primary key,
	type varchar(50),
	producer varchar(50),
	count integer default 0,
	price integer
);

insert into items(type, producer, count, price)
values('type1', 'produser1', 10, 120);
insert into items(type, producer, count, price)
values('type2', 'produser2', 20, 110);
insert into items(type, producer, count, price)
values('type1', 'produser2', 100, 130);
insert into items(type, producer, count, price)
values('type3', 'produser3', 50, 100);
insert into items(type, producer, count, price)
values('type2', 'produser3', 30, 90);
insert into items(type, producer, count, price)
values('type4', 'produser1', 90, 80);
