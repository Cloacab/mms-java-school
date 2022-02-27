--liquibase formatted sql
--changeset egor:DEV-1 splitStatements:true endDelimiter:;

create table if not exists property.categories
(
    id int not null,
    created_at datetime(6) null,
    is_deleted bit null,
    name varchar(255) not null,
    primary key (id)
);

create table if not exists property.clients
(
    id int not null,
    created_at datetime(6) null,
    last_name varchar(255) not null,
    birth_date datetime(6) null,
    email varchar(255) not null,
    first_name varchar(255) not null,
    password varchar(255) not null,
    role varchar(255) not null,
    username varchar(255) not null,
    primary key (id),
    constraint UK_srdlopksdpbh4qo20au1v8w7r
        unique (username),
    constraint UK_srv16ica2c1csub334bxjjb59
        unique (email)
);

create table if not exists property.addresses
(
    id int not null,
    created_at datetime(6) null,
    apartment_number varchar(255) not null,
    country varchar(255) not null,
    house_number varchar(255) not null,
    street varchar(255) not null,
    town varchar(255) not null,
    zip_code varchar(255) not null,
    client_id int null,
    primary key (id),
    constraint FKrf3c1s9gxxx0wubkv5maokv9y
        foreign key (client_id) references property.clients (id)
);

create table if not exists property.hibernate_sequence
(
    next_val bigint null
);

create table if not exists property.orders
(
    id int not null,
    created_at datetime(6) null,
    delivery_type varchar(255) null,
    delivery_status varchar(255) null,
    payment_status varchar(255) null,
    payment_type varchar(255) null,
    total_price double null,
    address_id int null,
    client_id int null,
    primary key (id),
    constraint FKhlglkvf5i60dv6dn397ethgpt
        foreign key (address_id) references property.addresses (id),
    constraint FKm2dep9derpoaehshbkkatam3v
        foreign key (client_id) references property.clients (id)
);

create table if not exists property.products
(
    id int not null,
    created_at datetime(6) null,
    is_deleted bit null,
    left_in_stock int not null,
    name varchar(255) not null,
    price double not null,
    volume double null,
    weight double null,
    category_id int null,
    primary key (id),
    constraint FKog2rp4qthbtt2lfyhfo32lsw9
        foreign key (category_id) references property.categories (id)
);

create table if not exists property.order_to_product
(
    id int not null,
    created_at datetime(6) null,
    amount int null,
    price_for_product double null,
    order_id int null,
    product_id int null,
    primary key (id),
    constraint FKte8xbmr3i9rkvtu49p3cwb4wl
        foreign key (product_id) references property.products (id),
    constraint FKy4de5ahbmp4sh1hud9w9w4ys
        foreign key (order_id) references property.orders (id)
);

create table if not exists property.parameters
(
    id int not null,
    created_at datetime(6) null,
    name varchar(255) not null,
    value varchar(255) not null,
    product_id int null,
    primary key (id),
    constraint FKb4aox5ll5vo19gy59dfy5mp1v
        foreign key (product_id) references property.products (id)
);




