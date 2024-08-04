create table fishes(
    id serial primary key,
    name varchar(255)
);

create table rivers(
    id serial primary key,
    name varchar(255)
);

create table fishes_rivers(
    id serial primary key,
    fish_id int references fishes(id),
    river_id int references rivers(id)
);
insert into fishes(name) values ('Sudak');
insert into fishes(name) values ('Vobla');
insert into fishes(name) values ('Sazan');
insert into fishes(name) values ('Nalim');
insert into fishes(name) values ('Som');

insert into rivers(name) values ('Kama');
insert into rivers(name) values ('Oka');
insert into rivers(name) values ('Lena');
insert into rivers(name) values ('Dnepr');
insert into rivers(name) values ('Volga');
insert into rivers(name) values ('Enisey');

insert into fishes_rivers(fish_id, river_id) values (1, 1);
insert into fishes_rivers(fish_id, river_id) values (1, 2);
insert into fishes_rivers(fish_id, river_id) values (1, 5);
insert into fishes_rivers(fish_id, river_id) values (2, 1);
insert into fishes_rivers(fish_id, river_id) values (2, 6);
insert into fishes_rivers(fish_id, river_id) values (2, 3);
insert into fishes_rivers(fish_id, river_id) values (3, 1);
insert into fishes_rivers(fish_id, river_id) values (3, 5);
insert into fishes_rivers(fish_id, river_id) values (3, 4);
insert into fishes_rivers(fish_id, river_id) values (4, 1);
insert into fishes_rivers(fish_id, river_id) values (5, 3);
insert into fishes_rivers(fish_id, river_id) values (5, 6);