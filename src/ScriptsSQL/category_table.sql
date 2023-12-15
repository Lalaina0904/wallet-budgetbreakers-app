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



ty ny script amle category




de ty ny entité:
package entity;

public class Category {
private int idCatory;
private CategoryType name;

public Category(int idCatory, CategoryType name) {
        this.idCatory = idCatory;
        this.name = name;
}

    public int getIdCatory() {
        return idCatory;
}

    public CategoryType getType() {
        return name;
}
}




ty ENUM


package entity;

public enum CategoryType {

    nourritureEtBoisson("nourriture et boisson"),
    achatEtBoutiqueEnLigne("achat et boutique en ligne"),
    logment("logement"),
    transports("transports"),
    vehicule("vehicule"),
    loisirs("loisirs"),
    multimediaInformatique("multimedia,Informatique"),
    financialExpenses("financial expenses"),
    investments("investments"),
    inCome("income"),
    other("other");

    private final String value;

    CategoryType(String value) {
    this.value=value;
}

    public String getValue() {
        return value;
}
}