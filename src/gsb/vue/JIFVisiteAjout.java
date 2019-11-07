package gsb.vue;

import gsb.service.VisiteService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author womain
 *
 * Fenêtre d'ajout d'une visite
 *
 * 03/11/2019
 */
public class JIFVisiteAjout extends JIFVisite implements ActionListener {

    //Déclaration des boutons
    private JButton JBValider;
    private JButton JBAnnuler;

    private VisiteService uneVisiteService = new VisiteService();

    public JIFVisiteAjout() {
        super();

        //Instanciation des boutons
        JBValider = new JButton("Valider");
        JBValider.addActionListener(this);
        JBAnnuler = new JButton("Annuler");
        JBAnnuler.addActionListener(this);

        //Ajout au panneau des boutons
        pBoutons.add(JBValider);
        pBoutons.add(JBAnnuler);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Ajout d'une visite");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        //Evenement au clic sur le bouton valider
        if (source == JBValider) {
            uneVisiteService.creerVisite(JTReference.getText().toString(), JTDate.getText().toString(), JTCommentaire.getText().toString(), JTVisiteur.getText().toString(), JTMedecin.getText().toString());
            this.videTexte();
        }
        //Evenement au clic sur le bouton valider
        if (source == JBAnnuler) {
            this.videTexte();
        }
    }
}
