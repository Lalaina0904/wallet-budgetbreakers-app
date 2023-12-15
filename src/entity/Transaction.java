package entity;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;


public class Transaction {
    private int id;
    private String label;
    private double amount;
   private LocalDateTime Date;
    private String type;
    private int category;


    public Transaction(int id, String label, double amount, LocalDateTime date, String type, int category) {
        this.id = id;
        this.label = label;
        this.amount = amount;
        Date = date;
        this.type = type;
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", amount=" + amount +
                ", Date=" + Date +
                ", type='" + type + '\'' +
                '}';
    }
}
