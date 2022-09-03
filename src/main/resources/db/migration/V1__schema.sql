create table users
(
    id uuid default gen_random_uuid(),
    username varchar (55) not null unique,
    password varchar (55) not null,
    primary key (id)
);
