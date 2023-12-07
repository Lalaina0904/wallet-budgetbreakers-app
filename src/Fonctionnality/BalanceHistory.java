package Fonctionnality;

import Repository.TransactionCrudOperation;
import entity.Transaction;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class BalanceHistory {
    TransactionCrudOperation transactionCrudOperation=new TransactionCrudOperation();
    public Double getSoldByDate(int idAccount, LocalDateTime dateTime){
        List<Transaction> transactions=transactionCrudOperation.allTransactoinByIdAccount(idAccount);

        transactions.sort(Comparator.comparing(Transaction::getDate));
        Double amount=0.0;
        for(Transaction transaction:transactions){
            if(transaction.getDate().isAfter(dateTime) || transaction.getDate().equals(dateTime)){
                break;
            }
            if(transaction.getType().equals("debit"))
                amount-=transaction.getAmount();
            else
                amount+=transaction.getAmount();
        }
        return amount;
    }
}
