package entity;

public class Compte {
    private int idCompte;
    private String nomDuCompte;
    private String typeDeCompte;
    private double montantDeDepart;
    private Devise devise;

    // constructeur
    public Compte(int idCompte, String nomDuCompte, String typeDeCompte, double montantDeDepart, Devise devise) {
        this.idCompte = idCompte;
        this.nomDuCompte = nomDuCompte;
        this.typeDeCompte = typeDeCompte;
        this.montantDeDepart = montantDeDepart;
        this.devise = devise;
    }

    // getters et setters

    public int getId() {
        return idCompte;
    }

    public void setId(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getNomDuCompte() {
        return nomDuCompte;
    }

    public void setNomDuCompte(String nomDuCompte) {
        this.nomDuCompte = nomDuCompte;
    }

    public String getTypeDeCompte() {
        return typeDeCompte;
    }

    public void setTypeDeCompte(String typeDeCompte) {
        this.typeDeCompte = typeDeCompte;
    }

    public double getMontantDeDepart() {
        return montantDeDepart;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setMontantDeDepart(double montantDeDepart) {
        this.montantDeDepart = montantDeDepart;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    // toString -- pour afficher les informations d'un compte au format String
    @Override
    public String toString() {
        return "Compte{" +
                "id=" + idCompte +
                ", nomDuCompte='" + nomDuCompte + '\'' +
                ", typeDeCompte='" + typeDeCompte + '\'' +
                ", montantDeDepart=" + montantDeDepart +
                ", devise='" + devise + '\'' +
                '}';
    }
}
