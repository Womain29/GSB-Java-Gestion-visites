package gsb.vue;

import gsb.modele.Podium;
import gsb.service.PodiumService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class JIFVisitePodium extends JInternalFrame {

    //Déclaration des JPanel
    protected JPanel p;
    protected JPanel pMois;

    //Déclaration des composants du tableau
    protected JScrollPane scrollPane;
    protected JTable table;

    //Déclaration des labels
    protected JLabel JLMoisPodium;

    //Variables pour le tableau
    private String[][] data;
    private String[] columnNames;
    private DefaultTableModel model;

    private PodiumService unPodiumService;
    protected MenuPrincipal fenetreContainer;
    private ArrayList<Podium> podium;
    String mois;

    public JIFVisitePodium(MenuPrincipal uneFenetreContainer) {
        super();

        fenetreContainer = uneFenetreContainer;

        unPodiumService = new PodiumService();
        podium = new ArrayList<Podium>();

        //Instanciation des panneaux
        p = new JPanel();
        p.setSize(1100, 750);
        pMois = new JPanel();

        //Variables pour le tableau
        columnNames = new String[]{"Rang", "Matricule", "Nom", "Prénom", "Nombre Visites"}; //Colonnes du tableau
        model = new DefaultTableModel(columnNames, 0); //Modèle de données du tableau
        table = new JTable(model); //Ajout des données dans le tableau
        scrollPane = new JScrollPane(table); //Ajout du tableau avec barre de défilement
        scrollPane.setPreferredSize(new Dimension(1100, 400));

        //Affichage de podium dans le tableau
        try {
            podium = unPodiumService.podiumMoisPrecedent();
            for(Podium unPodium : podium) {
                mois = unPodium.getMois();
                Object[] donneesPodium = {unPodium.getRang(), unPodium.getUnVisiteur().getMatricule(), unPodium.getUnVisiteur().getNom(), unPodium.getUnVisiteur().getPrenom(), unPodium.getNbVisite()};
                model.addRow(donneesPodium);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Instanciation du JLabel avec le mois précédent
        JLMoisPodium = new JLabel("Podium du mois de " + mois);

        //Ajout des éléments aux panneaux
        pMois.add(JLMoisPodium);
        p.add(pMois);
        p.add(scrollPane);

        //Ajout du panneau principal à la fenêtre
        Container contentPane = getContentPane();
        contentPane.add(p);
    }


}
