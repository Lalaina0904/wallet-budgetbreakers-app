package entity;



import java.util.ArrayList;
import java.util.List;


public class Account {
    private int id;
    private String Name;
    private Double sold;
    private List<Transaction> transactions;
    private Currency currency;
    private String type;


    public Account(int id, String name, Double sold,Currency currency, String type) {
        this.id = id;
        Name = name;
        this.sold = sold;
        this.transactions = new ArrayList<>();
        this.currency = currency;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public Double getSold() {
        return sold;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSold(Double sold) {
        this.sold = sold;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", sold=" + sold +
                ", transactions=" + transactions +
                ", currency=" + currency +
                ", type='" + type + '\'' +
                '}';
    }
}
