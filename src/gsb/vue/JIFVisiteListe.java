package gsb.vue;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.VisiteService;
import gsb.utils.ValidationUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author womain
 * 02/11/2019
 *
 * Fenêtre interne de consultation des visites
 */
public class JIFVisiteListe extends JInternalFrame implements ActionListener, MouseListener {

    //Déclaration des JPanel
    protected JPanel p;
    protected JPanel pRecherche;
    protected JPanel pRecherche1;
    protected JPanel pRecherche2;
    protected JPanel pRecherche3;
    protected JPanel pDetail;

    //Déclaration des composants du tableau
    protected JScrollPane scrollPane;
    protected JTable table;

    //Déclaration des JTextField
    protected JTextField JTDateVisite;
    protected JTextField JTMatriVisite;
    protected JTextField JTRefVisite;

    //Déclaration des labels
    protected JLabel JLDate;
    protected JLabel JLMatri;
    protected JLabel JLRef;
    protected JLabel JLErreurRecherche;

    //Déclaration des boutons
    protected JButton JBRechercher;
    protected JButton JBDetail;

    //Variables pour le tableau
    private String[][] data;
    private String[] columnNames;
    private DefaultTableModel model;

    private VisiteService uneVisiteService = new VisiteService();

    private JOptionPane erreurRecherche;

    public JIFVisiteListe() {
        super();

        //Instanciation des panneaux avec ou sans grille
        p = new JPanel();
        p.setSize(1100, 750);
        pRecherche = new JPanel(new GridLayout(1,3));
        pRecherche.setMinimumSize(new Dimension(1100, 250));
        pRecherche1 = new JPanel(new GridLayout(2,2,10,5));
        pRecherche1.setMinimumSize(new Dimension(300,250));
        pRecherche2 = new JPanel();
        pRecherche2.setMinimumSize(new Dimension(200, 250));
        pRecherche3 = new JPanel();
        pRecherche3.setMinimumSize(new Dimension(600,250));
        pDetail = new JPanel(new GridLayout(1,3,5,5));
        pDetail.setSize(1100,100);

        //Instanciation des JTexField
        JTDateVisite = new JTextField(10);
        JTDateVisite.addMouseListener(this);
        JTMatriVisite = new JTextField(10);
        JTMatriVisite.addMouseListener(this);
        JTRefVisite = new JTextField(10);

        //Instanciation des labels
        JLDate = new JLabel("Date");
        JLMatri = new JLabel("Matricule");
        JLRef = new JLabel("Référence");
        JLErreurRecherche = new JLabel();
        JLErreurRecherche.setForeground(new Color(255,0,0));

        //Instanciation des événements
        JBRechercher = new JButton("Rechercher");
        JBRechercher.addActionListener(this); //Ecouteur d'événements
        JBDetail = new JButton("Détail");
        JBDetail.addActionListener(this); //Ecouteur d'événements

        //Ajout des éléments sur les sous-panneaux de recherche
        pRecherche1.add(JLDate);
        pRecherche1.add(JTDateVisite);
        pRecherche1.add(JLMatri);
        pRecherche1.add(JTMatriVisite);
        pRecherche2.add(JBRechercher);
        pRecherche3.add(JLErreurRecherche);

        //Ajout des sous-panneaux sur le panneau principal de recherche
        pRecherche.add(pRecherche1);
        pRecherche.add(pRecherche2);
        pRecherche.add(pRecherche3);

        //Ajout des éléments sur le panneau de détail
        pDetail.add(JLRef);
        pDetail.add(JTRefVisite);
        pDetail.add(JBDetail);

        //Variables pour le tableau
        columnNames = new String[]{"Référence", "Date", "Commentaire", "Visiteur", "Médecin"}; //Colonnes du tableau
        model = new DefaultTableModel(columnNames, 0); //Modèle de données du tableau
        table = new JTable(model); //Ajout des données dans le tableau
        table.addMouseListener(this); //Ecouteur de la souris
        scrollPane = new JScrollPane(table); //Ajout du tableau avec barre de défilement
        scrollPane.setPreferredSize(new Dimension(1100, 400));

        //Ajouts au panbeau principal
        p.add(pRecherche);
        p.add(scrollPane);
        p.add(pDetail);

        //Ajout du panneau principal à la fenêtre
        Container contentPane = getContentPane();
        contentPane.add(p);
    }

    //Evenements
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        //Recherche des visites
        if(source == JBRechercher) {
            model.setRowCount(0); //Vide les lignes du tableau

            ArrayList<Visite> colVisiteDateRef;
            String date = JTDateVisite.getText().toString();
            String matricule = JTMatriVisite.getText().toString();

            try {
                //Les champs ne peuvent pas être null
                if (date.equals("") || matricule.equals("")) {
                    throw new Exception("Tous les champs sont obligatoires");
                }
                //La date doit être au format dd/MM/yyyy
                if (!ValidationUtils.isDateValide(date)) {
                    throw new Exception("La date doit être au format dd/MM/yyyy");
                }
                //Une visite correspondante à la référence doit exister
                if (VisiteurDao.rechercher(matricule) == null) {
                    throw new Exception("Le visiteur correspondant à ce matricule n'existe pas");
                }
                //La référence ne peut pas dépasser 4 caracteres
                if (matricule.length() > 4) {
                    throw new Exception("Le matricule ne peut pas dépasser 5 caractères");
                }
                colVisiteDateRef = uneVisiteService.rechercheVisiteDateMat(date, matricule);
                for(Visite uneVisite : colVisiteDateRef) {
                    String[] visite = {uneVisite.getReference(), uneVisite.getDateVisite(), uneVisite.getUnCommentaire(), uneVisite.getUnVisiteur().getMatricule(), uneVisite.getUnMedecin().getCodeMed()};
                    model.addRow(visite); //Ajoute une visite dans le tableau
                }
            }
            catch (Exception erreur) {
                System.out.println(erreur.getMessage());
                JLErreurRecherche.setText(erreur.getMessage());
            }
        }
        //Ouvre la fenêtre du récapitulatif
        if(source == JBDetail) {
            Visite uneVisite = uneVisiteService.rechercherVisite(JTRefVisite.getText().toString());
        }
    }

    //Ecouteur au clic de la souris
    @Override
    public void mouseClicked(MouseEvent e) {
        Object mouse = e.getSource();
        if(mouse == table) {
            int ligne = table.getSelectedRow(); //Récupère la ligne du tableau
            String ref = table.getModel().getValueAt(ligne, 0).toString(); //Récupère la référence de la ligne
            JTRefVisite.setText(ref); //Initialise le JTextfield sur la référence
        }
        if(mouse == JTDateVisite || mouse == JTMatriVisite) {
            JLErreurRecherche.setText("");
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
