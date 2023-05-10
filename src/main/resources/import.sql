insert into "user"(username, password, enabled) values ('user', '$2a$12$qZMhHUMBuru4UeCzFwsvBeuTopbWOrOcocOIocEgKUYm5B5F5yOye', true);
insert into "user"(username, password, enabled) values ('admin', '$2a$12$IRD.PfN5.a4wq0j8fzP9b.UWQkrrr/sZzBX4A6HBjec7lCHARlbbW', true);

insert into user_roles(owner_id, "role") values (1, 'USER');
insert into user_roles(owner_id, "role") values (2, 'USER');
insert into user_roles(owner_id, "role") values (2, 'ADMIN');