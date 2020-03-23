package gsb.service;

import gsb.modele.Podium;
import gsb.modele.dao.PodiumDao;

/**
 * @author womain
 *
 * Classer service de la classe PodiumDao
 *
 * Créée le 23/03/2020
 */

public class PodiumService {

    public Podium rechercherPodium(int id) {

        Podium unPodium = null;

        try {
            if(id < 1) {
                throw new Exception("L'identifiant doit être supérieur à 0");
            }
            if(PodiumDao.rechercher(id) == null) {
                throw new Exception("Il n'y pas de podium correspondant à cet identifiant");
            }
            unPodium = PodiumDao.rechercher(id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return unPodium;
    }
}
