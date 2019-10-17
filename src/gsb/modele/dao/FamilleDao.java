/*Créé le 17/10/2019*/
package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Famille;

/**
 * @author Gwendal
 * 17/10/2019
 * 
 */

public class FamilleDao {
	
	public static Famille rechercher(String codeFamille){
		Famille uneFamille=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from FAMILLE where CODEFAMILLE='"+codeFamille+"'");
		try {
			if (reqSelection.next()) {
				uneFamille = new Famille(reqSelection.getString(1), reqSelection.getString(2));	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ?te - select * from FAMILLE where CODEFAMILLE='"+codeFamille+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneFamille;
	}
}
