create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

-- к пункту 1

create
or replace function taxAdd()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
	where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger taxAdd_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure taxAdd();

-- к пункту 2

    create
or replace function discount()
    returns trigger as
$$
    BEGIN
        update products
        price = price + price * 0.2
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger discountAdd_trigger
    before insert
    on products
    for each row
    execute procedure discount();

    -- к пункту 3

    create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

 create
or replace function addHistory()
    returns trigger as
$$
    BEGIN
        insert into history_of_price (name, price, date)
	 values(new.name, new.price, current_date);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger addInHistory_trigger
    after insert
    on products
    for each row
    execute procedure addHistory();





