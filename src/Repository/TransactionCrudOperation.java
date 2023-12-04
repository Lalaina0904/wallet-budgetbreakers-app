package Repository;

import entity.Devise;
import entity.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransactionCrudOperation implements CrudOperation<Transaction>{
    @Override
    public List<Transaction> findAll() {
        String sql="select * from Transaction ";
        List <Transaction> Transactions=new ArrayList<>();
        CompteCrudOperation compte=new CompteCrudOperation();
        try {
            PreparedStatement preparedStatement= ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Transactions.add(
                        new Transaction(
                              resultSet.getInt("id"),
                                resultSet.getString("type"),
                                compte.findById(resultSet.getInt("compte_id")),
                                resultSet.getDouble("montant"),
                                resultSet.getString("categorie"),
                                resultSet.getDate("date"),
                                resultSet.getTime("hour")
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
        CompteCrudOperation compte=new CompteCrudOperation();
        try {
            PreparedStatement preparedStatement= ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){

                transaction=new Transaction(
                                resultSet.getInt("id"),
                                resultSet.getString("type"),
                                compte.findById(resultSet.getInt("compte_id")),
                                resultSet.getDouble("montant"),
                                resultSet.getString("categorie"),
                                resultSet.getDate("date"),
                                resultSet.getTime("hour")

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
                "(?,?,?,?,?,?,?) ON CONFLICT DO NOTHING";
        try{
            PreparedStatement preparedStatement=ConnectionDB.getConnection()
                    .getConnectionInstance().prepareStatement(sql);
           preparedStatement.setInt(1,toSave.getId());
           preparedStatement.setString(2,toSave.getType());
           preparedStatement.setInt(3,toSave.getCompte().getIdCompte());
           preparedStatement.setDouble(4,toSave.getMontant());
           preparedStatement.setString(5,toSave.getCategorie());
           preparedStatement.setDate(6,toSave.getDate());
           preparedStatement.setTime(7,toSave.getHour());


            int rows=preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

        return toSave;
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
        String sql="update Transaction set type=?,montant=?,categorie=? where id=?";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            preparedStatement.setString(1,toUpdate.getType());
            preparedStatement.setDouble(2,toUpdate.getMontant());
            preparedStatement.setString(3,toUpdate.getCategorie());
            preparedStatement.setInt(4,toUpdate.getId());

            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return findById(toUpdate.getId());
    }
}
