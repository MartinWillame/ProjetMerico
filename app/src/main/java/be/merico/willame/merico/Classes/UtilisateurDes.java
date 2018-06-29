package be.merico.willame.merico.Classes;

import android.util.SparseArray;

/**
 * Created by marti on 29-06-18.
 */

public class UtilisateurDes {

    //Variables

    private final int id;
    private int nbrMericoFait=0;
    private int nbr31Fait=0;
    private int dernierScore=0;
    private int nbrBeauJeu=0;
    private Utilisateur utilisateur;
    private Des des;

    private static SparseArray<UtilisateurDes> utilisateurDesSparseArray = new SparseArray<>();
    private static int idcounter=0;

    //Constructeurs

    public UtilisateurDes(Utilisateur utilisateur, Des des){
        this.id=idcounter;
        idcounter++;
        this.utilisateur=utilisateur;
        this.des=des;
        UtilisateurDes.utilisateurDesSparseArray.put(id,this);
    }

    public UtilisateurDes(Utilisateur utilisateur, Des des, int nbrMericoFait, int nbr31Fait, int nbrBeauJeu, int dernierScore){
        this.id=idcounter;
        idcounter++;
        this.utilisateur=utilisateur;
        this.des=des;
        this.nbr31Fait=nbr31Fait;
        this.dernierScore=dernierScore;
        this.nbrBeauJeu=nbrBeauJeu;
        this.nbrMericoFait=nbrMericoFait;
        UtilisateurDes.utilisateurDesSparseArray.put(id,this);
    }

    //Getteurs et setteurs basiques


    public static int getIdcounter() {
        return idcounter;
    }

    public int getId() {
        return id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Des getDes() {
        return des;
    }

    public int getDernierScore() {
        return dernierScore;
    }

    public int getNbr31Fait() {
        return nbr31Fait;
    }

    public int getNbrBeauJeu() {
        return nbrBeauJeu;
    }

    public int getNbrMericoFait() {
        return nbrMericoFait;
    }

    public static SparseArray<UtilisateurDes> getUtilisateurDesSparseArray() {
        return utilisateurDesSparseArray;
    }

    public void setDernierScore(int dernierScore) {
        this.dernierScore = dernierScore;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setDes(Des des) {
        this.des = des;
    }

    public void setNbr31Fait(int nbr31Fait) {
        this.nbr31Fait = nbr31Fait;
    }

    public void setNbrBeauJeu(int nbrBeauJeu) {
        this.nbrBeauJeu = nbrBeauJeu;
    }

    public void setNbrMericoFait(int nbrMericoFait) {
        this.nbrMericoFait = nbrMericoFait;
    }


}

