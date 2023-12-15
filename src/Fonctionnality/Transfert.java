package Fonctionnality;

import Repository.*;
import entity.Account;
import entity.CurrencyValue;
import entity.TransferHistory;

import java.time.LocalDateTime;
import java.util.List;


public class Transfert {

    AccountCrudOperation accountCrudOperation=new AccountCrudOperation();
    TransactionAccount transaction=new TransactionAccount();
    CurrencyValueOperation currencyValueOperation=new CurrencyValueOperation();

    TransfertHistoryOperation transfertHistoryOperation=new TransfertHistoryOperation();
    //a method to transfert moneu
    public void transfertMoney(int idTransert,int idAccountSource,int idAccountReceiver,double amount,int idTransactionCreditor,int idTransactionDebitor,int category){

        if(idAccountSource==idAccountReceiver )
            return;
        Account sender=accountCrudOperation.findById(idAccountSource);
        Account receiver=accountCrudOperation.findById(idAccountReceiver);
        String senderCurrencyCode=sender.getCurrency().getCode();
        String receveirCurrencyCode=receiver.getCurrency().getCode();

        LocalDateTime dateTime=LocalDateTime.now();
        //check if the currencies are equals
        if(senderCurrencyCode.equals(receveirCurrencyCode)){

            transaction.performTransaction(idTransactionDebitor,"transfert",amount,"debit",idAccountSource,category);
            transaction.performTransaction(idTransactionCreditor,"transfert",amount,"credit",idAccountReceiver,category);


        }
        else {
            //get the last currency exchange rate
           CurrencyValue lastCurrecy= currencyValueOperation.getLastCurrencyValue();

            double convertedAmount=lastCurrecy.getAmount()*amount;
            transaction.performTransaction(idTransactionCreditor,"transfert",convertedAmount,"credit",idAccountReceiver,category);
            transaction.performTransaction(idTransactionDebitor,"transfert",amount,"debit",idAccountSource,category);
        }


        TransferHistory transferHistory=new TransferHistory(idTransert,idTransactionDebitor,idTransactionCreditor,amount,dateTime);
        transfertHistoryOperation.save(transferHistory);
    }





    //a method to get the transfert history on a given interval of date
    public List<TransferHistory> getTransfertHistory(LocalDateTime startDate,LocalDateTime endDate){
        List<TransferHistory> histories= transfertHistoryOperation.findByGivenDate(startDate,endDate);
        return histories;
    }


    //a method to get sold of the account receiever

}