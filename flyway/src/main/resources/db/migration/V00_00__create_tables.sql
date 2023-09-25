
create table if not exists account (
    id bigint auto_increment,
    email varchar(255) not null,
    password varchar(64),
    name varchar(64) not null,
    created_at timestamp,
    updated_at timestamp,

    primary key(id)
);