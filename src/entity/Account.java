package entity;

public class Account {
    private int idAccount;
    private String accountName;
    private String accountType;
    private double initialAmount;
    private Currency currency;

    // constructeur

    public Account(int idAccount, String accountName, String accountType, double initialAmount, Currency currency) {
        this.idAccount = idAccount;
        this.accountName = accountName;
        this.accountType = accountType;
        this.initialAmount = initialAmount;
        this.currency = currency;
    }


    // getters et setters


    public int getIdAccount() {
        return idAccount;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getInitialAmount() {
        return initialAmount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", accountName='" + accountName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", initialAmount=" + initialAmount +
                ", currency=" + currency +
                '}';
    }
}
