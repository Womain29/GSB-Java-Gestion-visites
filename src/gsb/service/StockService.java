/*Créé le 7/11/2019 */
package gsb.service;

import gsb.modele.Stock;
import gsb.modele.Medicament;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.StockDao;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.ValidationUtils;

/**
 * @author Gwendal
 * 21/11/2019
 * 
 */
public class StockService {
	
	
	public int ajoutStock(String depotLegal, String matricule, int qteStock) {
        int result = 0;
        Visiteur unVisiteur = null;
        Medicament unMedicament = null;
        Stock unStock = null;

        try{
        	//Un dépot légal doit être renseigné 
        	if (depotLegal==null) {
                throw new Exception("Donnée obligatoire : Dépot Légal");
            }
        	//Un matricule doit être renseigné 
        	if (matricule==null) {
                throw new Exception("Donnée obligatoire : Matricule");
            }
        	//Une quantité ajoutée ne doit pas être inférieure égale à 0
    		if (qteStock<=0) {
                throw new Exception("On ne peut pas ajouter une quantité inférieure ou égale à 0");
            }
    		//Le dépot légal doit exister dans la base
    		if (MedicamentDao.rechercher(depotLegal)==null) {
                throw new Exception("Le dépot legal n'existe pas");
            }
    		//Le matricule doit exister dans la base
    		if (VisiteurDao.rechercher(matricule)==null) {
                throw new Exception("Le visiteur n'existe pas");
            }
    		unVisiteur = VisiteurDao.rechercher(matricule);
    		unMedicament = MedicamentDao.rechercher(depotLegal);          
            unStock = new Stock(unMedicament, unVisiteur, qteStock);
            result = StockDao.ajouter(unStock);
    		}
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
	
}
