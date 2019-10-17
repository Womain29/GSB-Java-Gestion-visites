/* Cr�� le 10 Octobre 2019
*/
package gsb.modele;

/**
 * @author Gwendal
 * 17/10/2019
 * 
 */


public class Medicament {
	
	protected String depotLegal;
	protected String nomCommercial;
	protected String composition;
	protected String effets;
	protected String contreIndication;
	protected float prixEchantillion;
	protected Famille uneFamille;
	
	public Medicament(String depotLegal, String nomCommercial, String composition, String effets, String contreIndication, float prixEchantillion, Famille uneFamille) {
		this.depotLegal = depotLegal;
		this.nomCommercial = nomCommercial;
		this.composition = composition;
		this.effets = effets;
		this.contreIndication = contreIndication;
		this.prixEchantillion = prixEchantillion;
		this.uneFamille = uneFamille;
	}
	
	/**
	 * @return Renvoie depotLegal.
	 */
	public String getDepotLegal() {
		return depotLegal;
	}
	/**
	 * @param depotLegal � d�finir.
	 */
	public void setDepotLegal(String depotLegal) {
		this.depotLegal = depotLegal;
	}
	
	/**
	 * @return Renvoie nomCommercial.
	 */
	public String getNomCommercial() {
		return nomCommercial;
	}
	/**
	 * @param nomCommercial � d�finir.
	 */
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}
	
	/**
	 * @return Renvoie composition.
	 */
	public String getComposition() {
		return composition;
	}
	/**
	 * @param composition � d�finir.
	 */
	public void setComposition(String composition) {
		this.composition = composition;
	}
	
	/**
	 * @return Renvoie effets.
	 */
	public String getEffets() {
		return effets;
	}
	/**
	 * @param effets � d�finir.
	 */
	public void setEffets(String effets) {
		this.effets = effets;
	}
	
	/**
	 * @return Renvoie contreIndication.
	 */
	public String getContreIndication() {
		return contreIndication;
	}
	/**
	 * @param contreIndication � d�finir.
	 */
	public void setContreIndication(String contreIndication) {
		this.contreIndication = contreIndication;
	}
	
	/**
	 * @return Renvoie prixEchantillion.
	 */
	public float getPrixEchantillion() {
		return prixEchantillion;
	}
	/**
	 * @param prixEchantillion � d�finir.
	 */
	public void setPrixEchantillion(float prixEchantillion) {
		this.prixEchantillion = prixEchantillion;
	}
	
}
