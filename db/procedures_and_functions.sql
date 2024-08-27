create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);


create
or replace procedure insert_data(i_name varchar, prod varchar, i_count integer, i_price integer)
language 'plpgsql'
as $$
    BEGIN
        insert into products (name, producer, count, price)
        values (i_name, prod, i_count, i_price);
    END
$$;

call insert_data('product_2', 'producer_2', 15, 32);
call insert_data('product_1', 'producer_1', 3, 50);
call insert_data('product_3', 'producer_3', 8, 115);
call insert_data('product_4', 'producer_1', 5, 25);
call insert_data('product_5', 'producer_3', 12, 135);

create
or replace procedure delete_data(u_id integer)
language 'plpgsql'
as $$
    BEGIN
        delete from products
        where id = u_id;
    END
$$;

call delete_data(2);
call delete_data(5);

create
or replace function f_delete_data(u_id integer)
returns void
language 'plpgsql'
as
$$
    begin
        delete from products
        where id = u_id and price < 115;
    end;
$$;

select f_delete_data(1);







