package be.merico.willame.merico.Classes;

import android.content.ContentValues;
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
    Met-à-jour l'objet ainsi que la bdd
     */
    void setPhotoInDb(String photo){
        this.photo = photo;
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Photo", photo);
        String arg=Integer.toString(this.getIdu());
        // updating row
        db.update("Utilisateur", values, "Idu = " + arg,null);
        db.close();
    }

    /*
    Met-à-jour l'objet ainsi que la bdd
     */
    void setNomInDb(String nom){
        this.nom =nom;
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nom", nom);
        String arg=Integer.toString(this.getIdu());
        // updating row
        db.update("Utilisateur", values, "Idu = " + arg,null);
        db.close();
    }

    /*
    Met-à-jour l'objet ainsi que la bdd
    */
    void setPrenomInDb(String prenom){
        this.prenom =prenom;
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Prenom", prenom);
        String arg=Integer.toString(this.getIdu());
        // updating row
        db.update("Utilisateur", values, "Idu = " + arg,null);
        db.close();
    }

    /*
    Met-à-jour l'objet ainsi que la bdd
     */
    void setvilleInDb(String ville){
        this.ville = ville;
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Ville", ville);
        String arg=Integer.toString(this.getIdu());
        // updating row
        db.update("Utilisateur", values, "Idu = " + arg,null);
        db.close();
    }

    /*
    Met-à-jour l'objet ainsi que la bdd
     */
    void setUnnifInDb(String unnif){
        this.unnif = unnif;
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Unnif", unnif);
        String arg=Integer.toString(this.getIdu());
        // updating row
        db.update("Utilisateur", values, "Idu = " + arg,null);
        db.close();
    }

    /*
   modifie la bdd ainsi que l'objet et retourne true si la modification a pu être faite
   Si false est retourne alors l'identifiant existe deja pour un autre utilisateur
    */
    public boolean setIdentifiantInDb(String nouveauIdentifiant){

    }





    //Autres Fonctions

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

    /*
    Retourne true si l'identifiant est déjà présent dans la bdd, sinon false
     */
    public boolean isUtilisateur(String identifiant){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Identifiant FROM Utilisateur ",null );
        cursor.moveToFirst();
        String id;
        while (!cursor.isAfterLast()){
            id=cursor.getString(0);
            if(id.equals(identifiant)) {
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
    Retourne true si l'idu est déjà présent dans la bdd, sinon false;
     */
    public boolean isUtilisateur(int idu){
        SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT Idu FROM Utilisateur ",null );
        cursor.moveToFirst();
        int id;
        while (!cursor.isAfterLast()){
            id=cursor.getInt(0);
            if(id==idu) {
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
    Retourne l'utilisateur correspondant à l'identifiant en argumment, si il n'existe pas dans la bdd retourne null
     */
    public Utilisateur getUtilisateur(int idu){
        Utilisateur uti = userSparseArray.get(idu);
        if(uti==null){
            SQLiteDatabase db = MySQLiteHelper.get().getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM Utilisateur u WHERE idu==u.Idu",null );
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                String photo = cursor.getString(1);
                String nom = cursor.getString(2);
                String prenom = cursor.getString(3);
                String ville = cursor.getString(4);
                String unnif = cursor.getString(5);
                String identifiant = cursor.getString(6);
                uti = new Utilisateur(idu,nom,prenom,ville,unnif,identifiant,photo);
                cursor.moveToNext();
            }
            cursor.close();
            db.close();
        }
        return uti;
    }









}

