import Fonctionnality.BalanceHistory;
import Fonctionnality.CurrencyValueFunctionality;
import Fonctionnality.TransactionAccount;
import Fonctionnality.Transfert;
import Repository.CurrencyValueOperation;
import entity.Account;
import entity.CurrencyValue;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        TransactionAccount service=new TransactionAccount();
       Account account= service.performTransaction(10,"investissement", 3000.0,"credit",1,2);
        System.out.println(account);

        BalanceHistory balanceHistory=new BalanceHistory();
        LocalDateTime dateTime= LocalDateTime.of(2023,12,6,6,30);
        System.out.println(balanceHistory.getSoldByDate(2,dateTime));

        LocalDateTime beginDateTime=LocalDateTime.of(2023,12,6,7,30);
        LocalDateTime endDateTime=LocalDateTime.now();
        System.out.println( balanceHistory.accountBalanceHistory(1,beginDateTime,endDateTime));

        Transfert transfert=new Transfert();
        transfert.transfertMoney(1,1,2,200.0,13,14,2);
        transfert.transfertMoney(2,1,2,300.0,15,16,1);
        transfert.transfertMoney(3,1,2,500.0,17,18,3);
        transfert.transfertMoney(4,1,2,100.0,19,20,4);
        System.out.println( transfert.getTransfertHistory(beginDateTime,endDateTime));

        CurrencyValueFunctionality currencyValueFunctionality=new CurrencyValueFunctionality();
        LocalDate date= LocalDate.of(2023, 12, 13);
        System.out.println(currencyValueFunctionality.getCalculatedCurrencyByDate(date,"average"));
LocalDateTime dateTim=LocalDateTime.now();
        CurrencyValueOperation currencyValueOperation=new CurrencyValueOperation();
       System.out.println(currencyValueOperation.getByDate(dateTim));;
        System.out.println(balanceHistory.receveirAccountCurrentSold(2));

    }



}