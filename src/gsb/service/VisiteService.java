package gsb.service;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

/**
 * @author womain
 * 26/10/2019
 */
public class VisiteService {

    /**
     *
     * @param uneReference chaine de caractères
     * @return un objet Visite
     */
    public static Visite rechercherVisite(String uneReference) {
        Visite uneVisite = null;
        try {
            //La référence entrée en paramètre ne peut pas être nulle
            if(uneReference == null) {
                throw new Exception("Référence de la visite obligatoire");
            }
            //La référence doit avoir 5 caractères
            if (uneReference.length() != 5) {
                throw new Exception("La référence doit posséder 5 caractères");
            }
            //La visite correspondant à la référence doit exister dans la base
            if(VisiteDao.rechercher(uneReference) == null) {
                throw new Exception(("La visite correspondant à cette référence n'existe pas"));
            }
            uneVisite = VisiteDao.rechercher(uneReference);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return uneVisite;
    }

}
