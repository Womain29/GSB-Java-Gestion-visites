package gsb.modele;

/**
 * @author womain
 *
 * Classe Podium des visiteurs en nombres de visites par mois
 */

public class Podium {

    protected int idPodium;
    protected int rang;
    protected int nbVisite;
    protected String mois;
    protected int annee;
    protected Visiteur unVisiteur;

    /**
     *
     * @param rang un entier
     * @param nbVisite un entier
     * @param mois le mois
     * @param annee l'année
     * @param unVisiteur le visiteur
     */
    public Podium(int idPodium, int rang, int nbVisite, String mois, int annee, Visiteur unVisiteur) {
        this.rang = rang;
        this.nbVisite = nbVisite;
        this.mois = mois;
        this.annee = annee;
        this.unVisiteur = unVisiteur;
        this.idPodium = idPodium;
    }

    /**
     *
     * @return le rang du visiteur
     */
    public int getRang() {
        return rang;
    }

    /**
     *
     * @param rang un entier
     */
    public void setRang(int rang) {
        this.rang = rang;
    }

    /**
     *
     * @return le nombre de visite du visiteur
     */
    public int getNbVisite() {
        return nbVisite;
    }

    /**
     *
     * @param nbVisite un entier
     */
    public void setNbVisite(int nbVisite) {
        this.nbVisite = nbVisite;
    }

    /**
     *
     * @return le mois du podium
     */
    public String getMois() {
        return mois;
    }

    /**
     *
     * @param mois une chaine de caractères
     */
    public void setMois(String mois) {
        this.mois = mois;
    }

    /**
     *
     * @return l'année du podium
     */
    public int getAnnee() {
        return annee;
    }

    /**
     *
     * @param annee un entier
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    /**
     *
     * @return le visiteur du podium
     */
    public Visiteur getUnVisiteur() {
        return unVisiteur;
    }

    /**
     *
     * @param unVisiteur un visiteur
     */
    public void setUnVisiteur(Visiteur unVisiteur) {
        this.unVisiteur = unVisiteur;
    }

    /**
     *
     * @return l'identifiant du podium
     */
    public int getIdPodium() {
        return idPodium;
    }

    /**
     *
     * @param idPodium un entier
     */
    public void setIdPodium(int idPodium) {
        this.idPodium = idPodium;
    }
}
