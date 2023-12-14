package Repository;

import entity.TransferHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransfertHistoryOperation {
    Connection connection=ConnectionDB.getConnection().getConnectionInstance();
    String idTransfertHistoryColumn="id";
    String idTransactionDebitorColumn="id_transaction_debitor";
    String idTransactionCreditorColumn="id_transaction_creditor";
    String amomuntColumn="amount";
    String transfertDateColumn="transfert_date";

    public List<TransferHistory> findByGivenDate(LocalDateTime startDate,LocalDateTime endDate) {
        String sql="select * from transfert_history where transfert_date between ? and ?";
        List<TransferHistory> transferHistories=new ArrayList<>();

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1,Timestamp.valueOf(startDate));
            preparedStatement.setTimestamp(2,Timestamp.valueOf(endDate));
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                transferHistories.add(
                        new TransferHistory(
                                resultSet.getInt(idTransfertHistoryColumn),
                                resultSet.getInt(idTransactionDebitorColumn),
                                resultSet.getInt(idTransactionCreditorColumn),
                                resultSet.getDouble(amomuntColumn),
                                resultSet.getTimestamp(transfertDateColumn).toLocalDateTime()
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return transferHistories;
    }
    public TransferHistory save(TransferHistory toSave) {
        String sql="insert into transfert_history values (?,?,?,?,?) on conflict do nothing";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1, toSave.getId());
            preparedStatement.setInt(2, toSave.getIdTransactionDebitor());
            preparedStatement.setInt(3, toSave.getIdTransactionCreditor());
            preparedStatement.setDouble(4,toSave.getAmount());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(toSave.getDateTime()));
            int row= preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }


    public List<TransferHistory> getTransfertHistoryByIdCreditor(int idCreditorAccount){
        String sql="select * from transfert_history inner join transaction on id_transaction_creditor=transaction.id where id_account=?";
        List<TransferHistory> CreditorAccountHistoryTransfert=new ArrayList<>();

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,idCreditorAccount);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                CreditorAccountHistoryTransfert.add(
                        new TransferHistory(
                                resultSet.getInt("id"),
                                resultSet.getInt("id_transaction_debitor"),
                                resultSet.getInt("id_transaction_creditor"),
                                resultSet.getDouble("amount"),
                                resultSet.getTimestamp("transfert_date").toLocalDateTime()
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return CreditorAccountHistoryTransfert;
    }
}
