create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

insert into products (name, producer, count, price)
VALUES ('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price)
VALUES ('product_2', 'producer_2', 15, 32);
insert into products (name, producer, count, price)
VALUES ('product_3', 'producer_3', 8, 115);

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 11, 64);
commit transaction;

begin transaction;
delete from products;
drop table products;
rollback transaction;

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_5', 'producer_5', 17, 45);
savepoint first_savepoint;
delete from products where price = 115;
update products set price = 75 where name = 'product_1';
rollback to first_savepoint;
commit transaction;

select * from products; -- результат на скриншоте 1

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_6', 'producer_6', 27, 145);
insert into products (name, producer, count, price) VALUES ('product_7', 'producer_7', 35, 215);
savepoint second_savepoint;
delete from products where price = 145 or price = 215;
update products set price = 145 where name = 'product_1';
update products set price = 215 where name = 'product_2';

select * from products; -- результат на скриншоте 2

rollback to second_savepoint;
select * from products; -- результат на скриншоте 3
commit transaction;

begin transaction;
insert into products (name, producer, count, price) VALUES ('product_8', 'producer_8', 177, 5);
insert into products (name, producer, count, price) VALUES ('product_9', 'producer_9', 117, 55);
savepoint third_savepoint;
select * from products; -- результат на скриншоте 4

delete from products where price = 115 or price = 215 or price = 145;
update products set price = 75 where name = 'product_1' or name = 'product_5';
savepoint fourth_savepoint;
select * from products; -- результат на скриншоте 5

delete from products;
select * from products; -- результат на скриншоте 6

rollback to third_savepoint;
select * from products; -- результат на скриншоте 7

rollback;
select * from products; -- результат на скриншоте 3





