-- Default spring security schema

--create table users(
--      username varchar_ignorecase(50) not null primary key,
--      password varchar_ignorecase(50) not null,
--      enabled boolean not null);
--

--create table authorities (
--      username varchar_ignorecase(50) not null,
--      authority varchar_ignorecase(50) not null,
--      constraint fk_authorities_users foreign key(username) references users(username));

--create unique index ix_auth_username on authorities (username,authority);

-- Custom spring security schema

create table my_users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(50) not null,
      enabled boolean not null);

create table my_authorities (
            username varchar_ignorecase(50) not null,
            authority varchar_ignorecase(50) not null,
            constraint fk_authorities_users foreign key(username) references my_users(username));

create unique index ix_auth_username on my_authorities (username,authority);