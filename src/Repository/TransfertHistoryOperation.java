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
        String sql="insert into transfert history values (?,?,?,?)";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(idTransfertHistoryColumn));
            preparedStatement.setInt(2, Integer.parseInt(idTransactionDebitorColumn));
            preparedStatement.setInt(3, Integer.parseInt(idTransactionCreditorColumn));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(transfertDateColumn));
            int row= preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }
}
