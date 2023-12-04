package entity;

public class Currency {
    int idCurrency;
    String name;
    String code;

    public Currency(int idCurrency, String name, String code) {
        this.idCurrency = idCurrency;
        this.name = name;
        this.code = code;
    }
    public Currency(int idCurrency) {
        this.idCurrency = idCurrency;

    }
    public int getIdCurrency() {
        return idCurrency;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "idCurrency=" + idCurrency +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
