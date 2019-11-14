package paiement;

import commandes.Commande;

public class Paiement {
    public MethodePaiement methode;
    public Commande commande;
    public double montantRestant;

    public enum MethodePaiement{
        COMPTANT,
        CARTE
    }
}
