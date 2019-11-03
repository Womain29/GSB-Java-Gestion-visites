package gsb.vue;

import gsb.service.VisiteService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JIFVisiteAjout extends JIFVisite implements ActionListener {

    private JButton JBValider;
    private JButton JBAnnuler;

    private VisiteService uneVisiteService = new VisiteService();

    public JIFVisiteAjout() {
        super();

        JBValider = new JButton("Valider");
        JBValider.addActionListener(this);
        JBAnnuler = new JButton("Annuler");
        JBAnnuler.addActionListener(this);

        pBoutons.add(JBValider);
        pBoutons.add(JBAnnuler);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Ajout d'une visite");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == JBValider) {
            uneVisiteService.creerVisite(JTReference.getText().toString(), JTDate.getText().toString(), JTCommentaire.getText().toString(), JTVisiteur.getText().toString(), JTMedecin.getText().toString());
            this.videTexte();
        }
        if(source == JBAnnuler) {
            this.videTexte();
        }
    }
}
