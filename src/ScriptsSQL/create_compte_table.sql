CREATE  TABLE  IF NOT EXISTS  compte (
    id serial not null PRIMARY KEY,
    nom_du_compte varchar(255) NOT NULL,
    type_de_compte varchar(255) NOT NULL,
    montant_de_depart float NOT NULL,
    devise int NOT NULL references devise(id_devise)
);
INSERT INTO compte(nom_du_compte,type_de_compte,montant_de_depart,devise) values
('test','espece',200,1),
('test2','Assurance',100,1),
('test3','Investissement',1000,2);