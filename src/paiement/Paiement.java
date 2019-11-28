package paiement;

import commandes.Commande;
import executable.Programme;

public class Paiement {
    private MethodePaiement methodePaiement;
    private Commande commande;
    private double total;

    public Paiement(Commande commande){
        this.commande=commande;
        this.total=commande.calculerTotal();
    }

    public Commande getCommande(){
        return this.commande;
    }

    public void payer(MethodePaiement methodePaiement){
        this.methodePaiement=methodePaiement;
        Programme.gestionCommandes.completerCommande(this);
    }

    public enum MethodePaiement{
        COMPTANT,
        CARTE
    }
}
