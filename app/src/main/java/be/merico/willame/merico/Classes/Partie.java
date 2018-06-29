package be.merico.willame.merico.Classes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

import java.util.LinkedList;

/**
 * Created by marti on 29-06-18.
 */

public class Partie {

    //Variables

    private final int idp;
    private int nbrTour;
    private Utilisateur lastLooser;
    private Lieux lieu;
    private Mode_De_Jeu modeDeJeu;
    private Des des;
    private LinkedList<Utilisateur> listofplayers;

    private static SparseArray<Partie> partieSparseArray= new SparseArray<>();


    //Constructeurs

    public Partie(int idp, Lieux lieu, Mode_De_Jeu modeDeJeu,Des des){
        this.idp=idp;
        this.nbrTour=0;
        this.lastLooser=null;
        this.modeDeJeu=modeDeJeu;
        this.lieu=lieu;
        this.listofplayers = new LinkedList<>();
        this.des=des;
        Partie.partieSparseArray.put(idp,this);
    }

    //Getteurs et setteurs basiques


    public Des getDes() {
        return des;
    }

    public static SparseArray<Partie> getPartieSparseArray() {
        return partieSparseArray;
    }

    public int getIdp() {
        return idp;
    }

    public int getNbrTour() {
        return nbrTour;
    }

    public Lieux getLieu() {
        return lieu;
    }

    public LinkedList<Utilisateur> getListofplayers() {
        return listofplayers;
    }

    public Mode_De_Jeu getModeDeJeu() {
        return modeDeJeu;
    }

    public Utilisateur getLastLooser() {
        return lastLooser;
    }

    public void setDes(Des des) {
        this.des = des;
    }

    public void setLastLooser(Utilisateur lastLooser) {
        this.lastLooser = lastLooser;
    }

    public void setLieu(Lieux lieu) {
        this.lieu = lieu;
    }

    public void setListofplayers(LinkedList<Utilisateur> listofplayers) {
        this.listofplayers = listofplayers;
    }

    public void setModeDeJeu(Mode_De_Jeu modeDeJeu) {
        this.modeDeJeu = modeDeJeu;
    }

    public void setNbrTour(int nbrTour) {
        this.nbrTour = nbrTour;
    }

    //Fonctions de lien avec la db


    /*
   retourne le plus petit Id libre dans la bdd pour créer une nouvelle partie
    */
    public static int getLowestPartieIdAvailable(){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT DISTINCT MAX(Idp) FROM Partie ",null );
        cursor.moveToFirst();
        int pIdMAX=0;
        while (!cursor.isAfterLast()) {
            pIdMAX = cursor.getInt(0);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return pIdMAX+1;
    }

}
