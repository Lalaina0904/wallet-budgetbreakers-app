package entity;

import java.time.LocalDateTime;

public class TransferHistory {
   private int id;
   private int idTransactionDebitor;
   private int idTransactionCreditor;
   private LocalDateTime dateTime;

    public TransferHistory(int id, int idTransactionDebitor, int idTransactionCreditor, LocalDateTime dateTime) {
        this.id = id;
        this.idTransactionDebitor = idTransactionDebitor;
        this.idTransactionCreditor = idTransactionCreditor;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public int getIdTransactionDebitor() {
        return idTransactionDebitor;
    }

    public int getIdTransactionCreditor() {
        return idTransactionCreditor;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdTransactionDebitor(int idTransactionDebitor) {
        this.idTransactionDebitor = idTransactionDebitor;
    }

    public void setIdTransactionCreditor(int idTransactionCreditor) {
        this.idTransactionCreditor = idTransactionCreditor;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
