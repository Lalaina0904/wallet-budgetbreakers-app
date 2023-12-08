package Repository;

import entity.Transaction;
import entity.TransferHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransfertHisoruCrudOperation implements CrudOperation<TransferHistory> {
    Connection connection=ConnectionDB.getConnection().getConnectionInstance();
    String idColumnLabel="id";
    String idTransactionDebitorColumnLabel="id_transaction_debitor";
    String idTransactionCreditorColumnLabel="id_transaction_credior";
    String dateColumnLabel="transfert_date";
    @Override
    public List<TransferHistory> findAll() {
        String sql="select * from transfert_history";
        List<TransferHistory> transferHistories=new ArrayList<>();

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
              transferHistories.add(
                      new TransferHistory(
                              resultSet.getInt(idColumnLabel),
                resultSet.getInt(idTransactionDebitorColumnLabel),
                resultSet.getInt(idTransactionCreditorColumnLabel),
                              resultSet.getTimestamp(dateColumnLabel).toLocalDateTime()
                      )
              );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return transferHistories;
    }

    @Override
    public TransferHistory findById(int id) {
        String sql="select * from transfert_history where id=?";
        List<TransferHistory> transferHistories=new ArrayList<>();


        TransferHistory transferHistory=null;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
               transferHistory=
                        new TransferHistory(
                                resultSet.getInt(idColumnLabel),
                                resultSet.getInt(idTransactionDebitorColumnLabel),
                                resultSet.getInt(idTransactionCreditorColumnLabel),
                                resultSet.getTimestamp(dateColumnLabel).toLocalDateTime()
                        );

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return transferHistory;
    }

    @Override
    public TransferHistory save(TransferHistory toSave) {
        String sql="insert into transfert history values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(idColumnLabel));
            preparedStatement.setInt(2, Integer.parseInt(idTransactionDebitorColumnLabel));
            preparedStatement.setInt(3, Integer.parseInt(idTransactionCreditorColumnLabel));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(dateColumnLabel));
            int row= preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public List<TransferHistory> saveAll(List<TransferHistory> toSave) {
        List<TransferHistory> saves=new ArrayList<>();
        for(TransferHistory transferHistory:toSave){
            saves.add(save(transferHistory));
        }
        return saves;
    }

    @Override
    public TransferHistory update(TransferHistory toUpdate) {
        return null;
    }
}
