package gsb.modele.dao;

import gsb.modele.Podium;
import gsb.modele.Visiteur;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.VisiteurDao;
import oracle.jdbc.OracleTypes;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author womain
 *
 * Classe DAO de la classe Podium
 *
 * Créée le 22/03/2020
 */
public class PodiumDao {

    /**
     *
     * @param id un entier
     * @return un podium
     */
    public static Podium rechercher(int id) {
        Podium unPodium = null;
        Visiteur unVisiteur = null;
        Connection cnx = ConnexionMySql.ConnexionCallOracle();

        try {
            CallableStatement myCall = cnx.prepareCall("{CALL PR_PODIUM_RECHERCHER(?,?)}");
            myCall.setInt(1, id);
            myCall.registerOutParameter(2, OracleTypes.CURSOR);
            myCall.execute();

            ResultSet reqSelection = (ResultSet) myCall.getObject(2);

            if(reqSelection.next()) {
                unVisiteur = VisiteurDao.rechercher(reqSelection.getString(6));
                unPodium = new Podium(reqSelection.getInt(1), reqSelection.getInt(2), reqSelection.getInt(3), reqSelection.getString(4), reqSelection.getInt(5), unVisiteur);
            }
            myCall.close();
            reqSelection.close();
            cnx.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CALL PR_PODIUM_RECHERCHER(" + id + ")");
        }

        return unPodium;
    }

    /**
     *
     * @return une collection contenant le podium du mois précédent
     */
    public static ArrayList<Podium> podiumMoisPrecedent() {
        ArrayList<Podium> podium = new ArrayList<Podium>();
        Connection cnx = ConnexionMySql.ConnexionCallOracle();

        try {
            CallableStatement myCall = cnx.prepareCall("{CALL PR_PODIUM_SELECT(?)}");
            myCall.registerOutParameter(1, OracleTypes.CURSOR);
            myCall.execute();

            ResultSet reqSelection = (ResultSet) myCall.getObject(1);
            while (reqSelection.next()) {
                podium.add(PodiumDao.rechercher(reqSelection.getInt(1)));
            }
            myCall.close();
            reqSelection.close();
            cnx.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println();
        }

        return podium;
    }


}
