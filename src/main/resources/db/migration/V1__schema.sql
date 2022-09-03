
create extension if not exists "uuid-ossp";

create table users
(
    id uuid default uuid_generate_v4(),
    username varchar (55) not null unique,
    password varchar (55) not null,
    primary key (id)
);

