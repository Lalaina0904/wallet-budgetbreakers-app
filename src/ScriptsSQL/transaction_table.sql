CREATE TABLE  IF NOT EXISTS Transaction (
    id INT PRIMARY KEY,
    label VARCHAR(100),
    amount DECIMAL(10,2) NOT NULL,
    transaction_date timestamp,
    transaction_type VARCHAR(25) CHECK (transaction_type IN ('debit','credit')) NOT NULL,

    id_account int REFERENCES account(id)
);

INSERT INTO transaction values
(1,'pret',10,CURRENT_TIMESTAMP,'debit',1),
(2,'investissemnt',1000,CURRENT_TIMESTAMP,'credit',2);

