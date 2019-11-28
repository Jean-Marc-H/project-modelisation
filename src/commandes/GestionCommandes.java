package commandes;

import paiement.Paiement;
import salle.Table;

import java.util.ArrayList;

public class GestionCommandes {
    private ArrayList<Commande> commandesActives=new ArrayList<Commande>();
    private ArrayList<Paiement> commandesCompletees=new ArrayList<Paiement>();

    public void creerCommande(Table table){
        Commande nouvelleCommande=new Commande(table);
        table.utiliser();
        table.setCommande(nouvelleCommande);
        this.commandesActives.add(nouvelleCommande);
    }

    public void completerCommande(Paiement paiement){
        this.commandesActives.remove(paiement.getCommande());
        paiement.getCommande().getTable().liberer();
        this.commandesCompletees.add(paiement);
    }

    public void annulerCommande(Commande commande){
        this.commandesActives.remove(commande);
        commande.getTable().liberer();
    }
}
