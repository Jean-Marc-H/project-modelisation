package salle;

public class Table {
    int sieges;
    boolean occupe;

    public int getSieges(){
        return this.sieges;
    }

    public boolean estLibre(){
        return this.occupe;
    }

    public void utiliser(){
        this.occupe=true;
    }

    public void liberer(){
        this.occupe=false;
    }
}
