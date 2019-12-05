package gsb.vue;


import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import gsb.service.MedicamentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author Gwendal
 *
 * 05/12/2019
 */

public class JIFMedicamentListeCol extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	private ArrayList<Medicament> lesMedicaments;

	//Déclaration des JPanel
	protected JPanel p;
	protected JPanel pSaisie;
	protected JPanel pErreur;
	
	protected JScrollPane scrollPane;
	
	//Déclaration des JTextField
	protected JTextField JTDepotLegal;
	
	//Déclaration des JLabel
	protected JLabel JLErreurRecherche;
	
	//Déclaration des JButton
	protected JButton JBafficherFiche;
	
	//Déclaration du Menu principal
	protected MenuPrincipal fenetreContainer;

	public JIFMedicamentListeCol(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// r?cup?ration des donn?es Medecin dans la collection
		lesMedicaments = MedicamentDao.rechercherTousLesMed();

		int nbLignes = lesMedicaments.size();

		JTable table;

		//Instanciation des JPanel
		p = new JPanel(); // panneau principal de la fen?tre
		pSaisie = new JPanel();
		pErreur = new JPanel();
		
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

		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));	

		//Instanciation des JTextField
		JTDepotLegal = new JTextField(20);
		JTDepotLegal.setMaximumSize(JTDepotLegal.getPreferredSize());
		
		//Instanciation des JButton
		JBafficherFiche = new JButton("Afficher Fiche mdicament");
		JBafficherFiche.addActionListener(this);
		
		//Instanciation des JLabel
		JLErreurRecherche = new JLabel("");
        JLErreurRecherche.setForeground(new Color(255,0,0));
		
        //Ajout des éléments au panneau saisie
		pSaisie.add(JTDepotLegal);
		pSaisie.add(JBafficherFiche);
		
		//Ajout des éléments dans le panneau erreur
        pErreur.add(JLErreurRecherche);
		
		//Ajout des éléments au panneau principal
		p.add(scrollPane);
		p.add(pSaisie);
        p.add(pErreur);
      //Ajout du panneau principal à la fenêtre
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
   			String depotLegal = JTDepotLegal.getText().toString();
   			try {
                //Les champs ne peuvent pas être null
                if (depotLegal.equals("")) {
                    throw new Exception("Tous les champs sont obligatoires");
                }
                //Une visite correspondante à la référence doit exister
                if (MedicamentDao.rechercher(depotLegal) == null) {
                    throw new Exception("Le medicament correspondant à ce depot legal n'existe pas");
                }
            }
            catch (Exception erreur) {
                System.out.println(erreur.getMessage());
                JLErreurRecherche.setText(erreur.getMessage());
            }
   			
   			Medicament unMedicament = MedicamentService.rechercherMedicament(JTDepotLegal.getText());
   			if (unMedicament!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
   			}
   		}	
	}

}