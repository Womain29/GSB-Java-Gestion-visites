package gsb.modele;

/**
 * Classe Visite
 *
 * @author womain
 * 26/10/2019
 */

public class Visite {

    protected String reference;
    protected String dateVisite;
    protected String unCommentaire;
    protected Visiteur unVisiteur;
    protected Medecin unMedecin;

    /**
     *
     * @param reference code de la visite
     * @param dateVisite date de la visite
     * @param unCommentaire commenaitaire concernant la visite
     * @param unVisiteur visiteur qui effectue la visite
     * @param unMedecin medecin chez qui la visite est effectuée
     */

    public Visite(String reference, String dateVisite, String unCommentaire, Visiteur unVisiteur, Medecin unMedecin) {
        this.reference = reference;
        this.dateVisite = dateVisite;
        this.unCommentaire = unCommentaire;
        this.unVisiteur = unVisiteur;
        this.unMedecin = unMedecin;
    }
}
