package Repository;

import entity.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionCrudOperation implements CrudOperation<Transaction>{

    @Override
    public List<Transaction> findAll() {
        String sql="select * from Transaction ";
        List <Transaction> Transactions=new ArrayList<>();
        AccountCrudOperation account=new AccountCrudOperation();
        try {
            PreparedStatement preparedStatement= ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Transactions.add(
                        new Transaction(
                             resultSet.getInt("id"),
                                resultSet.getString("label"),
                                resultSet.getDouble("amount"),
                                resultSet.getTimestamp("transaction_date").toLocalDateTime(),
                                resultSet.getString("transaction_type")
                        )
                );


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Transactions;
    }

    @Override
    public Transaction findById(int id) {
        String sql="select * from Transaction ";
        Transaction transaction=null;
        AccountCrudOperation account=new AccountCrudOperation();
        try {
            PreparedStatement preparedStatement= ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){

                transaction=new Transaction(
                        resultSet.getInt("id"),
                        resultSet.getString("label"),
                        resultSet.getDouble("amount"),
                        resultSet.getTimestamp("transaction_date").toLocalDateTime(),
                        resultSet.getString("transaction_type")

                );


            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return transaction;
    }

    @Override
    public Transaction save(Transaction toSave) {
        String sql="INSERT INTO Transaction VALUES" +
                "(?,?,?,?,?,?) ON CONFLICT DO NOTHING";
        try{
            PreparedStatement preparedStatement=ConnectionDB.getConnection()
                    .getConnectionInstance().prepareStatement(sql);
           preparedStatement.setInt(1,toSave.getId());
           preparedStatement.setString(2,toSave.getLabel());
           preparedStatement.setDouble(3,toSave.getAmount());
           preparedStatement.setTimestamp(5, Timestamp.valueOf(toSave.getDate()));


            int rows=preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

        return toSave;
    }
public boolean saveTransactionByAccount(Transaction transaction,int idAccount){
    String sql="INSERT INTO Transaction VALUES" +
            "(?,?,?,?,?,?) ON CONFLICT DO NOTHING";
    int saved=0;
    try{
        PreparedStatement preparedStatement=ConnectionDB.getConnection()
                .getConnectionInstance().prepareStatement(sql);
        preparedStatement.setInt(1,transaction.getId());
        preparedStatement.setString(2,transaction.getLabel());
        preparedStatement.setDouble(3,transaction.getAmount());
        preparedStatement.setTimestamp(4, Timestamp.valueOf(transaction.getDate()));
        preparedStatement.setString(5,transaction.getType());
        preparedStatement.setInt(6,idAccount);


        saved=preparedStatement.executeUpdate();

    }catch (Exception e){
        e.printStackTrace();

    }
return saved!=0;
}
public List<Transaction> allTransactoinByIdAccount(int idAccount){
    String sql="select * from Transaction where id_account=?";
    List <Transaction> Transactions=new ArrayList<>();
    AccountCrudOperation account=new AccountCrudOperation();
    try {
        PreparedStatement preparedStatement= ConnectionDB
                .getConnection().getConnectionInstance().prepareStatement(sql);
        preparedStatement.setInt(1,idAccount);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Transactions.add(
                    new Transaction(
                            resultSet.getInt("id"),
                            resultSet.getString("label"),
                            resultSet.getDouble("amount"),
                            resultSet.getTimestamp("transaction_date").toLocalDateTime(),
                            resultSet.getString("transaction_type")
                    )
            );


        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return Transactions;
}
    @Override
    public List<Transaction> saveAll(List<Transaction> toSave) {
        List <Transaction> transactions=new ArrayList<>();
        for(Transaction transaction:toSave)
            transactions.add(save(transaction));
        return transactions;
    }

    @Override
    public Transaction update(Transaction toUpdate) {
       /* String sql="update Transaction set type=?,montant=?,categorie=? where id=?";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            preparedStatement.setString(1,toUpdate.getType());
            preparedStatement.setDouble(2,toUpdate.getAmount());
            preparedStatement.setString(3,toUpdate.getCategory());
            preparedStatement.setInt(4,toUpdate.getId());

            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return findById(toUpdate.getId());*/
        return  null;
    }
}
