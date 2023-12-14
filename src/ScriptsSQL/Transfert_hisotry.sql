CREATE TABLE IF NOT EXISTS transfert_history(
 id int primary key,
 id_transaction_debitor int references transaction(id),
 id_transaction_creditor int references transaction(id),
 amount decimal,
 transfert_date timestamp
);