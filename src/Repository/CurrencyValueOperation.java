package Repository;

import entity.Account;
import entity.CurrencyValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CurrencyValueOperation {
    Connection connection=ConnectionDB.getConnection().getConnectionInstance();
    String idCurrencyValueColumn="id_currency_value";
    String idCurrencySourceColumn="id_currency_source";
    String idCurrencyDestinationColumn="id_currency_destination";
    String valueColumn="value";
    String dateColumn="date";
    public  CurrencyValue  getLastCurrencyValue(){
        String sql="select * from currency_value order by date DESC limit=1";
        CurrencyValue currencyValue=null;
      try {
          Statement statement=connection.createStatement();
          ResultSet resultSet= statement.executeQuery(sql);
          while (resultSet.next()){
              currencyValue=
                      new CurrencyValue(

                              resultSet.getInt(idCurrencyValueColumn),
                              resultSet.getInt(idCurrencySourceColumn),
                              resultSet.getInt(idCurrencyDestinationColumn),
                              resultSet.getDouble(idCurrencyValueColumn),
                              resultSet.getDate(dateColumn).toLocalDate()
                      );

          }

      }catch (Exception e){
          e.printStackTrace();
      }
      return currencyValue;
    }
}
