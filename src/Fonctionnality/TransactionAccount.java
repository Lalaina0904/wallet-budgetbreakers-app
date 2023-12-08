package Fonctionnality;

import Repository.AccountCrudOperation;
import Repository.TransactionCrudOperation;
import entity.Account;
import entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionAccount {
    TransactionCrudOperation transactionCrud=new TransactionCrudOperation();
    AccountCrudOperation accountCrudOperation=new AccountCrudOperation();
    public Account performTransaction(int idTransaction,String label,Double amount,String type,int idAccount){
        LocalDateTime date=LocalDateTime.now() ;

        Transaction transaction=new Transaction(idTransaction,label,amount,date,type);

        Boolean isSaved =transactionCrud.saveTransactionByAccount(transaction,idAccount);
        List<Transaction> allTransactionsByAccount=transactionCrud.allTransactoinByIdAccount(idAccount);
        Account account= accountCrudOperation.findById(idAccount);
        account.setTransactions(allTransactionsByAccount);
        double newSold=account.getSold();
        Account accountWithNewSold=account;
        if(isSaved){
            if(type.equals("debit")){
                if( ! account.getType().equals("bank")){
                    if(account.getSold()<amount){
                        System.out.println("sold must be superior of the amount to debit");
                    }
                    else {
                        newSold-=amount;
                        account.setSold(newSold);
                        accountWithNewSold=accountCrudOperation.update(account);
                    }
                }

            }
            else {
                newSold+=amount;
                account.setSold(newSold);
                accountWithNewSold=accountCrudOperation.update(account);
            }
        }

        return accountWithNewSold;
    }


}
