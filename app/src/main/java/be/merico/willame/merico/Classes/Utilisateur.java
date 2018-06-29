package be.merico.willame.merico.Classes;

/**
 * Created by marti on 26-06-18.
 */

public class Utilisateur {

    //Variables

    private final int idu;
    private String nom;
    private String prenom;
    private String ville;
    private String unnif;
    private String identifiant;
    private String photo;

    //Constructeurs

    public Utilisateur(int idu,String nom,String prenom,String ville,String unnif,String identifiant,String photo){
        this.idu=idu;
        this.nom=nom;
        this.photo=photo;
        this.prenom=prenom;
        this.ville=ville;
        this.unnif=unnif;
        this.identifiant=identifiant;
    }

    //Getteurs et setteurs basiques


    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUnnif() {
        return unnif;
    }

    public String getVille() {
        return ville;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setUnnif(String unnif) {
        this.unnif = unnif;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}

