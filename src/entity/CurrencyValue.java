package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class CurrencyValue {
    int idCurrencyValue;
    int idCurrencySource;
    int idCurrencyDestination;
    Double amount;
    LocalDate Date;

    public CurrencyValue(int idCurrencyValue, int idCurrencySource, int idCurrencyDestination, Double amount, LocalDate date) {
        this.idCurrencyValue = idCurrencyValue;
        this.idCurrencySource = idCurrencySource;
        this.idCurrencyDestination = idCurrencyDestination;
        this.amount = amount;
        Date = date;
    }

    public int getIdCurrencyValue() {
        return idCurrencyValue;
    }

    public int getIdCurrencySource() {
        return idCurrencySource;
    }

    public int getIdCurrencyDestination() {
        return idCurrencyDestination;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return Date;
    }
}
