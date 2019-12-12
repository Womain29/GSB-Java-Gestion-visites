package gsb.vue;

import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.StockService;
import gsb.utils.ValidationUtils;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Gwendal
 *
 * Fen�tre d'ajout d'un m�dicament
 *
 * 05/12/2019
 */

public class JIFStockAjout extends JIFStock implements ActionListener, MouseListener {

	//D�claration des JPanels
	protected JPanel p;
	protected JPanel pSaisie;
	protected JPanel pErreur;
	
	//D�claration des JLabels
	protected JLabel JLMatricule;
	protected JLabel JLDepotLegal;
	protected JLabel JLQteStock;
	protected JLabel JLErreurAjout;
	
	//D�claration des JTextFields
	protected JTextField JTDepotLegal;
	protected JTextField JTMatricule;
	protected JTextField JTQteStock;
	
	//D�claration des JButtons
    private JButton JBValider;
    private JButton JBAnnuler;    
    
    private StockService unStockService = new StockService();

    public JIFStockAjout() {
        super();
        
        //Instanciation des JPanel
        p = new JPanel();
        pSaisie = new JPanel(new GridLayout(4, 2, 5, 5));
        pErreur = new JPanel();
        pErreur.setPreferredSize(new Dimension(1000, 20));
        pBoutons = new JPanel(new GridLayout(1,2,5,5));
        
        //Instanciation des JTextField
        JTDepotLegal = new JTextField(20);
		JTDepotLegal.setMaximumSize(JTDepotLegal.getPreferredSize());
		JTMatricule = new JTextField(20);
		JTMatricule.setMaximumSize(JTMatricule.getPreferredSize());
		JTQteStock = new JTextField(20);
		JTQteStock.setMaximumSize(JTMatricule.getPreferredSize());
        
		//Instanciation des JLabels
        JLMatricule = new JLabel("Matricule");
        JLDepotLegal = new JLabel("D�pot L�gal");
        JLQteStock = new JLabel("Quantit�");
        JLErreurAjout = new JLabel("");
        JLErreurAjout.setForeground(new Color(255,0,0));
		
        //Instanciation des JButtons
        JBValider = new JButton("Valider");
        JBValider.addActionListener(this);
        JBAnnuler = new JButton("Annuler");
        JBAnnuler.addActionListener(this);
        JBAnnuler.addMouseListener(this);
        
      //Ajout �couteur de la souris sur les JTexfields
        JTMatricule.addMouseListener(this);
        JTDepotLegal.addMouseListener(this);
        JTQteStock.addMouseListener(this);
        
        
        //Ajout des �l�ments sur le panneau saisie
        pSaisie.add(JLMatricule);
        pSaisie.add(JTMatricule);
        pSaisie.add(JLDepotLegal);
        pSaisie.add(JTDepotLegal);
        pSaisie.add(JLQteStock);
        pSaisie.add(JTQteStock);
        
        //Ajout de �l�ments sur le panneau boutons
        pBoutons.add(JBValider);
        pBoutons.add(JBAnnuler);
        
      //Ajout des �l�ments dans le panneau erreur
        pErreur.add(JLErreurAjout);
        
        //Ajout des �l�ments sur le panneau principal
        p.add(pSaisie);
        p.add(pErreur);
        p.add(pBoutons);

      //Ajout du panneau principal � la fen�tre
     	Container contentPane = getContentPane();
     	contentPane.add(p);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Ajout d'un stock");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == JBValider) {
        	String qte = JTQteStock.getText();   	
        	String depotLegal = JTDepotLegal.getText();
        	String matricule = JTMatricule.getText();
        	int quantite = 0;
        	
        	
        	try {
                //Les champs ne peuvent pas �tre null
                if (matricule.equals("") || depotLegal.equals("") || qte.equals("")) {
                    throw new Exception("Tous les champs sont obligatoires");
                }
                //Un medicament correspondant au d�pot l�gal doit exister
                if (MedicamentDao.rechercher(depotLegal) == null) {
                    throw new Exception("Le medicament correspondant � ce d�pot l�gal n'existe pas");
                }
              //Un visiteur correspondant au matricule doit exister
                if (VisiteurDao.rechercher(matricule) == null) {
                    throw new Exception("Le visiteur correspondant � ce matricule n'existe pas");
                }
              //Un visiteur correspondant au matricule doit exister
                
                if (!ValidationUtils.estUnEntier(qte)) {
                	throw new Exception("La quantit� ajout�e doit �tre un entier");
                }
                else {
                	quantite = Integer.parseInt(qte);
                }
                if (quantite <= 0) {
                    throw new Exception("On ne peut pas ajouter un stock inf�rieur ou �gal � 0");
                }
                
                unStockService.ajoutStock(JTDepotLegal.getText().toString(),JTMatricule.getText().toString(), quantite);
                this.videTexte();
                JLErreurAjout.setText("");
            }
            catch (Exception erreur) {
                System.out.println(erreur.getMessage());
                JLErreurAjout.setText(erreur.getMessage());
            }        
        	
        }
        if(source == JBAnnuler) {
            this.videTexte();
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Object mouse = e.getSource();
        //R�initialise le label d'erreur au clic dans un des JTextfield
        if(mouse == JTMatricule || mouse == JTDepotLegal || mouse == JTQteStock) {
            JLErreurAjout.setText("");
        }
        if(mouse == JBAnnuler) {
        	JTMatricule.setText("");
        	JTQteStock.setText("");
        	JTDepotLegal.setText("");
        	JLErreurAjout.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
