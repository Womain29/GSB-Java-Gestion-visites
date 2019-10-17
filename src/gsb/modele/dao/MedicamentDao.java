/*Créé le 17/10/2019 */
package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Medicament;
import gsb.modele.Famille;

/**
 * @author Gwendal
 * 17/10/2019
 * 
 */

public class MedicamentDao {
	
	public static Medicament rechercher(String depotLegal){
		Medicament unMedicament=null;
		Famille uneFamille = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDICAMENT where DEPOTLEGAL ='"+depotLegal+"'");
		try {
			if (reqSelection.next()) {
				uneFamille = FamilleDao.rechercher(reqSelection.getString(7));
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getFloat(6), uneFamille);	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ?te - select * from MEDICAMENT where DEPOTLEGAL ='"+depotLegal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	
}
