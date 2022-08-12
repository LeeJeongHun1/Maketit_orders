-- create account Table
CREATE TABLE public.tb_account
(
    id         int8         NOT NULL,
    address    varchar(255) NOT NULL,
    email      varchar(255) NOT NULL,
    "name"     varchar(255) NOT NULL,
    "password" varchar(255) NOT NULL,
    phone      varchar(255) NOT NULL,
    CONSTRAINT tb_account_pkey PRIMARY KEY (id)
);

-- insert account Table
INSERT INTO public.tb_account (id, address, email, "name", "password", phone)
VALUES (1, '서울특별시 성동구 성수동', 'jhlee@naver.com', 'jeonghun', '1234!', '010-4312-4112'),
       (2, '서울특별시 중랑구 중화동', 'minsu@naver.com', 'minsu', '1234!', '010-1234-4321');

-- create order Table
CREATE TABLE public.tb_order
(
    order_id     int8         NOT NULL,
    create_date  timestamp    NOT NULL,
    amount       int8         NOT NULL,
    count        int8         NOT NULL,
    order_status varchar(255) NOT NULL,
    account_id   int8 NULL,
    product_id   int8 NULL,
    CONSTRAINT tb_order_pkey PRIMARY KEY (order_id)
);

-- insert order Table
INSERT INTO public.tb_order (order_id, create_date, amount, count, order_status, account_id, product_id)
VALUES (2, '2022-08-12 15:07:55.601', 19800, 2, 'waiting', 1, 1),
       (1, '2022-08-11 23:51:01.301', 19800, 2, 'order', 1, 1);

-- create product Table
CREATE TABLE public.tb_product (
                                   product_id int8 NOT NULL,
                                   create_date timestamp NOT NULL,
                                   "name" varchar(255) NOT NULL,
                                   price int8 NOT NULL,
                                   stock int8 NOT NULL,
                                   CONSTRAINT tb_product_pkey PRIMARY KEY (product_id)
);

-- insert product Table
INSERT INTO public.tb_product (product_id, create_date, "name", price, stock)
VALUES (2, '2022-08-11 22:00:33.206', '햇반', 24900, 4),
       (3, '2022-08-11 22:00:33.211', '키보드', 124900, 12),
       (4, '2022-08-11 22:00:33.212', '마우스', 34900, 2),
       (5, '2022-08-11 22:00:33.221', '모니터', 324900, 9),
       (6, '2022-08-11 22:00:33.222', '휴대폰 케이스', 10900, 20),
       (7, '2022-08-11 22:00:33.224', '헤드셋', 40900, 10),
       (8, '2022-08-11 22:00:33.225', 'USB 허브', 324900, 5),
       (9, '2022-08-11 22:00:33.226', '비타민 영양제', 42900, 10),
       (10, '2022-08-11 22:00:33.228', '아이폰 13', 1224900, 5),
       (11, '2022-08-11 22:00:33.23', '아이폰 12', 1124900, 0);
INSERT INTO public.tb_product (product_id, create_date, "name", price, stock)
VALUES (1, '2022-08-11 22:00:33.156', '닭가슴살', 9900, 8);


