package commandes;

import articles.Article;

import java.util.ArrayList;

public class Commande {
    ArrayList<Article> articles=new ArrayList<Article>();

    public void ajouterArticle(Article article){
        this.articles.add(article);
    }

    public void retirerArticle(Article article){
        this.articles.remove(article);
    }
}
