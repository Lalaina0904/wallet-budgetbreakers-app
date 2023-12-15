CREATE TABLE IF NOT EXISTS category (
    id_category INT PRIMARY KEY,
    category_type VARCHAR(30) UNIQUE,
    CHECK (category_type IN ('nourriture et boisson', 'achat et boutique en ligne', 'logement', 'transports', 'vehicule', 'loisirs', 'multimedia Informatique', 'investments', 'income', 'other'))
);

INSERT INTO category (id_category, category_type)
SELECT 1, 'vehicule'
WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id_category = 1 AND category_type = 'vehicule'
);


INSERT INTO category (id_category, category_type)
SELECT 2, 'nourriture et boisson'
    WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id_category = 2 AND category_type = 'nourriture et boisson'
);





