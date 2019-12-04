package executable;

import articles.MenuArticles;
import commandes.GestionCommandes;
import salle.Salle;

public class Programme {
    public static MenuArticles menuArticles;
    public static GestionCommandes gestionCommandes;
    public static Salle salle;

    public static void main(String[] args){
        menuArticles.getMenuFile();
        for(int i=0;i<8;i++){
            salle.ajouterTable(i);
        }
        //load interface salle
    }
}
