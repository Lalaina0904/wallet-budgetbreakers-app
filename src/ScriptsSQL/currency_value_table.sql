CREATE TABLE IF NOT EXISTS currency_value(
id_currency_value int primary key,
id_currency_source int references currency(id_currency),
id_currency_destination int references currency(id_currency),
"value"  DECIMAL(10,2),
"date" timestamp
);
INSERT INTO currency_value values
(1,1,2,4500.0,'2023-12-12 06:20:30'),
(2,1,2,4600.0,'2023-12-13 06:30:30');
