package gsb.vue;

import gsb.modele.Visite;

import javax.swing.*;
import java.awt.*;

/**
 * @author womain
 * 28/10/2019
 */
public class JIFVisite extends JInternalFrame {

    protected JPanel p;
    protected JPanel pTexte;
    protected JPanel pBoutons;

    protected JLabel JLReference;
    protected JLabel JLDate;
    protected JLabel JLCommentaire;
    protected JLabel JLVisiteur;
    protected JLabel JLMedecin;

    protected JTextField JTReference;
    protected JTextField JTDate;
    protected JTextField JTCommentaire;
    protected JTextField JTVisiteur;
    protected JTextField JTMedecin;

    public JIFVisite() {
        p = new JPanel();
        pTexte = new JPanel(new GridLayout(5,2,5,5));
        pBoutons = new JPanel();

        JLReference = new JLabel("Référence");
        JLDate = new JLabel("Date");
        JLCommentaire = new JLabel("Commentaire");
        JLVisiteur = new JLabel("Visiteur");
        JLMedecin = new JLabel("Médecin");

        JTReference = new JTextField(15);
        JTDate = new JTextField(15);
        JTCommentaire = new JTextField(15);
        JTVisiteur = new JTextField(15);
        JTMedecin = new JTextField(15);

        pTexte.add(JLReference);
        pTexte.add(JTReference);
        pTexte.add(JLDate);
        pTexte.add(JTDate);
        pTexte.add(JLCommentaire);
        pTexte.add(JTCommentaire);
        pTexte.add(JLVisiteur);
        pTexte.add(JTVisiteur);
        pTexte.add(JLMedecin);
        pTexte.add(JTMedecin);

        p.add(pTexte);
        p.add(pBoutons);

        Container contentPane = getContentPane();
        contentPane.add(p);
    }

    public void remplirText(Visite uneVisite) {
        JTReference.setText(uneVisite.getReference());
        JTDate.setText(uneVisite.getDateVisite());
        JTCommentaire.setText(uneVisite.getUnCommentaire());
        JTVisiteur.setText(uneVisite.getUnVisiteur().getMatricule());
        JTMedecin.setText(uneVisite.getUnMedecin().getCodeMed());
    }

    public void videTexte() {
        JTReference.setText("");
        JTDate.setText("");
        JTCommentaire.setText("");
        JTVisiteur.setText("");
        JTMedecin.setText("");
    }
}
