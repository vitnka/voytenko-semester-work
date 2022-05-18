alter table orders
    add column reviews_id int4;

alter table orders
    add constraint FKg07lg83wrkbo8w8rop4lyu9hg
        foreign key (reviews_id)
            references review;


INSERT INTO public.users (id, email, password, role, state)
VALUES (100, 'admin@mail.com', '$2a$10$r3pVV1WB7yjvW96ZB8uggebKgYGsKkyH3zgmX9FJDBDYuFhrNAb6C','ADMIN', 'CONFIRMED');
INSERT INTO public.users (id, email, password, role, state)
VALUES (200, 'voytenko@mail.com', '$2a$10$r3pVV1WB7yjvW96ZB8uggebKgYGsKkyH3zgmX9FJDBDYuFhrNAb6C', 'USER', 'CONFIRMED');
INSERT INTO public.client (first_name, last_name, id)
VALUES ('Анастасия', 'Войтенко', 200);

INSERT INTO category (id, name)
VALUES (1,'стиральные машины' );
INSERT INTO category (id, name)
VALUES (2,'ноутбуки' );
INSERT INTO category (id, name)
VALUES (3,'мобильные телефоны' );
INSERT INTO category (id, name)
VALUES (4,'портативные зарядки' );

INSERT INTO public.orders (id, comment, item_name, order_status, reason, user_id)
values (100, 'Иногда заряжает через раз', 'Портативная зарядка', 'IN_PROGRESS', 'Совсем не держит заряд, не заряжает', 200);
INSERT INTO public.orders (id, comment, item_name, order_status, reason, user_id)
values (200, 'Иногда заряжает через раз', 'Портативная зарядка', 'NOT_STARTED', 'Совсем не держит заряд, не заряжает', 200);
INSERT INTO public.orders (id, comment, item_name, order_status, reason, user_id)
values (300, 'Уронили в воду', 'Беспроводные наушники', 'IN_PROGRESS', 'Не работает один наушник', 200);
INSERT INTO public.orders (id, comment, item_name, order_status, reason, user_id)
values (400, 'Сильно гудит при загрузке', 'Стиральная машина', 'COMPLETED', 'Выливается вода, неприятный запах', 200);

INSERT INTO review (id, comment, date, rating, order_id, client_id)
VALUES (100, 'Пришлось полностью заменить зарядку, так как эта стала не пригодна, в сервисе не помогли', '2001-12-30T06:09:00.361', 3, 200, 200);
update orders set reviews_id = 100 where id = 200;
INSERT INTO review (id, comment, date, rating, order_id, client_id)
VALUES (200, 'Все супер! Мастер заменил детали, машинка работает как новая!', '2001-05-30T06:09:00.361', 10, 400, 200);
update orders set reviews_id = 200 where id = 400;

-- $2a$10$r3pVV1WB7yjvW96ZB8uggebKgYGsKkyH3zgmX9FJDBDYuFhrNAb6C = qwerty