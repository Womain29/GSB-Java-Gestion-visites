package gsb.modele;

/**
 * Classe Unite
 * Les visiteurs font partis d'une unite
 *
 * @author womain
 * 26/10/2019
 */

public class Unite {

    //Attributs
    protected String codeUnite;
    protected String nomUnite;

    //Constructeur
    public Unite(String codeUnite, String nomUnite) {
        this.codeUnite = codeUnite;
        this.nomUnite = nomUnite;
    }

    //Set et get

    /**
     *
     * @return le code de l'unite
     */
    public String getCodeUnite() {
        return codeUnite;
    }

    /**
     *
     * @param codeUnite chaine de caracteres
     */
    public void setCodeUnite(String codeUnite) {
        this.codeUnite = codeUnite;
    }

    /**
     *
     * @return le nom de l'unite
     */
    public String getNomUnite() {
        return nomUnite;
    }

    /**
     *
     * @param nomUnite chaine de caracteres
     */
    public void setNomUnite(String nomUnite) {
        this.nomUnite = nomUnite;
    }
}
