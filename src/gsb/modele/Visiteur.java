/* Créé le 10 Octobre 2019
*/
package gsb.modele;
/**
 * @author Gwendal
 * 10/10/2019
 * 
 */
public class Visiteur {

	protected String matricule;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String mdp;
	protected String adresse;
	protected String telephone;
	protected String dateEntrer;
	protected int prime;
	
	public Visiteur(String matricule, String nom, String prenom, String login, String mdp, String adresse, String telephone, String dateEntrer, int prime) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom= prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateEntrer = dateEntrer;
		this.prime = prime;
	}	
}
