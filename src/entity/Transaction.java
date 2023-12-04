package entity;

import java.sql.Date;
import java.sql.Time;

public class Transaction {
    private int id;
    private String type;
    private Compte compte;
    private double montant;

    private String categorie;
    private Date date;
    private Time hour;

    public Transaction(int id, String type, Compte compte, double montant, String categorie, Date date, Time hour) {
        this.id = id;
        this.type = type;
        this.compte = compte;
        this.montant = montant;
        this.categorie = categorie;
        this.date = date;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Compte getCompte() {
        return compte;
    }

    public double getMontant() {
        return montant;
    }



    public String getCategorie() {
        return categorie;
    }

    public Date getDate() {
        return date;
    }

    public Time getHour() {
        return hour;
    }
}
