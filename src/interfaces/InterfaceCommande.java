package interfaces;

import commandes.Commande;
import executable.Programme;
import salle.Table;
import salle.Table.EtatTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import articles.Article;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InterfaceCommande {
    private Commande commande;
    private int tableNumber;
    public closeResult etat;

    public JFrame frmCommande;
	private JTextField show_itemlist_selected_item;
	private JTextField total;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JButton btnAjouter;
	private JButton btnRetirer;
	private JButton btnArchiver;
	private JButton btnFermer;
	private JLabel lblNewLabel;
	private JLabel lblTotal;
	private JButton btnConfirmer;
	private JButton btnAnnuler;
	private JComboBox<String> itemList;
	private JComboBox<String> modePaiement;


	/**
	 * Cr�e l'application.
	 */
	public InterfaceCommande(int number) {
		tableNumber = number;
		initialize();
	}

	/**
	 * Initialise les contenus de la fenetre.
	 */
	private void initialize() {
		frmCommande = new JFrame();
		frmCommande.setResizable(false);
		frmCommande.setTitle("Commande");
		frmCommande.setSize(270, 418);
		frmCommande.setLocation(350, 100);
		frmCommande.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCommande.getContentPane().setLayout(null);
		
		//Les choix possibles
		String[] item = new String[Programme.menuArticles.getCatalogue().size()];
		for(int i = 0; i< Programme.menuArticles.getCatalogue().size(); i++ ) {
			
			item[i] = Programme.menuArticles.getCatalogue().get(i).getNom();
		}
		
		
		//Menu deroulant permettant de choisir les items desir�es
		lblNewLabel = new JLabel("S\u00E9lectionnez le(s) choix du client:");
		lblNewLabel.setBounds(10, 11, 181, 14);
		frmCommande.getContentPane().add(lblNewLabel);
		
		itemList = new JComboBox<String>(item);
		itemList.setBounds(36, 34, 181, 22);
		itemList.setMaximumRowCount(6);
		frmCommande.getContentPane().add(itemList);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 101, 212, 121);
		frmCommande.getContentPane().add(scrollPane);
		
		model = new DefaultTableModel(); 
		table = new JTable(model); 
		table.setBounds(21, 101, 212, 121);
		frmCommande.getContentPane().add(table);
		scrollPane.setViewportView(table);

		// Create a couple of columns 
		model.addColumn("Nom"); 
		model.addColumn("Prix"); 
		model.addColumn("Quantite");
		
		//Ajouter un item: Ajoute l'item choisi dans la liste d'items
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(21, 67, 89, 23);
		frmCommande.getContentPane().add(btnAjouter);
		
		
		
		//Retirer un item: Enleve l'item choisi de la commande
		btnRetirer = new JButton("Retirer");
		btnRetirer.setBounds(144, 67, 89, 23);
		frmCommande.getContentPane().add(btnRetirer);
		
		
		//Total: Affiche le prix total de la commande
		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(201, 245, 32, 14);
		frmCommande.getContentPane().add(lblTotal);
		
		total = new JTextField();
		total.setEditable(false);
		total.setBounds(137, 263, 96, 20);
		total.setText("0.00");
		frmCommande.getContentPane().add(total);
		total.setColumns(10);
		
		
		//Mode de paiement
		modePaiement = new JComboBox<String>(new String[] {"Comptant", "Carte"});
		modePaiement.setBounds(21, 263, 96, 23);
		modePaiement.setMaximumRowCount(6);
		frmCommande.getContentPane().add(modePaiement);
		
		//Confirmer la commande: Message de confirmation demandant si la commande peut etre envoyee a la cuisine
		btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBackground(new Color(0, 255, 127));
		btnConfirmer.setBounds(21, 328, 96, 23);
		frmCommande.getContentPane().add(btnConfirmer);
		
		
		//Annuler la commande: Enleve tous les items de la liste
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 99, 71));
		btnAnnuler.setBounds(144, 300, 89, 23);
		frmCommande.getContentPane().add(btnAnnuler);
		
		// Archivage
		btnArchiver = new JButton("Archiver");
		btnArchiver.setBounds(21, 300, 96, 23);
		btnArchiver.setEnabled(false);
		frmCommande.getContentPane().add(btnArchiver);
		
		// Fermer
		btnFermer = new JButton("Fermer");
		btnFermer.setBounds(144, 328, 89, 23);
		frmCommande.getContentPane().add(btnFermer);

		// Action Event
		//Ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String choix = (String) itemList.getSelectedItem();
				boolean valueFound = false;
				for(int i = 0 ; i< table.getRowCount(); i++){
					if(table.getModel().getValueAt(i, 0) == choix) {
						valueFound = true;
						int value = (int)table.getModel().getValueAt(i, 2) + 1;
						table.getModel().setValueAt(value, i, 2);
						total.setText(String.valueOf(Double.parseDouble(total.getText()) + (double)table.getModel().getValueAt(i, 1)));
						
					}
				}
				if(!valueFound) {
					double prix = Programme.menuArticles.getArticle(choix).getPrix();
					model.addRow(new Object[] {choix, prix, 1});  //Ajouter prix
					total.setText(String.valueOf(Double.parseDouble(total.getText()) + prix));
				}
				
			}
		});
		
		//Retirer
		btnRetirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					int index = table.getSelectedRow();
					int value = (int)table.getModel().getValueAt(index, 2) - 1;
					total.setText(String.valueOf(Double.parseDouble(total.getText()) - (double)table.getModel().getValueAt(index, 1)));
					if(value < 1)
						((DefaultTableModel)table.getModel()).removeRow(index);
					else
						table.getModel().setValueAt(value, index, 2);
				}
				//Eviter le probleme ou la ligne n'est pas selectionner ou il n'y a pas de ligne
				catch(Exception a) {}
				
				
			}
		});
		
		//Confirmer
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				int reponse = JOptionPane.YES_NO_OPTION;
				reponse = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir envoyer la commande?",
						"Attention", reponse);
				if (reponse == JOptionPane.YES_OPTION) {
					ArrayList<Article> listeArticleTrouver = new ArrayList<Article>();
					for (int i = 0; i < table.getRowCount(); i++) {
						boolean valueFound = false;

						for (Article article : commande.getListeArticles().keySet()) {
							if (table.getModel().getValueAt(i, 0) == article.getNom()) {
								listeArticleTrouver.add(article);
								valueFound = true;
								int difference = Integer.parseInt(table.getModel().getValueAt(i, 1).toString())
										- commande.getListeArticles().get(article);
								if (difference != 0) {
									commande.ajouterArticle(article, difference);
								}
							}

						}
						if (!valueFound) {
							commande.ajouterArticle(
									Programme.menuArticles.getArticle(table.getModel().getValueAt(i, 0).toString()), 1);
						}

					}
					// Retire les article qui ne sont plus la
					HashMap<Article, Integer> temp  = new HashMap<Article, Integer>(commande.getListeArticles());
					for (Article article : temp.keySet()) {
						if(!listeArticleTrouver.contains(article)) {
							commande.getListeArticles().remove(article);
						}
					}

					JOptionPane.showMessageDialog(null, "Commande envoyee", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					etat = InterfaceCommande.closeResult.OK;
					frmCommande.dispose();
				}
			}
		});
		
		//Annuler
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				total.setText("0.00");
				etat = InterfaceCommande.closeResult.ANNULER;
				frmCommande.dispose();
			}
		});
		
		btnArchiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				model.setRowCount(0);
				total.setText("0.00");
				etat = InterfaceCommande.closeResult.ARCHIVER;
				frmCommande.dispose();
			}
		});
		
		
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				etat = InterfaceCommande.closeResult.FERMER;
				frmCommande.dispose();
			}
		});
		
	}

	public void setUp() {
		if(Programme.salle.getTables().get(tableNumber).getEtat() == Table.EtatTable.SERVI) {
			btnArchiver.setEnabled(true);
			btnAnnuler.setEnabled(false);
		}
		else if(Programme.salle.getTables().get(tableNumber).getEtat()== EtatTable.EN_ATTENTE){
			btnArchiver.setEnabled(false);
			btnAnnuler.setEnabled(false);
		}
		else {
			btnArchiver.setEnabled(false);
			btnAnnuler.setEnabled(true);
		}
	}
	
	public void setCommande(Commande _commande) {
		commande = _commande;
	}
	
	
	public enum closeResult{
        OK,
        ANNULER,
        ARCHIVER,
        FERMER
    }
}
