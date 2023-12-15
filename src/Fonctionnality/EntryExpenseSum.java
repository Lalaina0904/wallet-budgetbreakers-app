package Fonctionnality;

import Repository.TransactionCrudOperation;
import entity.Transaction;

import java.time.LocalDate;
import java.util.List;

public class EntryExpenseSum {
    TransactionCrudOperation transactionCrudOperation=new TransactionCrudOperation();
    public String EntryExpenseAmountSum(int id, LocalDate startDate,LocalDate endDate){

  List<Transaction> transactions= transactionCrudOperation.allTransactoinByIdAccount(id);
  List<Transaction> filteredTransations=transactions.stream().filter(transaction -> {
     LocalDate date= LocalDate.from(transaction.getDate());
     Boolean isInclude=(date.isEqual(startDate) || date.isAfter(startDate))&&(date.isEqual(endDate)||date.isBefore(endDate));
     return isInclude;
  }).toList();
        double entry=0;
  double expense=0;

  String response="";
  for(Transaction transaction:filteredTransations){
      String transactionType=transaction.getType();
      if(transactionType.equals("credit"))
          entry+=transaction.getAmount();
      else
          expense+=transaction.getAmount();
  }
    response+="entry="+entry+" expense="+expense;
  return  response;
    }





}
