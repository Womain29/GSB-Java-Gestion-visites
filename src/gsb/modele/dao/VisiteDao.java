package gsb.modele.dao;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.utils.SQLUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * classe Dao d'une visite
 *
 * @author womain
 * 26/10/2019
 */

public class VisiteDao {

    /**
     *
     * @param uneReference chaine de caracteres
     * @return un objet Visite ou null
     */
    public static Visite rechercher(String uneReference) {
        Visite uneVisite = null;
        Medecin unMedecin = null;
        Visiteur unVisiteur = null;
        String requete = "SELECT * FROM VISITE WHERE Reference = '" + uneReference + "'";

        ResultSet reqSelection = ConnexionMySql.execReqSelection(requete);
        try {
            if (reqSelection.next()) {
                unMedecin = MedecinDao.rechercher(reqSelection.getString(5));
                unVisiteur = VisiteurDao.rechercher(reqSelection.getString(4));

                uneVisite = new Visite(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3),unVisiteur, unMedecin);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        ConnexionMySql.fermerConnexionBd();

        return uneVisite;
    }

    /**
     *
     * @param uneVisite un objet visite
     * @return 0 si la requete a echouee et 1 si la requete a reussi
     */
    public static int creer(Visite uneVisite) {
        int result = 0;
        String reference = uneVisite.getReference();
        String date = uneVisite.getDateVisite();
        String unCommentaire = uneVisite.getUnCommentaire();
        String matricule = uneVisite.getUnVisiteur().getMatricule();
        String codeMedecin = uneVisite.getUnMedecin().getCodeMed();
        String requete = "INSERT INTO VISITE VALUES ('" + reference + "', '" + SQLUtils.dateFormatSql(date) + "', '" + unCommentaire + "', '" + matricule + "', '" + codeMedecin + "')";

        try {
            result = ConnexionMySql.execReqMaj(requete);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ConnexionMySql.fermerConnexionBd();

        return result;
    }

    /**
     *
     * @param uneReference chaine de caracteres
     * @return 0 si echec, 1 si réussi
     */
    public static int supprimer(String uneReference) {
        int result = 0;
        String requete = "DELETE FROM VISITE WHERE Reference = '" + uneReference + "'";

        try {
            result = ConnexionMySql.execReqMaj(requete);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ConnexionMySql.fermerConnexionBd();

        return result;
    }

    /**
     *
     * @param uneDate chaine de caracteres
     * @param unMatricule chaine de caracteres
     * @return une collection de visite
     */
    public static ArrayList<Visite> rechercheDateMat(String uneDate, String unMatricule) {
        ArrayList<Visite> colVisiteDateRef = new ArrayList<Visite>();
        String requete = "SELECT * FROM VISITE WHERE Matricule = '" + unMatricule + "' AND Date = '" + SQLUtils.dateFormatSql(uneDate) + "'";
        ResultSet reqSelection = ConnexionMySql.execReqSelection(requete);

        try {
            while(reqSelection.next()) {
                String reference = reqSelection.getString(1);
                colVisiteDateRef.add(VisiteDao.rechercher(reference));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur requete SELECT * FROM VISITE WHERE Reference = '" + unMatricule + "' AND Date = '" + uneDate + "'");
        }
        ConnexionMySql.fermerConnexionBd();

        return colVisiteDateRef;
    }

    /**
     *
     * @param commentaire le commentaire d'une visite
     * @return 0 si echec, 1 si réussie
     */
    public static int updateCommentaire (String commentaire, String reference) {
        int result = 0;

        String requete = "UPDATE VISITE SET Commentaire = '" + commentaire + "' WHERE reference = '" + reference + "'";

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
