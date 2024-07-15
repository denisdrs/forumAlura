create table users(
     id bigserial not null primary key,
     login varchar(100) not null,
     password varchar(255) not null
);