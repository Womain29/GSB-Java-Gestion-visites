package gsb.modele;

/**
 * @author womain
 *
 * 21/11/2019
 *
 * Classe offrir
 */
    public class Offrir {

    //Attributs
    protected Medicament unMedicament;
    protected Visite uneVisite;
    protected Visiteur unVisiteur;
    protected int quantiteOfferte;

    /**
     *
     * @param unMedicament un objet Medicament
     * @param uneVisite un objet Visite
     * @param unVisiteur un objet Visiteur
     * @param quantiteOfferte une quantite
     */

    public Offrir(Medicament unMedicament, Visite uneVisite, Visiteur unVisiteur, int quantiteOfferte) {
        this.unMedicament = unMedicament;
        this.uneVisite = uneVisite;
        this.quantiteOfferte = quantiteOfferte;
        this.unVisiteur = unVisiteur;
    }

    /**
     *
     * @return un Medicament
     */
    public Medicament getUnMedicament() {
        return unMedicament;
    }

    /**
     *
     * @param unMedicament à définir
     */
    public void setUnMedicament(Medicament unMedicament) {
        this.unMedicament = unMedicament;
    }

    /**
     *
     * @return une Visite
     */
    public Visite getUneVisite() {
        return uneVisite;
    }

    /**
     *
     * @param uneVisite
     */
    public void setUneVisite(Visite uneVisite) {
        this.uneVisite = uneVisite;
    }

    /**
     *
     * @return un Visiteur
     */
    public Visiteur getUnVisiteur() { return unVisiteur; }

    /**
     *
     * @param unVisiteur
     */
    public void setUnVisiteur(Visiteur unVisiteur) {this.unVisiteur = unVisiteur; }

    /**
     *
     * @return une quantite
     */
    public int getQuantiteOfferte() {
        return quantiteOfferte;
    }

    /**
     *
     * @param quantiteOfferte
     */
    public void setQuantiteOfferte(int quantiteOfferte) {
        this.quantiteOfferte = quantiteOfferte;
    }
}
