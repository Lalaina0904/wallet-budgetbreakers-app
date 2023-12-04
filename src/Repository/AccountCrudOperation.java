package Repository;

import entity.Account;
import entity.Currency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompteCrudOperation implements CrudOperation<Account> {

    @Override
    public List<Account> findAll() {
        String sql="select id,nom_du_compte,type_de_compte,montant_de_depart" +
                ",devise.* from compte inner join devise on devise=id_devise;";
        List<Account> accounts =new ArrayList<>();
        try {
            PreparedStatement preparedStatement=ConnectionDB
                    .getConnection().getConnectionInstance().prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                accounts.add(
                        new Account(
                                resultSet.getInt("id"),
                                resultSet.getString("nom_du_compte"),
                                resultSet.getString("type_de_compte"),
                                resultSet.getDouble("montant_de_depart"),
                                new Currency(
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
        return accounts;
    }

    @Override
    public Account findById(int id) {
        String sql="select id,nom_du_compte,type_de_compte,montant_de_depart" +
                ",devise.* from compte inner join devise on devise=id_devise where id=?;";
        Account account = null;
        try {
            PreparedStatement preparedStatement=ConnectionDB.getConnection()
                    .getConnectionInstance().prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                account =new Account(
                        resultSet.getInt("id"),
                        resultSet.getString("nom_du_compte"),
                        resultSet.getString("type_de_compte"),
                        resultSet.getDouble("montant_de_depart"),
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
        return account;
    }



    @Override
    public Account save(Account account) {
        String sql="INSERT INTO compte VALUES" +
                "(?,?,?,?,?) ON CONFLICT DO NOTHING";
        try{
            PreparedStatement preparedStatement=ConnectionDB.getConnection()
                    .getConnectionInstance().prepareStatement(sql);
            preparedStatement.setInt(1, account.getIdCompte());
            preparedStatement.setString(2, account.getNomDuCompte());
            preparedStatement.setString(3, account.getTypeDeCompte());
            preparedStatement.setDouble(4, account.getMontantDeDepart());
            preparedStatement.setInt(5, account.getDevise().getId_devise());
            int rows=preparedStatement.executeUpdate();
            System.out.println(rows>0 ? "inserted succefully" : "this compte already exists");
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {

        try{
            for(Account account : toSave){
            save(account);
           }
            System.out.println("inserted succefully");
        }catch (Exception e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public Account update(Account toUpdate) {
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
