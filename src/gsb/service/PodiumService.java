package gsb.service;

import gsb.modele.Podium;
import gsb.modele.dao.PodiumDao;

import java.util.ArrayList;

/**
 * @author womain
 *
 * Classer service de la classe PodiumDao
 *
 * Créée le 23/03/2020
 */

public class PodiumService {

    /**
     *
     * @param id un entier
     * @return un Podium
     */
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

    /**
     *
     * @return la collection des 3 meilleurs visiteurs en terme de visite du mois précédent
     */
    public ArrayList<Podium> podiumMoisPrecedent() {

        ArrayList<Podium> podiumMoisPrecedent = new ArrayList<Podium>();

        try {
            podiumMoisPrecedent = PodiumDao.podiumMoisPrecedent();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return podiumMoisPrecedent;
    }
}
