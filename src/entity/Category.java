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
