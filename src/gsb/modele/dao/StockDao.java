/*Cr?? le 07/11/2019 */
package gsb.modele.dao;
/**
 * @author Gwendal
 * 7/11/2019
 * 
 */
import gsb.modele.Medicament;
import gsb.modele.Stock;
import gsb.modele.Visiteur;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockDao {
	
	
	public static int ajouter(Stock unStock) {
        int result = 0;
        String unVisiteur = unStock.getUnVisiteur().getMatricule();
        String unMedicament = unStock.getUnMedicament().getDepotLegal();
        int qteStock = unStock.getQteStock();
        String requete = "INSERT INTO STOCKER VALUES ('" + unMedicament + "', '" + unVisiteur + "', '"  + qteStock + "') ON DUPLICATE KEY UPDATE qteStock = qteStock + '"  + qteStock + "'";

        try {
            result = ConnexionMySql.execReqMaj(requete);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ConnexionMySql.fermerConnexionBd();

        return result;
    }

    public static Stock rechercher(String depotLegal, String matricule) {
        Medicament unMedicament = null;
        Visiteur unVisiteur = null;
        Stock unStock = null;
        String requete = "SELECT * FROM STOCKER WHERE DepotLegal = '" + depotLegal + "' AND Matricule = '" + matricule + "'";

        ResultSet reqSelection = ConnexionMySql.execReqSelection(requete);

        try {
            if(reqSelection.next()) {
                unMedicament = MedicamentDao.rechercher(reqSelection.getString(1));
                unVisiteur = VisiteurDao.rechercher(reqSelection.getString(2));
                unStock = new Stock(unMedicament, unVisiteur, reqSelection.getInt(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur avec la requête SELECT * FROM STOCKER WHERE DepotLegal = '" + depotLegal + "' AND Matricule = '" + matricule + "'");
        }
        return unStock;
    }
	
	
}
