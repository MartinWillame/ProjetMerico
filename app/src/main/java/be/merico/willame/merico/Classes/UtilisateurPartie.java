package be.merico.willame.merico.Classes;

import android.util.SparseArray;

/**
 * Created by marti on 29-06-18.
 */

public class UtilisateurPartie {

    //Variables

    private final int id;
    private int nbrMericoBu=0;
    private int nbr31Bu=0;
    private int nbrDefaite=0;
    private Utilisateur utilisateur;
    private Partie partie;

    private static SparseArray<UtilisateurPartie> utilisateurPartieSparseArray = new SparseArray<>();
    private static int idcounter=1;

    //Constructeurs

    public UtilisateurPartie(Utilisateur utilisateur, Partie partie){
        this.id=idcounter;
        this.utilisateur=utilisateur;
        this.partie=partie;
        idcounter++;
        UtilisateurPartie.utilisateurPartieSparseArray.put(this.id,this);
    }

    public UtilisateurPartie(Utilisateur utilisateur, Partie partie, int nbr31Bu, int nbrDefaite, int nbrMericoBu){
        this.id=idcounter;
        this.utilisateur=utilisateur;
        this.partie=partie;
        idcounter++;
        this.nbr31Bu=nbr31Bu;
        this.nbrDefaite=nbrDefaite;
        this.nbrMericoBu=nbrMericoBu;
        UtilisateurPartie.utilisateurPartieSparseArray.put(this.id,this);
    }

    //Getteurs et setteurs basiques


    public int getId() {
        return id;
    }

    public Partie getPartie() {
        return partie;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public static int getIdcounter() {
        return idcounter;
    }

    public int getNbr31Bu() {
        return nbr31Bu;
    }

    public int getNbrDefaite() {
        return nbrDefaite;
    }

    public int getNbrMericoBu() {
        return nbrMericoBu;
    }

    public static SparseArray<UtilisateurPartie> getUtilisateurPartieSparseArray() {
        return utilisateurPartieSparseArray;
    }

    public void setNbr31Bu(int nbr31Bu) {
        this.nbr31Bu = nbr31Bu;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public void setNbrDefaite(int nbrDefaite) {
        this.nbrDefaite = nbrDefaite;
    }

    public void setNbrMericoBu(int nbrMericoBu) {
        this.nbrMericoBu = nbrMericoBu;
    }

}
