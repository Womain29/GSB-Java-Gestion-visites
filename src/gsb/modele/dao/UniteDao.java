package gsb.modele.dao;

import gsb.modele.Unite;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe Dao d'une unite
 *
 * @author womain
 * 26/10/2019
 */

public class UniteDao {

    /**
     *
     * @param codeUnite chaine de caracteres
     * @return un objet Unite
     */
    public static Unite rechercher(String codeUnite) {
        Unite uneUnite = null;
        String requete = "SELECT * FROM UNITE WHERE CodeUnit = '" + codeUnite + "'";

        ResultSet reqSelection = ConnexionMySql.execReqSelection(requete);
        try {
            if (reqSelection.next()) {
                uneUnite = new Unite(reqSelection.getString(1), reqSelection.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return uneUnite;
    }
}
