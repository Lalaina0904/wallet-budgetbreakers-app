CREATE  TABLE  IF NOT EXISTS  compte (
    int id  NOT NULL AUTO_INCREMENT,
    varchar(255) nomDuCompte  NOT NULL,
    varchar(255) typeDeCompte  NOT NULL,
    float montantDeDepart  NOT NULL,
    varchar(255) devise  NOT NULL
)