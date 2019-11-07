package gsb.vue;

import gsb.modele.Stock;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JIFStock extends JInternalFrame {
	
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	 protected JLabel JLDepotLegal;
	 protected JLabel JLMatricule;
	 protected JLabel JLQteStock;

	 protected JTextField JTDepotLegal;
	 protected JTextField JTMatricule;
	 protected JTextField JTQteStock;

	
	 public JIFStock() {
	        p = new JPanel();
	        pTexte = new JPanel(new GridLayout(5,2,5,5));
	        pBoutons = new JPanel();
	        
	        JLDepotLegal = new JLabel("Depot Legal");
	        JLMatricule = new JLabel("Matricule");
	        JLQteStock = new JLabel("Quantité");
	        
	        JTDepotLegal = new JTextField(15);
	        JTMatricule = new JTextField(15);
	        JTQteStock = new JTextField(15);

	        pTexte.add(JLMatricule);
	        pTexte.add(JTMatricule);
	        pTexte.add(JLDepotLegal);
	        pTexte.add(JTDepotLegal);
	        pTexte.add(JLQteStock);
	        pTexte.add(JTQteStock);

	        p.add(pTexte);
	        p.add(pBoutons);

	        Container contentPane = getContentPane();
	        contentPane.add(p);
	    }
	 
	 public void videTexte() {
		 	JTDepotLegal.setText("");	
		 	JTMatricule.setText("");		 	        
	        JTQteStock.setText("");
	    }

}