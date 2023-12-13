package Repository;

import entity.TransferHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

public class TransfertHistoryOperation {
    Connection connection=ConnectionDB.getConnection().getConnectionInstance();
    String idTransfertHistoryColumn="id";
    String idTransactionDebitorColumn="id_transaction_debitor";
    String idTransactionCreditorColumn="id_transaction_creditor";
    String transfertDateColumn="transfert_date";
    public TransferHistory save(TransferHistory transferHistory){
        String sql="insert into transfert_history values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, transferHistory.getId());
            preparedStatement.setInt(2, transferHistory.getIdTransactionDebitor());
            preparedStatement.setInt(3, transferHistory.getIdTransactionCreditor());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(transferHistory.getDateTime()));
           int row= preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return transferHistory;
    }
}
