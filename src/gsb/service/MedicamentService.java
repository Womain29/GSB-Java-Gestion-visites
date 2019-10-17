/*Créé le 17/10/2019 */
package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

/**
 * @author Gwendal
 * 17/10/2019
 * 
 */
public class MedicamentService {
	
	public static Medicament rechercherMedicament(String unDepotLegal){
		Medicament unMedicament = null;
		try{
		if (unDepotLegal==null) {
            throw new Exception("Donnée obligatoire : depotLegal");
        }
		unMedicament = MedicamentDao.rechercher(unDepotLegal);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
}
