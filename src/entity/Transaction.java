package entity;

import java.sql.Date;
import java.sql.Time;

public class Transaction {
    private int id;
    private String type;
    private Account account;
    private double amount;

    private String category;
    private Date date;
    private Time hour;

    public Transaction(int id, String type, Account account, double amount, String category, Date date, Time hour) {
        this.id = id;
        this.type = type;
        this.account = account;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }

    public Time getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", account=" + account +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", hour=" + hour +
                '}';
    }
}
