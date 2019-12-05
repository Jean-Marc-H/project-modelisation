package executable;

import articles.MenuArticles;
import commandes.GestionCommandes;
import interfaces.InterfaceSalle;
import salle.Salle;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Programme {
    public static MenuArticles menuArticles=new MenuArticles();
    public static GestionCommandes gestionCommandes=new GestionCommandes();
    public static Salle salle=new Salle();
    public static String fichierMenu="Fichier\\menu.csv";
    public static String folderArchive="Fichier\\Archive";

    public static void main(String[] args){
    	File menu=new File(fichierMenu);
    	if(!new File(fichierMenu).exists()){
    		System.out.println("in");
    		if(!menu.getParentFile().exists()){
    			menu.getParentFile().mkdir();
			}
			try {
				menu.createNewFile();
				PrintWriter writer=new PrintWriter(menu);
				writer.write("Nom,Prix ($)\nAiles,11.75\nClub Sandwich,9.95\nPoutine,9.15\nFilet,10.85\nPoitrines,12.35\nSalade,11.05\n Eau,1.3\nLiqueur,2.55\n Entrées,10.25\nTarte,3.35\nJus,1.8\n");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	File archives=new File(folderArchive);
    	if(!archives.exists()){
    		archives.mkdir();
		}
		menuArticles.getMenuFile();
		for (int i = 0; i < 8; i++) {
			salle.ajouterTable(i + 1);
		}
		try {
			InterfaceSalle window=new InterfaceSalle();
			window.frmGestionDuRestaurant.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
