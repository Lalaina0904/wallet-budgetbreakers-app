CREATE TABLE  IF NOT EXISTS Transaction (
    id INT PRIMARY KEY,
    type VARCHAR(255) CHECK (type IN ('depense', 'recette', 'transfert')) NOT NULL,
    compte_id INT REFERENCES compte(id) NOT NULL,
    montant DECIMAL(10,2) NOT NULL,
    categorie VARCHAR(255) NOT NULL,
    etiquettes VARCHAR(255),
    date DATE,
    heure TIME
);
