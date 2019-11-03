package gsb.vue;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;
import gsb.service.VisiteService;

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
 * Fen�tre interne de consultation des visites
 */
public class JIFVisiteListe extends JInternalFrame implements ActionListener, MouseListener {

    //D�claration des JPanel
    protected JPanel p;
    protected JPanel pRecherche;
    protected JPanel pRecherche1;
    protected JPanel pRecherche2;
    protected JPanel pDetail;

    //D�claration des composants du tableau
    protected JScrollPane scrollPane;
    protected JTable table;

    //D�claration des JTextField
    protected JTextField JTDateVisite;
    protected JTextField JTMatriVisite;
    protected JTextField JTRefVisite;

    //D�claration des labels
    protected JLabel JLDate;
    protected JLabel JLMatri;
    protected JLabel JLRef;

    //D�claration des boutons
    protected JButton JBRechercher;
    protected JButton JBDetail;

    //Variables pour le tableau
    private String[][] data;
    private String[] columnNames;
    private DefaultTableModel model;

    private VisiteService uneVisiteService = new VisiteService();

    public JIFVisiteListe() {
        super();

        //Instanciation des panneaux avec ou sans grille
        p = new JPanel();
        pRecherche = new JPanel(new GridLayout(1,2));
        pRecherche1 = new JPanel(new GridLayout(2,2,10,5));
        pRecherche2 = new JPanel();
        pDetail = new JPanel(new GridLayout(1,3,5,5));

        //Instanciation des JTexField
        JTDateVisite = new JTextField();
        JTMatriVisite = new JTextField();
        JTRefVisite = new JTextField();

        //Instanciation des labels
        JLDate = new JLabel("Date");
        JLMatri = new JLabel("Matricule");
        JLRef = new JLabel("R�f�rence");

        //Instanciation des �v�nements
        JBRechercher = new JButton("Rechercher");
        JBRechercher.addActionListener(this); //Ecouteur d'�v�nements
        JBDetail = new JButton("D�tail");
        JBDetail.addActionListener(this); //Ecouteur d'�v�nements

        //Ajout des �l�ments sur les sous-panneaux de recherche
        pRecherche1.add(JLDate);
        pRecherche1.add(JTDateVisite);
        pRecherche1.add(JLMatri);
        pRecherche1.add(JTMatriVisite);
        pRecherche2.add(JBRechercher);

        //Ajout des sous-panneaux sur le panneau principal de recherche
        pRecherche.add(pRecherche1);
        pRecherche.add(pRecherche2);

        //Ajout des �l�ments sur le panneau de d�tail
        pDetail.add(JLRef);
        pDetail.add(JTRefVisite);
        pDetail.add(JBDetail);

        //Variables pour le tableau
        columnNames = new String[]{"R�f�rence", "Date", "Commentaire", "Visiteur", "M�decin"}; //Colonnes du tableau
        model = new DefaultTableModel(columnNames, 0); //Mod�le de donn�es du tableau
        table = new JTable(model); //Ajout des donn�es dans le tableau
        table.addMouseListener(this); //Ecouteur de la souris
        scrollPane = new JScrollPane(table); //Ajout du tableau avec barre de d�filement
        scrollPane.setPreferredSize(new Dimension(400, 200));

        //Ajouts au panbeau principal
        p.add(pRecherche);
        p.add(scrollPane);
        p.add(pDetail);

        //Ajout du panneau principal � la fen�tre
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
            colVisiteDateRef = uneVisiteService.rechercheVisiteDateMat(JTDateVisite.getText().toString(), JTMatriVisite.getText().toString());

            for(Visite uneVisite : colVisiteDateRef) {
                String[] visite = {uneVisite.getReference(), uneVisite.getDateVisite(), uneVisite.getUnCommentaire(), uneVisite.getUnVisiteur().getMatricule(), uneVisite.getUnMedecin().getCodeMed()};
                model.addRow(visite); //Ajoute une visite dans le tableau
            }
        }
    }

    //Ecouteur au clic de la souris
    @Override
    public void mouseClicked(MouseEvent e) {
        int ligne = table.getSelectedRow(); //R�cup�re la ligne du tableau
        String ref = table.getModel().getValueAt(ligne, 0).toString(); //R�cup�re la r�f�rence de la ligne
        JTRefVisite.setText(ref); //Initialise le JTextfield sur la r�f�rence
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
