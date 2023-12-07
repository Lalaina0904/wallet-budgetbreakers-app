CREATE TABLE IF NOT EXISTS balance_history (
id int primary key,
id_account int references account(id),
modification_date
)