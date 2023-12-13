import Fonctionnality.BalanceHistory;
import Fonctionnality.TransactionAccount;
import Fonctionnality.Transfert;
import entity.Account;

import java.time.LocalDateTime;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        TransactionAccount service=new TransactionAccount();
       Account account= service.performTransaction(10,"investissement", 3000.0,"credit",1);
        System.out.println(account);

        BalanceHistory balanceHistory=new BalanceHistory();
        LocalDateTime dateTime= LocalDateTime.of(2023,12,6,6,30);
        System.out.println(balanceHistory.getSoldByDate(2,dateTime));

        LocalDateTime beginDateTime=LocalDateTime.of(2023,12,6,7,30);
        LocalDateTime endDateTime=LocalDateTime.of(2023,12,7,10,30);
        System.out.println( balanceHistory.accountBalanceHistory(1,beginDateTime,endDateTime));

        Transfert transfert=new Transfert();
        transfert.transfertMoney(1,1,2,200.0,10,11);

        System.out.println( transfert.getTransfertHistory(beginDateTime,endDateTime));
    }
}