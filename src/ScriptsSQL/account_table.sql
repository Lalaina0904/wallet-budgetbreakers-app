CREATE  TABLE  IF NOT EXISTS  account  (
    id int not null PRIMARY KEY,
    account_name varchar(255) NOT NULL,
    sold DECIMAL(10,2),
    currency int NOT NULL references currency(id_currency),
    accountType varchar(255) NOT NULL check (accountType IN ('bank','espece','mobileMoney'))


);
insert into account values (1,'account1',0,1,'espece'),
(2,'account2',0,2,'bank');
