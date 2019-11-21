package gsb.modele.dao;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author womain
 *
 * 21/11/2019
 *
 * Classe DAO de Offrir
 */

public class OffrirDao {

    /**
     *
     * @param depotLegal le depot legal du medicament
     * @param reference la reference de la visite
     * @return un objet Offrir
     */
    public static Offrir rechercher(String depotLegal, String reference) {
        Offrir unOffrir = null;
        Medicament unMedicament = null;
        Visite uneVisite = null;
        String requete = "SELECT * FROM OFFRIR WHERE DepotLegal = '" + depotLegal + "' AND Reference = '" + reference + "'";

        ResultSet reqSelection = ConnexionMySql.execReqSelection(requete);
        try {
            if(reqSelection.next()) {
                unMedicament = MedicamentDao.rechercher(reqSelection.getString(1));
                uneVisite = VisiteDao.rechercher(reqSelection.getString(2));
                unOffrir = new Offrir(unMedicament, uneVisite, reqSelection.getInt(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur avec la requete SELECT * FROM OFFRIR WHERE DepotLegal = '" + depotLegal + "' AND Reference = '" + reference + "'");
        }
        return unOffrir;
    }

    /**
     *
     * @param unOffrir
     * @return 0 si echec et 1 si réussi
     */
    public static int creer(Offrir unOffrir) {
        int result = 0;
        String unDepotLegal = unOffrir.getUnMedicament().getDepotLegal();
        String uneReference = unOffrir.getUneVisite().getReference();
        int uneQuantite = unOffrir.getQuantiteOfferte();
        String requete = "INSERT INTO OFFRIR VALUES (" + unDepotLegal + "', '" + uneReference + "', " + uneQuantite + ") ON DUPLICATE KEY UPDATE QteOfferte = QteOfferte + " + uneQuantite;

        try {
            result = ConnexionMySql.execReqMaj(requete);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur avec la requete INSERT INTO OFFRIR VALUES (" + unDepotLegal + "', '" + uneReference + "', " + uneQuantite + ") ON DUPLICATE KEY UPDATE QteOfferte = QteOfferte " + uneQuantite);
        }

        return result;
    }

    public static int soustraireStock(Offrir unOffrir) {
        int result = 0;
        String unDepotLegal = unOffrir.getUnMedicament().getDepotLegal();
        String uneReference = unOffrir.getUneVisite().getReference();
        int uneQuantite = unOffrir.getQuantiteOfferte();
        String requete = "UPDATE STOCK SET QteStock = QteStock - " + uneQuantite;

        try {
            result = ConnexionMySql.execReqMaj(requete);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur avec la requete UPDATE STOCK SET QteStock = QteStock - " + uneQuantite);
        }

        return result;
    }
}
