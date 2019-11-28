package interfaces;

import commandes.Commande;

public class InterfaceCommandes {
    private Commande commande;

    /*
    -Lors de l'initialisation de l'interface, set la commande avec celle associée à la table sélectionnée
    -Pour les articles dans la droplist, regarder avec Programme.menuArticles.getArticles()
    -Pour chaque article dans getArticles(), obtenir le nom avec getNom()
    -Pour ajouter un article dans la commande, utiliser commande.ajouterArticle(Article, int) avec l'Article etant l'objet, int etant la quantite
    -Rafraichir l'interface apres avoir ajoute un article
    -La boucle pour obtenir les donnees de chaque article de la commande:
        for(Map.Entry<Article, Integer> article: commande.getArticles.entrySet()){
            nom article:article.getKey().getNom()
            prix article:article.getKey().getPrix()
            qte article:article.getValue()
        }
    -le total peut etre obtenu avec commande.calculerTotal()
     */
}
