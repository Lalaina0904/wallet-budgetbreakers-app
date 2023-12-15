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

INSERT INTO category (id_category, category_type)
SELECT 3, 'achat et boutique en ligne'
    WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id_category = 3 AND category_type = 'achat et boutique en ligne'
);
INSERT INTO category (id_category, category_type)
SELECT 4, 'loisirs'
    WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id_category = 4 AND category_type = 'loisirs'
);
INSERT INTO category (id_category, category_type)
SELECT 5, 'other'
    WHERE NOT EXISTS (
    SELECT 1 FROM category WHERE id_category = 5 AND category_type = 'other'
);