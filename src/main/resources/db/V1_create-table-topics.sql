create table topics (
                         id bigserial not null primary key,
                         title varchar(100) not null,
                         message varchar(500) not null,
                         creation_data timestamp not null,
                         status smallint not null default 1,
                         author varchar(100) not null,
                         course varchar(100) not null
);