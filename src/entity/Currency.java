package entity;

public class Devise {
    int id_devise;
    String nom;
    String code_iso;
    public Devise(int id_devise, String nom, String code_iso) {
        this.id_devise = id_devise;
        this.nom = nom;
        this.code_iso = code_iso;
    }
    public  Devise(int id_devise){
        this.id_devise=id_devise;
    }

    public int getId_devise() {
        return id_devise;
    }

    public String getNom() {
        return nom;
    }

    public String getCode_iso() {
        return code_iso;
    }

    @Override
    public String toString() {
        return "Devise{" +
                "id_devise=" + id_devise +
                ", nom='" + nom + '\'' +
                ", code_iso='" + code_iso + '\'' +
                '}';
    }

    public void setId_devise(int id_devise) {
        this.id_devise = id_devise;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCode_iso(String code_iso) {
        this.code_iso = code_iso;
    }


}
