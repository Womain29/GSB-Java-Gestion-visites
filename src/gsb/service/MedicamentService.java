/*Créé le 17/10/2019 */
package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

/**
 * @author Gwendal
 * 21/11/2019
 * 
 */
public class MedicamentService {
	
	public static Medicament rechercherMedicament(String unDepotLegal){
		Medicament unMedicament = null;
		try{
			//Un médicament entré en paramètre ne doit pas être nul
			if (unDepotLegal==null) {
	            throw new Exception("Donnée obligatoire : depotLegal");
	        }
			//Un médicament correspondant au dépot légal doit exister
	        if(MedicamentDao.rechercher(unDepotLegal) == null) {
	            throw new Exception("Le médicament correspondant à ce dépot légal n'existe pas");
	        }
			unMedicament = MedicamentDao.rechercher(unDepotLegal);
		}
		
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
}
