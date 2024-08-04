create table plane(
    id serial primary key,
    name varchar(255),
	number int
);

create table number(
    id serial primary key,
    plane_id int references plane(id) unique
);