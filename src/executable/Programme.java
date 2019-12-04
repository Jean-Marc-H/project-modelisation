package executable;

import articles.MenuArticles;
import commandes.GestionCommandes;
import interfaces.InterfaceSalle;
import salle.Salle;

import javax.swing.*;
import java.awt.*;

public class Programme {
    public static MenuArticles menuArticles=new MenuArticles();
    public static GestionCommandes gestionCommandes=new GestionCommandes();
    public static Salle salle=new Salle();

    public static void main(String[] args){
        menuArticles.getMenuFile();
        for(int i=0;i<8;i++){
            salle.ajouterTable(i+1);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceSalle window = new InterfaceSalle();
                    window.frmGestionDuRestaurant.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
