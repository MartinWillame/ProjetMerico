package be.merico.willame.merico.Classes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;

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

    public static SparseArray<Utilisateur> userSparseArray = new SparseArray<>();
    public static Utilisateur connectedUser = null;


    //Constructeurs

    public Utilisateur(int idu,String nom,String prenom,String ville,String unnif,String identifiant,String photo){
        this.idu=idu;
        this.nom=nom;
        this.photo=photo;
        this.prenom=prenom;
        this.ville=ville;
        this.unnif=unnif;
        this.identifiant=identifiant;
        Utilisateur.userSparseArray.put(idu, this);

    }

    //Getteurs et setteurs basiques


    public String getIdentifiant() {
        return identifiant;
    }

    public static SparseArray<Utilisateur> getUserSparseArray() {
        return userSparseArray;
    }

    public static Utilisateur getConnectedUser() {
        return connectedUser;
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

    public static void setConnectedUser(Utilisateur connectedUser) {
        Utilisateur.connectedUser = connectedUser;
    }

    public void setUnnif(String unnif) {
        this.unnif = unnif;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    //Fonctions de lien avec la db


    /*
   retourne le plus petit Id libre dans la bdd pour créer un nouveel utilisateur
    */
    public static int getLowestUserIdAvailable(){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT DISTINCT MAX(ID_User) FROM Utilisateur ",null );
        cursor.moveToFirst();
        int uIdMAX=0;
        while (!cursor.isAfterLast()) {
            uIdMAX = cursor.getInt(0);
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return uIdMAX+1;
    }





}

