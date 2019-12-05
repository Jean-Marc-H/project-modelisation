package interfaces;

import executable.Programme;
import salle.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static salle.Table.EtatTable.VIDE;

public class InterfaceSalle {
    
    public JFrame frmGestionDuRestaurant;
    private InterfaceCommande commande1 = new InterfaceCommande();
    private InterfaceCommande commande2 = new InterfaceCommande();
    private InterfaceCommande commande3 = new InterfaceCommande();
    private InterfaceCommande commande4 = new InterfaceCommande();
    private InterfaceCommande commande5 = new InterfaceCommande();
    private InterfaceCommande commande6 = new InterfaceCommande();
    private InterfaceCommande commande7 = new InterfaceCommande();
    private InterfaceCommande commande8 = new InterfaceCommande();
    
    
    public InterfaceSalle() {
        initialize();
    }

    private void initialize() {
        frmGestionDuRestaurant = new JFrame();
        frmGestionDuRestaurant.setResizable(false);
        frmGestionDuRestaurant.setTitle("Gestion du restaurant");
        frmGestionDuRestaurant.setSize(671, 361);
        frmGestionDuRestaurant.setLocation(350, 100);

        JPanel salle = new JPanel();
        salle.setBackground(new Color(253, 245, 230));
        frmGestionDuRestaurant.getContentPane().add(salle, BorderLayout.CENTER);
        salle.setLayout(null);
/*
        ArrayList<JButton> boutons=new ArrayList<JButton>();
        for(int i=0;i<Programme.salle.getTables().size();i++) {
            Table table = Programme.salle.getTables().get(i);
            boutons.add(new JButton(table.getNumero() + ""));
            boutons.get(i).setBounds((86 + (80 * (i % 4))), 91 + (95 * (i / 4)), 47, 42);
            setCouleurTable(boutons.get(i), table);
            salle.add(boutons.get(i));
            boutons.get(i).addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e1) {
                    InterfaceCommande commande = new InterfaceCommande();
                    commande.PopupScreen();
                }
            });
        }
        */
        JButton table1 = new JButton("1");
		table1.setBounds(86, 91, 47, 42);
		Table table = Programme.salle.getTables().get(0);
		setCouleurTable(table1, table);
		salle.add(table1);
		table1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				setUpCommande(commande1, 0, table1);
			}
		});
		
		JButton table2 = new JButton("2");
		table2.setBounds(180, 91, 47, 42);
		table = Programme.salle.getTables().get(1);
		setCouleurTable(table2, table);
		salle.add(table2);
		table2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setUpCommande(commande2, 1, table2);
			}
		});
		
		JButton table3 = new JButton("3");
		table3.setBounds(277, 91, 47, 42);
		table = Programme.salle.getTables().get(2);
		setCouleurTable(table3, table);
		salle.add(table3);
		table3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setUpCommande(commande3, 2, table3);
			}
		});
		
		JButton table4 = new JButton("4");
		table4.setBounds(376, 91, 47, 42);
		table = Programme.salle.getTables().get(3);
		setCouleurTable(table4, table);
		salle.add(table4);
		table4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setUpCommande(commande4, 3, table4);
			}
		});
		
		JButton table5 = new JButton("5");
		table5.setBounds(86, 186, 47, 42);
		table = Programme.salle.getTables().get(4);
		setCouleurTable(table5, table);
		salle.add(table5);
		table5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setUpCommande(commande5, 4, table5);
			}
		});
		
		JButton table6 = new JButton("6");
		table6.setBounds(180, 186, 47, 42);
		table = Programme.salle.getTables().get(5);
		setCouleurTable(table6, table);
		salle.add(table6);
		table6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setUpCommande(commande6, 5, table6);
			}
		});
		
		JButton table7 = new JButton("7");
		table7.setBounds(277, 186, 47, 42);
		table = Programme.salle.getTables().get(6);
		setCouleurTable(table7, table);
		salle.add(table7);
		table7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setUpCommande(commande7, 6, table7);
			}
		});
		
		JButton table8 = new JButton("8");
		table8.setBounds(376, 186, 47, 42);
		table = Programme.salle.getTables().get(7);
		setCouleurTable(table8, table);
		salle.add(table8);
		table8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setUpCommande(commande8, 7, table8);
			}
		});
		

        JPanel legende = new JPanel();
        legende.setBackground(new Color(204, 255, 255));
        legende.setBounds(479, 0, 179, 323);
        salle.add(legende);
        legende.setLayout(null);

        Panel blanc = new Panel();
        blanc.setBackground(new Color(255, 255, 255));
        blanc.setBounds(32, 49, 22, 22);
        legende.add(blanc);

        JTextArea txtrVide = new JTextArea();
        txtrVide.setText("= Vide");
        txtrVide.setFont(new Font("Myanmar Text", Font.PLAIN, 14));
        txtrVide.setEditable(false);
        txtrVide.setBackground(new Color(204, 255, 255));
        txtrVide.setBounds(56, 49, 68, 22);
        legende.add(txtrVide);

        Panel vert = new Panel();
        vert.setBackground(new Color(51, 204, 0));
        vert.setBounds(32, 86, 22, 22);
        legende.add(vert);

        Panel jaune = new Panel();
        jaune.setBackground(new Color(255, 255, 51));
        jaune.setBounds(32, 124, 22, 22);
        legende.add(jaune);

        Panel orange = new Panel();
        orange.setBackground(new Color(255, 153, 0));
        orange.setBounds(32, 161, 22, 22);
        legende.add(orange);

        Panel rouge = new Panel();
        rouge.setBackground(new Color(255, 0, 0));
        rouge.setBounds(32, 200, 22, 22);
        legende.add(rouge);

        Panel noir = new Panel();
        noir.setBackground(new Color(0, 0, 0));
        noir.setBounds(32, 238, 22, 22);
        legende.add(noir);

        JTextArea txtrPrt = new JTextArea();
        txtrPrt.setText("= Pr\u00EAt");
        txtrPrt.setFont(new Font("Myanmar Text", Font.PLAIN, 14));
        txtrPrt.setEditable(false);
        txtrPrt.setBackground(new Color(204, 255, 255));
        txtrPrt.setBounds(56, 86, 68, 22);
        legende.add(txtrPrt);

        JTextArea txtrEnAttente = new JTextArea();
        txtrEnAttente.setText("= En attente");
        txtrEnAttente.setFont(new Font("Myanmar Text", Font.PLAIN, 14));
        txtrEnAttente.setEditable(false);
        txtrEnAttente.setBackground(new Color(204, 255, 255));
        txtrEnAttente.setBounds(56, 124, 89, 22);
        legende.add(txtrEnAttente);

        JTextArea txtrPrt_1 = new JTextArea();
        txtrPrt_1.setText("= Pr\u00EAt \u00E0 \u00EAtre servi");
        txtrPrt_1.setFont(new Font("Myanmar Text", Font.PLAIN, 14));
        txtrPrt_1.setEditable(false);
        txtrPrt_1.setBackground(new Color(204, 255, 255));
        txtrPrt_1.setBounds(56, 161, 123, 22);
        legende.add(txtrPrt_1);

        JTextArea txtrServi = new JTextArea();
        txtrServi.setText("= Servi");
        txtrServi.setFont(new Font("Myanmar Text", Font.PLAIN, 14));
        txtrServi.setEditable(false);
        txtrServi.setBackground(new Color(204, 255, 255));
        txtrServi.setBounds(56, 200, 68, 22);
        legende.add(txtrServi);

        JTextArea txtrSale = new JTextArea();
        txtrSale.setText("= Sale");
        txtrSale.setFont(new Font("Myanmar Text", Font.PLAIN, 14));
        txtrSale.setEditable(false);
        txtrSale.setBackground(new Color(204, 255, 255));
        txtrSale.setBounds(56, 238, 68, 22);
        legende.add(txtrSale);

        JTextArea txtrLgende = new JTextArea();
        txtrLgende.setText("L\u00C9GENDE");
        txtrLgende.setFont(new Font("Myanmar Text", Font.PLAIN, 14));
        txtrLgende.setEditable(false);
        txtrLgende.setBackground(new Color(204, 255, 255));
        txtrLgende.setBounds(10, 11, 68, 22);
        legende.add(txtrLgende);

        JTextArea txtrSalleManger = new JTextArea();
        txtrSalleManger.setText("SALLE \u00C0 MANGER");
        txtrSalleManger.setFont(new Font("Myanmar Text", Font.PLAIN, 14));
        txtrSalleManger.setEditable(false);
        txtrSalleManger.setBackground(new Color(253, 245, 230));
        txtrSalleManger.setBounds(10, 11, 116, 22);
        salle.add(txtrSalleManger);
    }

    public static void setCouleurTable(JButton button, Table table){
        if(table.getEtat()==VIDE){
            button.setBackground(new Color(255, 255, 255));
        }
        else if(table.getEtat()==Table.EtatTable.PRET){
            button.setBackground(new Color(51, 204, 0));
        }
        else if(table.getEtat()==Table.EtatTable.EN_ATTENTE){
            button.setBackground(new Color(255, 255, 51));
        }
        else if(table.getEtat()==Table.EtatTable.PRET_A_SERVIR){
            button.setBackground(new Color(255, 153, 0));
        }
        else if(table.getEtat()==Table.EtatTable.SERVI){
            button.setBackground(new Color(255, 0, 0));
        }
        else if(table.getEtat()==Table.EtatTable.SALE){
            button.setBackground(new Color(0, 0, 0));
        }

        
    }
    
    private void setUpCommande(InterfaceCommande commande, int tableNumber, JButton button) {
    	
    	if(Programme.salle.getTables().get(tableNumber).getEtat() == Table.EtatTable.EN_ATTENTE || Programme.salle.getTables().get(tableNumber).getEtat() == Table.EtatTable.PRET
    			|| Programme.salle.getTables().get(tableNumber).getEtat() == Table.EtatTable.SERVI) {
        	commande.frmCommande.setVisible(true);
    	}
    	
    	if(Programme.salle.getTables().get(tableNumber).getEtat() == Table.EtatTable.VIDE) {
    		
    		Programme.salle.getTables().get(tableNumber).setProchainEtat();
    		setCouleurTable(button, Programme.salle.getTables().get(tableNumber));
    	}
    	
    	else if(Programme.salle.getTables().get(tableNumber).getEtat() == Table.EtatTable.PRET) {
    		
    		Programme.gestionCommandes.creerCommande(Programme.salle.getTables().get(tableNumber));
    		commande.setCommande(Programme.gestionCommandes.getLastCommandeActive());
    	}
    	
    }
    
    public void tableAction(JButton button, Table table){

    }
}
