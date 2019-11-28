package salle;

import commandes.Commande;

public class Table {
    private int numero;
    private boolean occupe;
    private Commande commande;

    public Table(int numero){
        this.numero=numero;
        this.occupe=false;
        this.commande=null;
    }

    public int getNumero(){
        return this.numero;
    }

    public boolean estLibre(){
        return this.occupe;
    }

    public void setCommande(Commande commande){
        this.commande=commande;
    }

    public void utiliser(){
        this.occupe=true;
    }

    public void liberer(){
        this.occupe=false;
    }
}
