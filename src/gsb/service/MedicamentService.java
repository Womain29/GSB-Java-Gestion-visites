/*Cr�� le 17/10/2019 */
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
			//Un m�dicament entr� en param�tre ne doit pas �tre nul
			if (unDepotLegal==null) {
	            throw new Exception("Donn�e obligatoire : depotLegal");
	        }
			//Un m�dicament correspondant au d�pot l�gal doit exister
	        if(MedicamentDao.rechercher(unDepotLegal) == null) {
	            throw new Exception("Le m�dicament correspondant � ce d�pot l�gal n'existe pas");
	        }
			unMedicament = MedicamentDao.rechercher(unDepotLegal);
		}
		
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
}
