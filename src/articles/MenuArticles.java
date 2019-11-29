package articles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class MenuArticles {
    private ArrayList<Article> catalogue=new ArrayList<Article>();

    public void ajouterArticle(Article article){
        this.catalogue.add(article);
    }

    public ArrayList<Article> getCatalogue(){
        return this.catalogue;
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
    
    
    public void GetMenuFile() {
		try {
			
			String file = System.getProperty("user.dir") + "\\Fichier\\Menu.csv";
			String[] content = new String[2];
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			
			//Skip first line
			br.readLine();
			
			while ((line = br.readLine()) != null) {
				content = line.split(",");
				String nom = content[0];
				Double prix = Double.parseDouble(content[1]);
				catalogue.add(new Article(nom, prix));
			}
			
		} catch (Exception e) {
			// File not found
		}

    }
}
