package gsb.service;

import gsb.modele.Offrir;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.OffrirDao;
import gsb.modele.dao.VisiteDao;

/**
 * @author womain
 *
 * 21/11/2019
 *
 * Classe service de OffrirDao
 */

public class OffrirService {

    /**
     *
     * @param depotLegal le depot du medicament
     * @param reference la reference de la visite
     * @return un objet Offrir
     */
    public Offrir rechercherOffrir(String depotLegal, String reference) {
        Offrir unOffrir = null;
        try {
            if(depotLegal == null || reference == null) {
                throw new Exception("Tous les champs sont obligatoires");
            }
            if(depotLegal.length() > 50) {
                throw new Exception("La longueur du dépôt doit être inférieur à 50 caractères");
            }
            if(MedicamentDao.rechercher(depotLegal) == null) {
                throw new Exception("Aucun médicament ne correspond à ce déppôt ");
            }
            if(reference.length() > 5) {
                throw new Exception("La référence ne peut pas dépasser 5 caractères");
            }
            if(VisiteDao.rechercher(reference) == null) {
                throw new Exception("La visite correspondant à cette référence n'existe pas");
            }
            unOffrir = OffrirDao.rechercher(depotLegal, reference);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return unOffrir;
    }
}
