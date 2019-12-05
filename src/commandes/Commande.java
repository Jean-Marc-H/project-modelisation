package commandes;

import articles.Article;
import salle.Table;

import java.util.HashMap;
import java.util.Map;

public class Commande {
    private HashMap<Article, Integer> articles;
    private Table table;

    public Commande(Table table){
        this.articles=new HashMap<Article, Integer>();
        this.table=table;
    }

    public Table getTable(){
        return this.table;
    }
    
    public HashMap<Article, Integer> getListeArticles(){
    	return this.articles;
    }

    public void ajouterArticle(Article article, int quantite){
        if(this.articles.containsKey(article)){
            this.articles.replace(article, this.articles.get(article)+quantite);
        }
        else{
            this.articles.put(article, quantite);
        }
    }
    
    

    public void retirerArticle(Article article) {
        this.articles.remove(article);
    }

    public double calculerTotal(){
        double total=0;
        for(Map.Entry<Article, Integer> article: this.articles.entrySet()){
            total+=article.getKey().getPrix()*article.getValue();
        }
        return total;
    }

}
