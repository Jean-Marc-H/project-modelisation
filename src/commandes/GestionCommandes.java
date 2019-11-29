package commandes;

import paiement.Paiement;
import paiement.Paiement.MethodePaiement;
import salle.Table;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import articles.Article;

public class GestionCommandes {
    private ArrayList<Commande> commandesActives=new ArrayList<Commande>();
    private ArrayList<Paiement> commandesCompletees=new ArrayList<Paiement>();

    public void creerCommande(Table table){
        Commande nouvelleCommande=new Commande(table);
        table.utiliser();
        table.setCommande(nouvelleCommande);
        this.commandesActives.add(nouvelleCommande);
    }

    public void completerCommande(Paiement paiement){
        this.commandesActives.remove(paiement.getCommande());
        paiement.getCommande().getTable().liberer();
        this.commandesCompletees.add(paiement);
    }

    public void annulerCommande(Commande commande){
        this.commandesActives.remove(commande);
        commande.getTable().liberer();
    }
    
    public static void main(String[] args) {
    	Commande commande = new Commande(new Table(1));
    	for(int i = 0; i<10; i++) {
    		Random rand = new Random();
    	    int randomNum = rand.nextInt((5 - 1) + 1) + 1;
    	    int rand2 = rand.nextInt((20 - 1) + 1) + 1;
    		commande.ajouterArticle(new Article("asdasd", rand2), randomNum);
    	}
    	Paiement pa = new Paiement(commande);
    	pa.setMethodePaiement(MethodePaiement.COMPTANT);
    	archiverCommande(pa);
    }

    public static void archiverCommande (Paiement paiement) {
		Commande commande = paiement.getCommande();
		String file = System.getProperty("user.dir") + "\\Fichier\\Archive\\Commande_"
				+ new SimpleDateFormat("yyyy-MM-dd__HH-mm-ss").format(Calendar.getInstance().getTime()) + ".csv";
		try (PrintWriter writer = new PrintWriter(new File(file))) {

			StringBuilder sb = new StringBuilder();
			sb.append("Méthode de Paiement:," + paiement.getMethodePaiement() + ",\n\n\n");

			sb.append("Liste d'article commandé,\n");
			sb.append("Nom,Quantité,Total,\n");
			for (Article article : commande.getListeArticles().keySet()) {
				double total = commande.getListeArticles().get(article) * article.getPrix();
				sb.append(article.getNom() + "," + commande.getListeArticles().get(article) + "," + total + ",\n");
			}
			sb.append(",," + commande.calculerTotal() + "$,\n");

			writer.write(sb.toString());

		} catch (Exception e) {
			// Error saving the file
		}

	}
    
}
