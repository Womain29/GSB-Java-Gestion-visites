package gsb.vue;


import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.service.MedicamentService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Gwendal
 *
 * Fenêtre de consultation des information d'un médicament
 *
 * 05/12/2019
 */

public class JIFMedicamentListeCol extends JInternalFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Medicament> lesMedicaments;

	
	//Déclaration des JPanel	
	protected JPanel p;
	protected JPanel pSaisie;
	
	//Déclaration des composants du tableau
	protected JScrollPane scrollPane;
	
	//Déclaration des JTextField
	protected JTextField JTdepotLegal;
	
	//Déclaration des boutons 
	protected JButton JBafficherFiche;
	
	
	protected MenuPrincipal fenetreContainer;

	public JIFMedicamentListeCol(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// r?cup?ration des donn?es Medecin dans la collection
		lesMedicaments = MedicamentDao.rechercherTousLesMed();

		int nbLignes = lesMedicaments.size();

		JTable table;
		
		int i=0;
		String[][] data = new String[nbLignes][3] ;
		for(Medicament unMedicament : lesMedicaments){
			data[i][0] = unMedicament.getDepotLegal();
			data[i][1] = unMedicament.getNomCommercial();
			data[i][2] = unMedicament.getUneFamille().getCodeFamille() ;
			i++;
			}
		String[] columnNames = {"Depot Legal", "Nom Commercial","Code Famille"};
		table = new JTable(data, columnNames);
		
		
		//Variables pour le tableau
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		
		//Instanciation des panneaux 
		p = new JPanel(); // panneau principal de la fen?tre
		pSaisie = new JPanel();
		
		//Ajout des éléments sur le tableau
		p.add(scrollPane);
		pSaisie.add(JTdepotLegal);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		//Instanciation des JTextField
		JTdepotLegal = new JTextField(20);
		JTdepotLegal.setMaximumSize(JTdepotLegal.getPreferredSize());
		
		//Instanciation des boutons
		JBafficherFiche = new JButton("Afficher Fiche mdicament");
		JBafficherFiche.addActionListener(this);
		
		
		// mise en forme de la fen?tre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			Medicament unMedicament = MedicamentService.rechercherMedicament(JTdepotLegal.getText());
   			if (unMedicament!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
   			}
   		}	
	}
    
}