CREATE TABLE  IF NOT EXISTS Transaction (
    id INT PRIMARY KEY,
    type VARCHAR(255) CHECK (type IN ('depense', 'recette', 'transfert')) NOT NULL,
    compte_id INT REFERENCES compte(id) NOT NULL,
    montant DECIMAL(10,2) NOT NULL,
    categorie VARCHAR(255) NOT NULL,
    "date" DATE,
    "hour" TIME
);
insert into Transaction values
(1,'depense',1,2000,'nourriture','2023-12-04','18:29:05'),
(2,'depense',2,300,'collection','2023-12-04','18:40:05'),
(3,'recette',2,200,'epargne','2023-12-04','18:50:05')
ON CONFLICT DO NOTHING;
