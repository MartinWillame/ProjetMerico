package be.merico.willame.merico.Classes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

/**
 * Created by marti on 29-06-18.
 */

public class Des {

    //Variables

    private final int idd;
    private int valeur1;
    private int valeur2;
    private int nbrLance;

    private static SparseArray<Des> desSparseArray= new SparseArray<>();

    //Constructeurs

    public Des(int idd){
        this.idd=idd;
        this.valeur1=0;
        this.valeur2=0;
        this.nbrLance=0;
        Des.desSparseArray.put(idd,this);
    }

    //Getteurs et setteurs basiques


    public int getIdd() {
        return idd;
    }

    public static SparseArray<Des> getDesSparseArray() {
        return desSparseArray;
    }

    public int getNbrLance() {
        return nbrLance;
    }

    public int getValeur1() {
        return valeur1;
    }

    public int getValeur2() {
        return valeur2;
    }

    public void setNbrLance(int nbrLance) {
        this.nbrLance = nbrLance;
    }

    public void setValeur1(int valeur1) {
        this.valeur1 = valeur1;
    }

    public void setValeur2(int valeur2) {
        this.valeur2 = valeur2;
    }

    //Fonctions de lien avec la db

    //Autres fonctions


    /*
   retourne le plus petit Id libre dans la bdd pour créer un nouveau des
    */
    public static int getLowestUserIdAvailable(){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT DISTINCT MAX(Idd) FROM Dés ",null );
        cursor.moveToFirst();
        int dIdMAX=0;
        while (!cursor.isAfterLast()) {
            dIdMAX = cursor.getInt(0);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return dIdMAX+1;
    }

    /*
    Retourne true si l'idd est déjà présent dans la bdd, sinon false;
     */
    public boolean isDes(int idd){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Idd FROM Dés ",null );
        cursor.moveToFirst();
        int id;
        while (!cursor.isAfterLast()){
            id=cursor.getInt(0);
            if(id==idd) {
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
