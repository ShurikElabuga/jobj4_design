insert into roles(nameRole) values('mechanic');
insert into roles(nameRole) values('technician');
insert into roles(nameRole) values('engineer');


insert into users(nameUser, role_id) values('Ivan', 1);
insert into users(nameUser, role_id) values('Boris', 2);
insert into users(nameUser, role_id) values('Nikolay', 3);


insert into rules(nameRule) values('RulesMechanic');
insert into rules(nameRule) values('RulesTechnician');
insert into rules(nameRule) values('RulesEngineer');


insert into roles_rules(role_id, rule_id) values(1, 1);
insert into roles_rules(role_id, rule_id) values(2, 2);
insert into roles_rules(role_id, rule_id) values(3, 3);


insert into categories(nameCategory) values('A');
insert into categories(nameCategory) values('B');
insert into categories(nameCategory) values('C');


insert into states(nameState) values('open');
insert into states(nameState) values('close');


insert into items(nameItem, user_id, category_id, state_id) values('item1', 1, 1, 2);
insert into items(nameItem, user_id, category_id, state_id) values('item2', 3, 2, 1);
insert into items(nameItem, user_id, category_id, state_id) values('item3', 2, 2, 1);


insert into comments(nameComment, item_id) values('performed', 1);
insert into comments(nameComment, item_id) values('process', 2);
insert into comments(nameComment, item_id) values('delay', 3);


insert into attachs(nameAttach, item_id) values('file1', 1);
insert into attachs(nameAttach, item_id) values('file2', 2);
insert into attachs(nameAttach, item_id) values('file3', 3);