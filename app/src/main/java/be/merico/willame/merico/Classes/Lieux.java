package be.merico.willame.merico.Classes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

/**
 * Created by marti on 29-06-18.
 */

public class Lieux {

    //Variables

    private final int idl;
    private String nom;
    private String photo;

    public static SparseArray<Lieux> lieuxSparseArray = new SparseArray<>();

    //Constructeurs

    public Lieux(int idl, String nom, String photo){
        this.idl=idl;
        this.nom=nom;
        this.photo=photo;
        Lieux.lieuxSparseArray.put(idl, this);
    }

    //Getteurs et Setteurs basiques


    public String getPhoto() {
        return photo;
    }

    public static SparseArray<Lieux> getUserSparseArray() {
        return lieuxSparseArray;
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

    //Fonctions de lien avec la db

    //Autres fonctions


    /*
   retourne le plus petit Id libre dans la bdd pour créer un nouveau lieu
    */
    public static int getLowestLieuxIdAvailable(){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT DISTINCT MAX(Idl) FROM Lieux ",null );
        cursor.moveToFirst();
        int lIdMAX=0;
        while (!cursor.isAfterLast()) {
            lIdMAX = cursor.getInt(0);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return lIdMAX+1;
    }

    /*
    Retourne true si l'idl est déjà présent dans la bdd, sinon false;
     */
    public boolean isLieux(int idl){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Idl FROM Lieux ",null );
        cursor.moveToFirst();
        int id;
        while (!cursor.isAfterLast()){
            id=cursor.getInt(0);
            if(id==idl) {
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

    /*
    Retourne true si l'identifiant est déjà présent dans la bdd, sinon false
     */
    public boolean isLieux(String nom){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Nom FROM Lieux ",null );
        cursor.moveToFirst();
        String id;
        while (!cursor.isAfterLast()){
            id=cursor.getString(0);
            if(id.equals(nom)) {
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
