/*Cr�� le 7/11/2019 */
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
        	//Un d�pot l�gal doit �tre renseign� 
        	if (depotLegal==null) {
                throw new Exception("Donn�e obligatoire : D�pot L�gal");
            }
        	//Un matricule doit �tre renseign� 
        	if (matricule==null) {
                throw new Exception("Donn�e obligatoire : Matricule");
            }
        	//Une quantit� ajout�e ne doit pas �tre inf�rieure �gale � 0
    		if (qteStock<=0) {
                throw new Exception("On ne peut pas ajouter une quantit� inf�rieure ou �gale � 0");
            }
    		//Le d�pot l�gal doit exister dans la base
    		if (MedicamentDao.rechercher(depotLegal)==null) {
                throw new Exception("Le d�pot legal n'existe pas");
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

    public Stock rechercherStock(String depotLegal, String matricule) {
        Stock unStock = null;

        try {
            if(depotLegal == null || matricule == null) {
                throw new Exception("Tous les champs sont obligatoires !");
            }
            if(matricule.length() > 4) {
                throw new Exception("Le matricule du visiteur ne doit pas dépasser 4 caractères");
            }
            if(VisiteurDao.rechercher(matricule) == null) {
                throw new Exception("Pas de visiteur correspondant à ce matricule");
            }
            if(depotLegal.length() > 50) {
                throw new Exception("Le dépot légal ne peut pas dépasser 50 caractères");
            }
            if(MedicamentDao.rechercher(depotLegal) == null) {
                throw new Exception("Pas de médicament correspondant à ce dépot légal");
            }

            unStock = StockDao.rechercher(depotLegal,matricule);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return unStock;
    }
	
}
