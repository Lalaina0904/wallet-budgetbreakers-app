CREATE TABLE IF NOT EXISTS devise (
id_devise int primary key  not null,
nom_devise varchar(50) not null,
code_iso varchar(50) not null
);
INSERT INTO devise (id_devise,nom_devise,code_iso) VALUES
(1,'Dollar','USD') ,
(2,'Ariary','MGA'),
(3,'Euro','EUR'),
 (4,'Yen','JPY')
 ON CONFLICT DO NOTHING; # making the insert idempotent