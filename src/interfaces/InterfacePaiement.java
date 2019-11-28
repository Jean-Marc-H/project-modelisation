package interfaces;

public class InterfacePaiement {
    /*
    Je pense que le paiement est fait dans l'interface de commandes, mais les instructions fonctionnent pareil
    -Les methodes de paiement sont comptant et par carte
    Pour faire le paiement:
    -Instancier le paiement, avec la commande comme parametre d'instanciation (new Paiement(Commande) )
    -Si le paiement est avec carte, utiliser Paiement.payer(MethodePaiement.CARTE)
    -Si le paiement est comptant, utiliser Paiement.payer(MethodePaiement.COMPTANT)
    -Rafraichir l'interface de la salle, parce que la table est liberee
     */
}
