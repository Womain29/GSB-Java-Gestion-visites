/*Créé le 07/11/2019 */
package gsb.modele.dao;
/**
 * @author Gwendal
 * 7/11/2019
 * 
 */
import gsb.modele.Stock;

public class StockDao {
	
	
	public static int ajouter(Stock unStock) {
        int result = 0;
        String unVisiteur = unStock.getUnVisiteur().getMatricule();
        String unMedicament = unStock.getUnMedicament().getDepotLegal();
        int qteStock = unStock.getQteStock();
        String requete = "INSERT INTO STOCKER VALUES ('" + unMedicament + "', '" + unVisiteur + "', "  + qteStock + ") ON DUPLICATE KEY UPDATE QteStock = QteStock + "  + qteStock + "";

        try {
            result = ConnexionMySql.execReqMaj(requete);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ConnexionMySql.fermerConnexionBd();

        return result;
    }
	
	
}
