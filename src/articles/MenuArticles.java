package articles;

import java.util.ArrayList;

public class MenuArticles {
    ArrayList<Article> catalogue=new ArrayList<Article>();

    public void ajouterArticle(Article article){
        this.catalogue.add(article);
    }

    public Article getArticle(Article article){
        for(Article articleListe: this.catalogue){
            if(article.equals(articleListe)){
                return articleListe;
            }
        }
        return null;
    }

    public Article getArticle(String nomArticle){
        for(Article article: this.catalogue){
            if(nomArticle.equals(article.getNom())){
                return article;
            }
        }
        return null;
    }
}
