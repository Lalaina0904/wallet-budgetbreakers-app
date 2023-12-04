package Repository;

import entity.Devise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeviseCrudOperation implements CrudOperation<Devise> {


    public List<Devise> findAll() {
        String sql="select * from devise ";
        List <Devise> devises=new ArrayList<>();
        try {
            PreparedStatement preparedStatement= ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                devises.add(
                        new Devise(
                                resultSet.getInt("id_devise"),
                                resultSet.getString("nom_devise"),
                                resultSet.getString("code_iso")
                        )
                );


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return devises;
    }

    @Override
    public Devise findById(int id) {
        String sql="select * from devise where id_devise=?";
        Devise devise=null;
        try {
            PreparedStatement preparedStatement= ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){

                        new Devise(
                                resultSet.getInt("id_devise"),
                                resultSet.getString("nom_devise"),
                                resultSet.getString("code_iso")
                        );


            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return devise;
    }

    @Override
    public Devise save(Devise toSave) {
        String sql="INSERT INTO devise VALUES" +
                "(?,?,?) ON CONFLICT DO NOTHING";
        try{
            PreparedStatement preparedStatement=ConnectionDB.getConnection()
                    .getConnectionInstance().prepareStatement(sql);
            preparedStatement.setInt(1,toSave.getId_devise());
            preparedStatement.setString(2,toSave.getNom());
            preparedStatement.setString(3,toSave.getCode_iso());

            int rows=preparedStatement.executeUpdate();
            System.out.println(rows>0 ? "inserted succefully" : "this currency already exists");
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public List<Devise> saveAll(List<Devise> toSave) {
        String sql="INSERT INTO devise VALUES" +
                "(?,?,?) ON CONFLICT DO NOTHING";
        try{
            PreparedStatement preparedStatement=ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
           for (Devise devise:toSave){
               preparedStatement.setInt(1,devise.getId_devise());
               preparedStatement.setString(2,devise.getNom());
               preparedStatement.setString(3,devise.getCode_iso());
               preparedStatement.addBatch();
           }
          int rows[]= preparedStatement.executeBatch();
        }catch (Exception e){
            e.printStackTrace();
        }

        return toSave;
    }

    @Override
    public Devise update(Devise toUpdate) {
        String sql="update devise set nom_devise=?,code_iso=? where id_devise=?";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            preparedStatement.setString(1,toUpdate.getNom());
            preparedStatement.setString(2,toUpdate.getCode_iso());
            preparedStatement.setInt(3,toUpdate.getId_devise());

            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return findById(toUpdate.getId_devise());
    }
}
