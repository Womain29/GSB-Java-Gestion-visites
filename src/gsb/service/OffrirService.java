package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.Offrir;
import gsb.modele.Visite;
import gsb.modele.dao.*;
import gsb.utils.ValidationUtils;

/**
 * @author womain
 *
 * 21/11/2019
 *
 * Classe service de OffrirDao
 */

public class OffrirService {

    /**
     *
     * @param depotLegal le depot du medicament
     * @param reference la reference de la visite
     * @param matricule le matricule du visiteur
     * @return un objet Offrir
     */
    public Offrir rechercherOffrir(String depotLegal, String reference, String matricule) {
        Offrir unOffrir = null;
        try {
            if(depotLegal == null || reference == null || matricule == null) {
                throw new Exception("Tous les champs sont obligatoires");
            }
            if(depotLegal.length() > 50) {
                throw new Exception("La longueur du dépôt doit être inférieur à 50 caractères");
            }
            if(MedicamentDao.rechercher(depotLegal) == null) {
                throw new Exception("Aucun médicament ne correspond à ce dépôt ");
            }
            if(reference.length() > 5) {
                throw new Exception("La référence ne peut pas dépasser 5 caractères");
            }
            if(VisiteDao.rechercher(reference) == null) {
                throw new Exception("La visite correspondant à cette référence n'existe pas");
            }
            //La matricule doit être de 4 caractères maximum
            if(matricule.length() > 4) {
                throw new Exception("Le matricule visiteur ne peut pas dépasser 4 caractères");
            }
            //Le visiteur doit exister dans la base
            if(VisiteurDao.rechercher(matricule) == null) {
                throw new Exception("Le visiteur possédant cette référence n'existe pas");
            }
            unOffrir = OffrirDao.rechercher(depotLegal, reference, matricule);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return unOffrir;
    }

    public int creerOffrir(String depotLegal, String reference, int uneQuantite) {
        int result = 0;
        Visite uneVisite = null;
        Medicament unMedicament = null;
        Offrir unOffrir = null;

        try {
            if(depotLegal == null || reference == null) {
                throw new Exception("Tous les champs sont obligatoires !");
            }
            if(uneQuantite < 1) {

            }
            //
            if(depotLegal.length() > 50) {

            }
            if(MedicamentDao.rechercher(depotLegal) == null) {

            }
            if(reference.length() > 5){

            }
            if(VisiteDao.rechercher(reference) == null) {

            }
            //Exception si quantite offerte > au stock de medicament
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
