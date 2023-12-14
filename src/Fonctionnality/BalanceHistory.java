package Fonctionnality;

import Repository.AccountCrudOperation;
import Repository.CurrencyValueOperation;
import Repository.TransactionCrudOperation;
import Repository.TransfertHistoryOperation;
import entity.CurrencyValue;
import entity.Transaction;
import entity.TransferHistory;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public List<Double> accountBalanceHistory(int idAccount,LocalDateTime beginDateTime,LocalDateTime endDateTime){
        List<Transaction> transactions=transactionCrudOperation.allTransactoinByIdAccount(idAccount);
        transactions.sort(Comparator.comparing(Transaction::getDate));
        Double amount=0.0;
        List<Double> allSold=new ArrayList<>();
        for(Transaction transaction:transactions){
            if(transaction.getDate().isBefore(beginDateTime))
                continue;
            if(transaction.getDate().isAfter(endDateTime))
                break;
            if(transaction.getType().equals("debit"))
                amount-=transaction.getAmount();
            else
                amount+=transaction.getAmount();

            allSold.add(amount);
        }
    return allSold;
    }

// the current sold of the account which receives transfert
    TransfertHistoryOperation transfert=new TransfertHistoryOperation();
    CurrencyValueOperation currencyValueOperation=new CurrencyValueOperation();
    public double receveirAccountCurrentSold(int idAccountReceiver){
       List<TransferHistory> transferHistories=transfert.getTransfertHistoryByIdCreditor(idAccountReceiver);
        AccountCrudOperation account=new AccountCrudOperation();
       Double totalSold= getSoldByDate(idAccountReceiver,LocalDateTime.now());
        for(TransferHistory transferHistory:transferHistories){
           LocalDateTime transfertDate= transferHistory.getDateTime();
          double CurrencyValueAmount=currencyValueOperation.getByDate(transfertDate).getAmount();
          double convertedSold=CurrencyValueAmount*transferHistory.getAmount();

          totalSold+=convertedSold;
        }
        return totalSold;
    }

}
