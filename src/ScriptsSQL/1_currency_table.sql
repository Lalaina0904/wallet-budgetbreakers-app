CREATE TABLE IF NOT EXISTS currency (
id_currency int primary key  not null,
name varchar(50) not null,
code  varchar(50) not null
);
insert into currency values
(1,'euro','EUR'),
(2,'ariary','MGA');
