import Fonctionnality.BalanceHistory;
import Fonctionnality.TransactionAccount;
import entity.Account;

import java.time.LocalDateTime;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       /* AccountCrudOperation accountCrudOperation =new AccountCrudOperation();
        //account crud operation
        System.out.println("=".repeat(50)+"Account CRUD OPERATION"+"=".repeat(50));

        Account account1 =new Account(5,"Test5","espece",
                300,new Currency(2));
        Account account2=new Account(6,"Test6","espece",
                100,new Currency(1));
        Account account3=new Account(7,"Test7","espece",
                9000,new Currency(1));
        Account accountToUpdate =new Account(5,"updatedAccount","espece",
                300,new Currency(2));
        List<Account> accountsToSave= Arrays.asList(account1,account2,account3);



        List<Account> accounts = accountCrudOperation.findAll();
       for(Account account : accounts){
           System.out.println(account);
       }
        System.out.println(accountCrudOperation.findById(2));*/

    /*   accountCrudOperation.saveAll(accountsToSave);
       accountCrudOperation.save(account1);


        System.out.println(accountCrudOperation.update(accountToUpdate));




        //Devise CRUD OPERATION
        System.out.println("\n\n"+"=".repeat(50)+"CURRENCY CRUD OPERATION"+"=".repeat(50));
        DeviseCrudOperation deviseCrudOperation=new DeviseCrudOperation();
        Currency currency1=new Currency(1,"Dollar","USD");
        Currency currency2=new Currency(2,"Ariary","MGA");
        Currency currency3=new Currency(3,"Euro","EUR");

        List<Currency> allCurrencyToSave=Arrays.asList(currency1,currency2,currency3);
        List<Currency> allCurrency=deviseCrudOperation.findAll();
        for(Currency currency:allCurrency){
            System.out.println(currency);
        }
        deviseCrudOperation.saveAll(allCurrencyToSave);
        deviseCrudOperation.save(currency1);



        //Transaction CRUD OPERATION
        System.out.println("\n\n"+"=".repeat(50)+"TRANSACTION CRUD OPERATION"+"=".repeat(50));
        TransactionCrudOperation transactionCrudOperation=new TransactionCrudOperation();
        Transaction transaction1=new Transaction(4,"depense",account1,300,
                "epargne", java.sql.Date.valueOf("2023-12-04"),java.sql.Time.valueOf("20:45:00"));
        Transaction transaction2=new Transaction(5,"depense",account2,4000,
                "epargne", java.sql.Date.valueOf("2023-12-09"),java.sql.Time.valueOf("20:50:00"));
        Transaction transaction3=new Transaction(5,"recette",account2,4000,
                "nouriturre", java.sql.Date.valueOf("2023-12-10"),java.sql.Time.valueOf("20:52:00"));
        List<Transaction> allTransactionToSave=Arrays.asList(transaction1,transaction3,transaction2);

        List<Transaction> allTransaction=transactionCrudOperation.findAll();
        for(Transaction transaction:allTransaction){
            System.out.println(transaction);
        }
        transactionCrudOperation.save(transaction2);
        transactionCrudOperation.saveAll(allTransactionToSave);
        Transaction transactionToUpdate=transactionCrudOperation.update(new Transaction(4,"depense",account1,300,
                "epargne", java.sql.Date.valueOf("2023-12-04"),java.sql.Time.valueOf("20:45:00")));

        System.out.println(transactionToUpdate);*/
        TransactionAccount service=new TransactionAccount();
       Account account= service.performTransaction(10,"investissement", 3000.0,"credit",1);
        System.out.println(account);

        BalanceHistory balanceHistory=new BalanceHistory();
        LocalDateTime dateTime= LocalDateTime.of(2023,12,6,6,30);
        System.out.println(balanceHistory.getSoldByDate(2,dateTime));

        LocalDateTime beginDateTime=LocalDateTime.of(2023,12,6,7,30);
        LocalDateTime endDateTime=LocalDateTime.of(2023,12,7,10,30);
        System.out.println( balanceHistory.accountBalanceHistory(1,beginDateTime,endDateTime));
    }
}