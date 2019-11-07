package gsb.vue;

import gsb.modele.Visite;

/**
 * @author womain
 *
 * Fenêtre récapitulative d'une visite ciblée
 *
 * 03/11/2019
 */
public class JIFVisiteRecap extends JIFVisite {

    /**
     *
     * @param uneVisite objet Visite
     */
    public JIFVisiteRecap(Visite uneVisite) {
        super();
        this.remplirText(uneVisite);
    }
}
