package be.merico.willame.merico.Classes;

/**
 * Created by marti on 26-06-18.
 */

public class Utilisateur {


    private String motDePasse;
    private String nom;
    private String prenom;
    private String identifiant;

    public Utilisateur(int id, String motDePasse, String nom, String prenom, String identifiant, String photo, String mail, int bestFriend) {

        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
    }
}
