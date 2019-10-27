package gsb.modele.dao;

import gsb.modele.Unite;
import gsb.modele.Visiteur;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe DAO pour Visiteur
 *
 * @author womain
 * 26/10/2019
 */

public class VisiteurDao {

    /**
     *
     * @param matriculeVisiteur chaine de caracteres
     * @return un objet Visiteur
     */

    public static Visiteur rechercher(String matriculeVisiteur) {
        Visiteur unVisiteur = null;
        Unite uneUnite = null;
        String requete = "SELECT * FROM VISITEUR WHERE Matricule = '" + matriculeVisiteur + "'";

        ResultSet reqSelection = ConnexionMySql.execReqSelection(requete);
        try {
            if (reqSelection.next()) {
                uneUnite = UniteDao.rechercher(reqSelection.getString(10));

                //                                      Matricule                              Nom                                       Prenom                                 Login                                    Mdp                                    Adresse                           CodePostal                            DateEntrée                            Prime                     Unite
                unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8), reqSelection.getInt(9), uneUnite);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return unVisiteur;
    }

}
