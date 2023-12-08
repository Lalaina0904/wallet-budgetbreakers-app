package Fonctionnality;

import Repository.AccountCrudOperation;
import Repository.TransfertHisoruCrudOperation;
import entity.Account;
import entity.TransferHistory;

import java.time.LocalDateTime;

public class Transfert {
    AccountCrudOperation accountCrudOperation=new AccountCrudOperation();
    TransactionAccount transaction=new TransactionAccount();
    TransfertHisoruCrudOperation transfertHisoruCrudOperation=new TransfertHisoruCrudOperation();
    public void transfertMoney(int idTransert,int idAccountSource,int idAccountReceiver,Double amount,int idTransactionCreditor,int idTransactionDebitor){
        Account sender=accountCrudOperation.findById(idAccountSource);
        Account receiver=accountCrudOperation.findById(idAccountReceiver);
        String senderCurrencyCode=sender.getCurrency().getCode();
        String receveirCurrencyCode=receiver.getCurrency().getCode();
        if(idAccountSource==idAccountReceiver )
            return;


        if(senderCurrencyCode.equals(receveirCurrencyCode)){
            LocalDateTime dateTime=LocalDateTime.now();
            transaction.performTransaction(idTransactionCreditor,"transfert",amount,"debit",idAccountSource);
            transaction.performTransaction(idTransactionDebitor,"transfert",amount,"credit",idAccountReceiver);

            TransferHistory transferHistory=new TransferHistory(idTransert,idTransactionDebitor,idTransactionCreditor,dateTime);
            transfertHisoruCrudOperation.save(transferHistory);
        }
        else {

        }
    }
}
