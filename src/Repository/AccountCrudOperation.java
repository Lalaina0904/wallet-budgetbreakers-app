package Repository;

import entity.Account;
import entity.Currency;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountCrudOperation implements CrudOperation<Account> {

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
            preparedStatement.setInt(1, account.getIdAccount());
            preparedStatement.setString(2, account.getAccountName());
            preparedStatement.setString(3, account.getAccountType());
            preparedStatement.setDouble(4, account.getInitialAmount());
            preparedStatement.setInt(5, account.getCurrency().getIdCurrency());
            int rows=preparedStatement.executeUpdate();
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
            preparedStatement.setString(1,toUpdate.getAccountName());
            preparedStatement.setString(2,toUpdate.getAccountType());
            preparedStatement.setInt(3,toUpdate.getCurrency().getIdCurrency());
            preparedStatement.setInt(4,toUpdate.getIdAccount());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return findById(toUpdate.getIdAccount());
    }
}
