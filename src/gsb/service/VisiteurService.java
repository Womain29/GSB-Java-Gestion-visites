package gsb.service;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

/**
 * @author womain
 * 26/10/2019
 */
public class VisiteurService {

    /**
     *
     * @param matricule chaine de caracteres
     * @return un objet Visiteur ou null
     */
    public Visiteur rechercherVisiteur (String matricule) {
        Visiteur unVisiteur = null;
        try {
            if(matricule == null) {
                throw new Exception("Le matricule ne peut pas être vide");
            }
            if(matricule.length() != 4) {
                throw new Exception("Le matricule doit être composé de 4 caractères");
            }
            unVisiteur = VisiteurDao.rechercher(matricule);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return unVisiteur;
    }
}
