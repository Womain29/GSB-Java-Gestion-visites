package gsb.vue;


import gsb.modele.Medicament;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicament extends JInternalFrame {
	
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	 protected JLabel JLDepotLegal;
	 protected JLabel JLNomCommercial;
	 protected JLabel JLComposition;
	 protected JLabel JLEffets;
	 protected JLabel JLContreIndication;
	 protected JLabel JLCodeFamille;
	 protected JLabel JLLibelleFamille;

	 protected JTextField JTDepotLegal;
	 protected JTextField JTNomCommercial;
	 protected JTextField JTComposition;
	 protected JTextField JTEffets;
	 protected JTextField JTContreIndication;
	 protected JTextField JTCodeFamille;
	 protected JTextField JTLibelleFamille;
	
	 public JIFMedicament() {
	        p = new JPanel();
	        pTexte = new JPanel(new GridLayout(7,2));
	        pBoutons = new JPanel();

	        JLDepotLegal = new JLabel("Depot Legal");
	        JLNomCommercial = new JLabel("Nom Commercial");
	        JLComposition = new JLabel("Composition");
	        JLEffets = new JLabel("Effets");
	        JLContreIndication = new JLabel("Contre Indications");
	        JLCodeFamille = new JLabel("Code Famille");
	        JLLibelleFamille = new JLabel("Libelle Famille");

	        JTDepotLegal = new JTextField(30);
	        JTNomCommercial = new JTextField(30);
	        JTComposition = new JTextField(30);
	        JTEffets = new JTextField(30);
	        JTContreIndication = new JTextField(30);
	        JTCodeFamille = new JTextField(30);
	        JTLibelleFamille = new JTextField(30);

	        pTexte.add(JLDepotLegal);
	        pTexte.add(JTDepotLegal);
	        pTexte.add(JLNomCommercial);
	        pTexte.add(JTNomCommercial);
	        pTexte.add(JLComposition);
	        pTexte.add(JTComposition);
	        pTexte.add(JLEffets);
	        pTexte.add(JTEffets);
	        pTexte.add(JLContreIndication);
	        pTexte.add(JTContreIndication);
	        pTexte.add(JLCodeFamille);
	        pTexte.add(JTCodeFamille);
	        pTexte.add(JLLibelleFamille);
	        pTexte.add(JTLibelleFamille);
	        
	        p.add(pTexte);
	        p.add(pBoutons);

	        Container contentPane = getContentPane();
	        contentPane.add(p);
	    }
	 
	 public void remplirText(Medicament unMedicament) {
	        JTDepotLegal.setText(unMedicament.getDepotLegal());
	        JTNomCommercial.setText(unMedicament.getNomCommercial());
	        JTComposition.setText(unMedicament.getComposition());
	        JTEffets.setText(unMedicament.getEffets());
	        JTContreIndication.setText(unMedicament.getContreIndication());
	        JTCodeFamille.setText(unMedicament.getUneFamille().getCodeFamille());
	        JTLibelleFamille.setText(unMedicament.getUneFamille().getLibelleFamille());
	    }
	 
	 public void videTexte() {
	        JTDepotLegal.setText("");
	        JTNomCommercial.setText("");
	        JTComposition.setText("");
	        JTEffets.setText("");
	        JTContreIndication.setText("");
	        JTCodeFamille.setText("");
	        JTLibelleFamille.setText("");
	    }

}
