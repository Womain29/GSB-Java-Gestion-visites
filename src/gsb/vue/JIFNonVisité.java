package gsb.vue;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteDao;
import gsb.service.MedicamentService;

public class JIFNonVisité extends JInternalFrame implements ActionListener{
	private static final long serialVersionUID = 1L;

	private ArrayList<Visite> lesVisites;
	private ArrayList<Visite> lesVisites12Mois;

	//Dï¿½claration des JPanel
	protected JPanel p;
	
	protected JScrollPane scrollPane;
	protected JScrollPane scrollPane12Mois;
	
	//Dï¿½claration des JTextField
	protected JTextField JTDepotLegal;
	
	//Dï¿½claration des JLabel
	protected JLabel JLErreurRecherche;
	protected JLabel JL6mois; 
	protected JLabel JL12mois; 
	
	//Dï¿½claration des JButton
	protected JButton JBafficherFiche;
	
	//Dï¿½claration du Menu principal
	protected MenuPrincipal fenetreContainer;

	public JIFNonVisité(MenuPrincipal uneFenetreContainer) {

		fenetreContainer = uneFenetreContainer;
		// r?cup?ration des donn?es Medecin dans la collection
		lesVisites = VisiteDao.NonVisiteSixMois();
		lesVisites12Mois = VisiteDao.NonVisiteDouzeMois();
		
		int nbLignes = lesVisites.size();
		int nbLignes12Mois = lesVisites12Mois.size();
		
		JTable table;
		JTable table12Mois;
		
		JL6mois = new JLabel("Médecins non visités depuis plus de 6 mois");
		JL12mois = new JLabel("Médecins non visités depuis plus de 12 mois");
		
		//Instanciation des JPanel
		p = new JPanel(); // panneau principal de la fen?tre
		
		
		int i=0;
		String[][] data = new String[nbLignes][4] ;
		for(Visite uneVisite : lesVisites){
			data[i][0] = uneVisite.getUnMedecin().getCodeMed();
			data[i][1] = uneVisite.getUnMedecin().getNom();
			data[i][2] = uneVisite.getUnMedecin().getPrenom();
			data[i][3] = uneVisite.getDateVisite();
			i++;
			}
		String[] columnNames = {"Matricule", "Nom","Prénom", "Date visite"};
		table = new JTable(data, columnNames);
		table.setForeground(new Color(235, 198, 52));

		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(800, 200));
		
		int j=0;
		String[][] data12Mois = new String[nbLignes12Mois][4] ;
		for(Visite uneVisite12Mois : lesVisites12Mois){
			data12Mois[j][0] = uneVisite12Mois.getUnMedecin().getCodeMed();
			data12Mois[j][1] = uneVisite12Mois.getUnMedecin().getNom();
			data12Mois[j][2] = uneVisite12Mois.getUnMedecin().getPrenom();
			data12Mois[j][3] = uneVisite12Mois.getDateVisite();
			j++;
			}
		String[] columnNames12Mois = {"Matricule", "Nom","Prénom", "Date visite"};
		table12Mois = new JTable(data12Mois, columnNames12Mois);
		table12Mois.setForeground(new Color(255,0,0));

		scrollPane12Mois = new JScrollPane(table12Mois);
		scrollPane12Mois.setPreferredSize(new Dimension(800, 300));

		//Ajout des ï¿½lï¿½ments au panneau principal
		p.add(JL6mois);
		p.add(scrollPane);
		p.add(JL12mois);
		p.add(scrollPane12Mois);

      //Ajout du panneau principal ï¿½ la fenï¿½tre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		
	}
}
