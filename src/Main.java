import Repository.CompteCrudOperation;
import Repository.ConnectionDB;
import entity.Compte;
import entity.Devise;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CompteCrudOperation compteCrudOperation=new CompteCrudOperation();
        //
       List<Compte> comptes= compteCrudOperation.findAll();
       for(Compte compte:comptes){
           System.out.println(compte);
       }
        System.out.println(compteCrudOperation.findById(2));
       Compte compte=new Compte(5,"Test5","espece",
               300,new Devise(2));
       compteCrudOperation.save(compte);
       Compte compteToUpdate=new Compte(5,"updatedAccount","espece",
               300,new Devise(2));
        System.out.println(compteCrudOperation.update(compteToUpdate));
    }
}