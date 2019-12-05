package salle;

import commandes.Commande;
import executable.Programme;

public class Table {
    private int numero;
    private EtatTable etat;
    private Commande commande;

    public Table(int numero){
        this.numero=numero;
        this.etat=EtatTable.VIDE;
        this.commande=null;
    }

    public void annulerCommande(){
        Programme.gestionCommandes.annulerCommande(this.commande);
        this.etat=EtatTable.VIDE;
    }

    public int getNumero(){
        return this.numero;
    }

    public EtatTable getEtat(){
        return this.etat;
    }

    public void setProchainEtat(){
        if(this.etat!=EtatTable.SALE)
            this.etat=EtatTable.values()[this.etat.ordinal()+1];
        else
            this.etat=EtatTable.VIDE;
    }

    public void setEnAttente(){
        this.etat=EtatTable.EN_ATTENTE;
    }

    public void setCommande(Commande commande){
        this.commande=commande;
    }

    public enum EtatTable{
        VIDE,
        PRET,
        EN_ATTENTE,
        PRET_A_SERVIR,
        SERVI,
        SALE
    }
}
