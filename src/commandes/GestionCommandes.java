package commandes;

import paiement.Paiement;
import salle.Table;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import articles.Article;

public class GestionCommandes {
    private ArrayList<Commande> commandesActives=new ArrayList<Commande>();
    private ArrayList<Paiement> commandesCompletees=new ArrayList<Paiement>();

    public void creerCommande(Table table){
        Commande nouvelleCommande=new Commande(table);
        table.setCommande(nouvelleCommande);
        this.commandesActives.add(nouvelleCommande);
    }

    public void completerCommande(Paiement paiement){
        archiverCommande(paiement);
        this.commandesActives.remove(paiement.getCommande());
        this.commandesCompletees.add(paiement);
    }

    public void annulerCommande(Commande commande){
        this.commandesActives.remove(commande);
        //CHANGER ETAT
    }
    
    public Commande getLastCommandeActive(){
        return commandesActives.get(commandesActives.size()-1);
    }
    
    public Commande getTableCommandeActive(Table table){
        for(Commande commande : commandesActives) {
        	if(commande.getTable() == table)
        		return commande;
        }
        return null;
    }
    

    public void archiverCommande (Paiement paiement) {
		Commande commande = paiement.getCommande();
		String file = System.getProperty("user.dir") + "\\Fichier\\Archive\\Commande_"
				+ new SimpleDateFormat("yyyy-MM-dd__HH-mm-ss").format(Calendar.getInstance().getTime()) + ".csv";
		try (PrintWriter writer = new PrintWriter(new File(file))) {

			StringBuilder sb = new StringBuilder();
			sb.append("Methode de Paiement:," + paiement.getMethodePaiement() + ",\n\n\n");

			sb.append("Liste d'article commande,\n");
			sb.append("Nom,Quantite,Total,\n");
			for (Article article : commande.getListeArticles().keySet()) {
				double total = commande.getListeArticles().get(article) * article.getPrix();
				sb.append(article.getNom() + "," + commande.getListeArticles().get(article) + "," + total + ",\n");
			}
			sb.append(",," + commande.calculerTotal() + "$,\n");

			writer.write(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

    
}
