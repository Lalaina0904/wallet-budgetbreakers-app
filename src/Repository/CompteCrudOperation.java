package Repository;

import entity.Compte;
import entity.Devise;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompteCrudOperation implements CrudOperation<Compte> {

    @Override
    public List<Compte> findAll() {
        String sql="select id,nom_du_compte,type_de_compte,montant_de_depart" +
                ",devise.* from compte inner join devise on devise=id_devise;";
        List<Compte> comptes=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                comptes.add(
                        new Compte(
                                resultSet.getInt("id"),
                                resultSet.getString("nom_du_compte"),
                                resultSet.getString("type_de_compte"),
                                resultSet.getDouble("montant_de_depart"),
                                new Devise(
                                        resultSet.getInt("id_devise"),
                                        resultSet.getString("nom_devise"),
                                        resultSet.getString("code_iso")
                                )

                        )
                );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return comptes;
    }

    @Override
    public Compte findById(int id) {
        String sql="select id,nom_du_compte,type_de_compte,montant_de_depart" +
                ",devise.* from compte inner join devise on devise=id_devise where id=?;";
        Compte compte = null;
        try {
            PreparedStatement preparedStatement=ConnectionDB.getConnection()
                    .getConnectionInstance().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                compte=new Compte(
                        resultSet.getInt("id"),
                        resultSet.getString("nom_du_compte"),
                        resultSet.getString("type_de_compte"),
                        resultSet.getDouble("montant_de_depart"),
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
        return compte;
    }



    @Override
    public Compte save(Compte compte) {
        String sql="INSERT INTO compte VALUES" +
                "(?,?,?,?,?) ON CONFLICT DO NOTHING";
        try{
            PreparedStatement preparedStatement=ConnectionDB.getConnection()
                    .getConnectionInstance().prepareStatement(sql);
            preparedStatement.setInt(1,compte.getIdCompte());
            preparedStatement.setString(2,compte.getNomDuCompte());
            preparedStatement.setString(3,compte.getTypeDeCompte());
            preparedStatement.setDouble(4,compte.getMontantDeDepart());
            preparedStatement.setInt(5,compte.getDevise().getId_devise());
            int rows=preparedStatement.executeUpdate();
            System.out.println(rows>0 ? "inserted succefully" : "this compte already exists");
        }catch (Exception e){
            e.printStackTrace();
        }
        return compte;
    }

    @Override
    public List<Compte> saveAll(List<Compte> toSave) {

        try{
            for(Compte compte : toSave){
            save(compte);
           }
            System.out.println("inserted succefully");
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Compte update(Compte toUpdate) {
        String sql="update compte set nom_du_compte=?,type_de_compte=?,devise=? where id=?";
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            preparedStatement.setString(1,toUpdate.getNomDuCompte());
            preparedStatement.setString(2,toUpdate.getTypeDeCompte());
            preparedStatement.setInt(3,toUpdate.getDevise().getId_devise());
            preparedStatement.setInt(4,toUpdate.getIdCompte());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return findById(toUpdate.getIdCompte());
    }
}
