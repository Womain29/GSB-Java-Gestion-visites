package gsb.vue;

import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.VisiteService;
import gsb.utils.ValidationUtils;

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

    private JLabel JLErreur;

    private VisiteService uneVisiteService = new VisiteService();

    public JIFVisiteAjout() {
        super();

        //Instanciation des boutons
        JBValider = new JButton("Valider");
        JBValider.addActionListener(this);
        JBAnnuler = new JButton("Annuler");
        JBAnnuler.addActionListener(this);

        //Instanciation du label d'erreur
        JLErreur = new JLabel("");

        //Ajout du label dans le panneau erreur
        pErreur.add(JLErreur);

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

            try {
                //Les champs ne peuvent pas être vides excepté le champ commentaire
                if(JTReference.getText().toString().equals("") || JTDate.getText().toString().equals("") || JTVisiteur.getText().toString().equals("") || JTMedecin.getText().toString().equals("")) {
                    throw new Exception("Tous les champs sont obligatoires sauf le commentaire");
                }
                //La référence doit avoir 5 caractères
                if(JTReference.getText().toString().length() > 5) {
                    throw new Exception("La référence ne peut pas dépasser 5 caractères");
                }
                //La visite ne doit pas déjà existé
                if(VisiteDao.rechercher(JTReference.getText().toString()) != null) {
                    throw new Exception("Une visite avec cette référence existe déjà");
                }
                //La date doit être au format dd/MM/yyyy
                if(!ValidationUtils.isDateValide(JTDate.getText().toString())){
                    throw new Exception("La date doit être au format dd/MM/yyyy");
                }
                //La matricule doit être de 4 caractères
                if(JTVisiteur.getText().toString().length() > 4) {
                    throw new Exception("Le matricule visiteur ne peut pas dépasser 4 caractères");
                }
                //Le visiteur doit exister dans la base
                if(VisiteurDao.rechercher(JTVisiteur.getText().toString()) == null) {
                    throw new Exception("Le visiteur possédant cette référence n'existe pas");
                }
                //Le code du médecin doit être de 4 caractères
                if(JTMedecin.getText().toString().length() > 4) {
                    throw new Exception("Le code du médecin ne peut pas dépasser 4 caractères");
                }
                //Le médecin doit exister dans la base
                if(MedecinDao.rechercher(JTMedecin.getText().toString()) == null) {
                    throw new Exception("Le médecin possédant ce code n'existe pas");
                }
                uneVisiteService.creerVisite(JTReference.getText().toString(), JTDate.getText().toString(), JTCommentaire.getText().toString(), JTVisiteur.getText().toString(), JTMedecin.getText().toString());
                this.videTexte();
            }
            catch (Exception erreurAjout) {
                JLErreur.setText(erreurAjout.getMessage());
            }
        }
        //Evenement au clic sur le bouton valider
        if (source == JBAnnuler) {
            this.videTexte();
        }
    }
}
