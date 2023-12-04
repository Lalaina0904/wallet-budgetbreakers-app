package Repository;

import entity.Currency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeviseCrudOperation implements CrudOperation<Currency> {


    public List<Currency> findAll() {
        String sql="select * from devise ";
        List <Currency> currencies =new ArrayList<>();
        try {
            PreparedStatement preparedStatement= ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                currencies.add(
                        new Currency(
                                resultSet.getInt("id_devise"),
                                resultSet.getString("nom_devise"),
                                resultSet.getString("code_iso")
                        )
                );


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return currencies;
    }

    @Override
    public Currency findById(int id) {
        String sql="select * from devise where id_devise=?";
        Currency currency =null;
        try {
            PreparedStatement preparedStatement= ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){

                        new Currency(
                                resultSet.getInt("id_devise"),
                                resultSet.getString("nom_devise"),
                                resultSet.getString("code_iso")
                        );


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return currency;
    }

    @Override
    public Currency save(Currency toSave) {
        String sql="INSERT INTO devise VALUES" +
                "(?,?,?) ON CONFLICT DO NOTHING";
        try{
            PreparedStatement preparedStatement=ConnectionDB.getConnection()
                    .getConnectionInstance().prepareStatement(sql);
            preparedStatement.setInt(1,toSave.getIdCurrency());
            preparedStatement.setString(2,toSave.getName());
            preparedStatement.setString(3,toSave.getCode());

            int rows=preparedStatement.executeUpdate();
            System.out.println(rows>0 ? "inserted succefully" : "this currency already exists");
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public List<Currency> saveAll(List<Currency> toSave) {
        String sql="INSERT INTO devise VALUES" +
                "(?,?,?) ON CONFLICT DO NOTHING";
        try{
            PreparedStatement preparedStatement=ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
           for (Currency currency :toSave){
               preparedStatement.setInt(1, currency.getIdCurrency());
               preparedStatement.setString(2, currency.getName());
               preparedStatement.setString(3, currency.getCode());
               preparedStatement.addBatch();
           }
          int rows[]= preparedStatement.executeBatch();
        }catch (Exception e){
            e.printStackTrace();
        }

        return toSave;
    }

    @Override
    public Currency update(Currency toUpdate) {
        String sql="update devise set nom_devise=?,code_iso=? where id_devise=?";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            preparedStatement.setString(1,toUpdate.getName());
            preparedStatement.setString(2,toUpdate.getCode());
            preparedStatement.setInt(3,toUpdate.getIdCurrency());

            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return findById(toUpdate.getIdCurrency());
    }
}
