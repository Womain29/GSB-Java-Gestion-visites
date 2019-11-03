package gsb.vue;

import gsb.modele.Visite;

public class JIFVisiteRecap extends JIFVisite {

    public JIFVisiteRecap(Visite uneVisite) {
        super();
        this.remplirText(uneVisite);
    }
}
