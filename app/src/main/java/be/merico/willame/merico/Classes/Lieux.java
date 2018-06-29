package be.merico.willame.merico.Classes;

/**
 * Created by marti on 29-06-18.
 */

public class Lieux {

    //Variables

    private final int idl;
    private String nom;
    private String photo;

    //Constructeurs

    public Lieux(int idl, String nom, String photo){
        this.idl=idl;
        this.nom=nom;
        this.photo=photo;
    }

    //Getteurs et Setteurs basiques


    public String getPhoto() {
        return photo;
    }

    public String getNom() {
        return nom;
    }

    public int getIdl() {
        return idl;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
