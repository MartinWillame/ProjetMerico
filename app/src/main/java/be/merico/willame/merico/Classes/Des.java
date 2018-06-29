package be.merico.willame.merico.Classes;

/**
 * Created by marti on 29-06-18.
 */

public class Des {

    //Variables

    private final int idd;
    private int valeur1;
    private int valeur2;
    private int nbrLance;

    //Constructeurs

    public Des(int idd){
        this.idd=idd;
        this.valeur1=0;
        this.valeur2=0;
        this.nbrLance=0;
    }

    //Getteurs et setteurs basiques


    public int getIdd() {
        return idd;
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
}
