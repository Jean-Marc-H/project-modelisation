package commandes;

import java.util.ArrayList;

public class GestionCommandes {
    public ArrayList<Commande> commandesActives=new ArrayList<Commande>();
    public ArrayList<Commande> commandesCompletees=new ArrayList<Commande>();

    public void creerCommande(){
        Commande nouvelleCommande=new Commande();
        this.commandesActives.add(nouvelleCommande);
    }

    public void completerCommande(Commande commande){
        this.commandesActives.remove(commande);
        this.commandesCompletees.add(commande);
    }

    public void annulerCommande(Commande commande){
        this.commandesActives.remove(commande);
    }
}
