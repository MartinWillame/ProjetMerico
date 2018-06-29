package be.merico.willame.merico.Classes;

/**
 * Created by marti on 29-06-18.
 */

public class Mode_De_Jeu {

    //Variables

    private final int idm;
    private String regle;
    private String nom;

    //Constructeurs

    public Mode_De_Jeu(int idm, String regle, String nom){
        this.idm=idm;
        this.nom=nom;
        this.regle=regle;
    }

    //Getteurs et setteurs basiques


    public String getNom() {
        return nom;
    }

    public int getIdm() {
        return idm;
    }

    public String getRegle() {
        return regle;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRegle(String regle) {
        this.regle = regle;
    }
}
