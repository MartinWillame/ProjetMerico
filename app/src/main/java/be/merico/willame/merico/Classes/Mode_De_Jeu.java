package be.merico.willame.merico.Classes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

/**
 * Created by marti on 29-06-18.
 */

public class Mode_De_Jeu {

    //Variables

    private final int idm;
    private String regle;
    private String nom;

    public static SparseArray<Mode_De_Jeu> modeDeJeuSparseArray = new SparseArray<>();

    //Constructeurs

    public Mode_De_Jeu(int idm, String regle, String nom){
        this.idm=idm;
        this.nom=nom;
        this.regle=regle;
        Mode_De_Jeu.modeDeJeuSparseArray.put(idm,this);
    }

    //Getteurs et setteurs basiques


    public String getNom() {
        return nom;
    }

    public static SparseArray<Mode_De_Jeu> getModeDeJeuSparseArray() {
        return modeDeJeuSparseArray;
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

    //Fonctions de lien avec la db

    //Autres fonctions


    /*
   retourne le plus petit Id libre dans la bdd pour créer un nouveau Mode de jeu
    */
    public static int getLowestmdjIdAvailable(){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT DISTINCT MAX(Idm) FROM ModeDeJeu ",null );
        cursor.moveToFirst();
        int mIdMAX=0;
        while (!cursor.isAfterLast()) {
            mIdMAX = cursor.getInt(0);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return mIdMAX+1;
    }

    /*
    Retourne true si l'idm est déjà présent dans la bdd, sinon false;
     */
    public boolean isModeDeJeu(int idm){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Idm FROM ModeDeJeu ",null );
        cursor.moveToFirst();
        int id;
        while (!cursor.isAfterLast()){
            id=cursor.getInt(0);
            if(id==idm) {
                cursor.close();
                db.close();
                return true;
            }
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return false;
    }
}
