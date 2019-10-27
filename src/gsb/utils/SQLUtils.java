package gsb.utils;

public class SQLUtils {

    public static String dateFormatSql(String uneDate) {
        String annee = uneDate.substring(6,9);
        String mois = uneDate.substring(3,5);
        String jour = uneDate.substring(0,2);

        String dateFormatSql = annee + mois + jour;

        return dateFormatSql;
    }
}
