package interfaces;

import commandes.Commande;
import executable.Programme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCommande {
    private Commande commande;

    public JFrame frmCommande;
	private JTextField show_itemlist_selected_item;
	private JTextField total;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;

	/**
	 * Lance l'application.
	 */
	public void PopupScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceCommande window = new InterfaceCommande();
					window.frmCommande.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cr�e l'application.
	 */
	public InterfaceCommande() {
		initialize();
	}

	/**
	 * Initialise les contenus de la fen�tre.
	 */
	private void initialize() {
		frmCommande = new JFrame();
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
		
		
		//Menu d�roulant permettant de choisir les items d�sir�s
		JLabel lblNewLabel = new JLabel("S\u00E9lectionnez le(s) choix du client:");
		lblNewLabel.setBounds(10, 11, 181, 14);
		frmCommande.getContentPane().add(lblNewLabel);
		
		JComboBox itemList = new JComboBox(item);
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
		model.addColumn("Quantit�");
		
		//Ajouter un item: Ajoute l'item choisi dans la liste d'items
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(21, 67, 89, 23);
		frmCommande.getContentPane().add(btnAjouter);
		
		
		
		//Retirer un item: Enl�ve l'item choisi de la commande
		JButton btnRetirer = new JButton("Retirer");
		btnRetirer.setBounds(144, 67, 89, 23);
		frmCommande.getContentPane().add(btnRetirer);
		
		
		//Total: Affiche le prix total de la commande
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(201, 245, 32, 14);
		frmCommande.getContentPane().add(lblTotal);
		
		total = new JTextField();
		total.setEditable(false);
		total.setBounds(137, 263, 96, 20);
		total.setText("0.00");
		frmCommande.getContentPane().add(total);
		total.setColumns(10);
		
		//Confirmer la commande: Message de confirmation demandant si la commande peut �tre envoy�e � la cuisine
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBackground(new Color(0, 255, 127));
		btnConfirmer.setBounds(21, 328, 96, 23);
		frmCommande.getContentPane().add(btnConfirmer);
		
		
		//Annuler la commande: Enl�ve tous les items de la liste
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBackground(new Color(255, 99, 71));
		btnAnnuler.setBounds(144, 328, 89, 23);
		frmCommande.getContentPane().add(btnAnnuler);
		
		
		
		//Action Event
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
				  reponse = JOptionPane.showConfirmDialog(null, "�tes-vous sur de vouloir envoyer la commande?", "Attention", reponse);
				  if(reponse == JOptionPane.YES_OPTION) {
					  JOptionPane.showMessageDialog (null, "Commande envoy�e", "Information", JOptionPane.INFORMATION_MESSAGE);
					  frmCommande.setVisible(false);
					  //Changer la couleur de la table d�pendamment de laquelle a �t� cliqu�e
					  //D�terminer ce qui doit �tre fait
				  }
			}
		});
		
		//Annuler
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				total.setText("0.00");
				frmCommande.dispose();
			}
		});
	}
}
