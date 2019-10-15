/* Cr?? le 10 Octobre 2019
*/
package gsb.modele;
/**
 * @author Gwendal
 * 15/10/2019
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
	
	/**
	 * @return Renvoie matricule.
	 */
	public String getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule ? d?finir.
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	/**
	 * @return Renvoie nom.
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom ? d?finir.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return Renvoie prenom.
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom ? d?finir.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * @return Renvoie login.
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login ? d?finir.
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * @return Renvoie mdp.
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param mdp ? d?finir.
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	/**
	 * @return Renvoie adresse.
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse ? d?finir.
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * @return Renvoie telephone.
	 */
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone ? d?finir.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDateEntrer() {
		return dateEntrer;
	}

	public void setDateEntrer(String dateEntrer) {
		this.dateEntrer = dateEntrer;
	}

	public int getPrime() {
		return prime;
	}

	public void setPrime(int prime) {
		this.prime = prime;
	}	
}
