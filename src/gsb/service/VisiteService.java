package gsb.service;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

/**
 * @author womain
 * 26/10/2019
 */
public class VisiteService {

    public static Visite rechercherVisite(String uneReference) {
        Visite uneVisite = null;
        try {
            if(uneReference == null) {
                throw new Exception("Référence de la visite obligatoire");
            }
            if (uneReference.length() != 5) {
                throw new Exception("La référence doit posséder 5 caractères");
            }
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
