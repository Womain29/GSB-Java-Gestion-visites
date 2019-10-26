package gsb.service;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.utils.ValidationUtils;

/**
 * @author womain
 * 26/10/2019
 */
public class VisiteService {

    /**
     *
     * @param uneReference chaine de caractères
     * @return un objet Visite
     */
    public Visite rechercherVisite(String uneReference) {
        Visite uneVisite = null;
        try {
            //La référence entrée en paramètre ne peut pas être nulle
            if(uneReference == null) {
                throw new Exception("Référence de la visite obligatoire");
            }
            //La référence doit avoir 5 caractères
            if (uneReference.length() != 5) {
                throw new Exception("La référence doit posséder 5 caractères");
            }
            uneVisite = VisiteDao.rechercher(uneReference);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return uneVisite;
    }

    public int creerVisite(String reference, String date, String commentaire, String matricule, String codeMedecin) {
        int result = 0;
        Visite uneVisite = null;
        Visiteur unVisiteur = null;
        Medecin unMedecin = null;

        try {
            //Les champs ne peuvent pas être vides excepté le champ commentaire
            if(reference == null || date == null || matricule == null || codeMedecin == null) {
                throw new Exception("Tous les champs sont obligatoires sauf le commentaire");
            }
            //La référence doit avoir 5 caractères
            if(reference.length() != 5) {
                throw new Exception("La référence doit être composée de 5 caractères");
            }
            //La visite ne doit pas déjà existé
            if(VisiteDao.rechercher(reference) != null) {
                throw new Exception("Une visite avec cette référence existe déjà");
            }
            //La date doit être au format dd/MM/yyyy
            if(!ValidationUtils.isDateValide(date)){
                throw new Exception("La date doit être au format dd/MM/yyyy");
            }
            //La matricule doit être de 4 caractères
            if(matricule.length() != 4) {
                throw new Exception("Le matricule visiteur doit être composé de 4 caractères");
            }
            //Le visiteur doit exister dans la base
            if(VisiteurDao.rechercher(matricule) == null) {
                throw new Exception("Le visiteur possédant cette référence n'existe pas");
            }
            //Le code du médecin doit être de 4 caractères
            if(codeMedecin.length() != 4) {
                throw new Exception("Le code du médecin doit être composé de 4 caractères");
            }
            //Le médecin doit exister dans la base
            if(MedecinDao.rechercher(codeMedecin) == null) {
                throw new Exception("Le médecin possédant ce code n'existe pas");
            }
            unMedecin = MedecinDao.rechercher(codeMedecin);
            unVisiteur = VisiteurDao.rechercher(matricule);
            uneVisite = new Visite(reference, date, commentaire, unVisiteur, unMedecin);
            result = VisiteDao.creer(uneVisite);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
