CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers
values (1, 'Олег', 'Попов', 23, 'Россия'),
		(2, 'Иван', 'Петров', 32, 'Россия'),
		(3, 'Айзек', 'Азимов', 43, 'США'),
		(4, 'Индира', 'Ганди', 53, 'Индия'),
		(5, 'Андриано', 'Челентано', 86, 'Италия'),
		(6, 'Дитер', 'Болен', 70, 'ФРГ'),
		(7, 'Нарендра', 'Моди', 73, 'Индия'),
		(8, 'Такер', 'Карлсон', 47, 'США'),
		(9, 'Сильвио', 'Берлускони', 84, 'Италия'),
		(10, 'Томас', 'Андерс', 61, 'ФРГ');

select first_name, last_name from customers c1
where c1.age = (select min(age) from customers c2
				where c2.country = c1.country);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders
values (1, 1, 1),
		(2, 3, 2),
		(3, 2, 5),
		(4, 4, 6),
		(5, 2, 8),
		(6, 5, 10);

select first_name, last_name from customers c
where c.id not in (select customer_id from orders);

