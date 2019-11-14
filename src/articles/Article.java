package articles;

public class Article {
    private String nom;
    private double prix;

    public Article(String nom, double prix){
        this.nom=nom;
        this.prix=prix;
    }

    public String getNom(){
        return this.nom;
    }

    public double getPrix(){
        return this.prix;
    }
}