/* Créé le 10 Octobre 2019
*/
package gsb.modele;

/**
 * @author Gwendal
 * 10/10/2019
 * 
 */


public class Medicament {
	
	protected String depotLegal;
	protected String nomCommercial;
	protected String composition;
	protected String effets;
	protected String contreIndication;
	protected int prixEchantillion;
	
	public Medicament(String depotLegal, String nomCommercial, String composition, String effets, String contreIndication, int prixEchantillion) {
		this.depotLegal = depotLegal;
		this.nomCommercial = nomCommercial;
		this.composition = composition;
		this.effets = effets;
		this.contreIndication = contreIndication;
		this.prixEchantillion = prixEchantillion;
	}
	
	/**
	 * @return Renvoie depotLegal.
	 */
	public String getDepotLegal() {
		return depotLegal;
	}
	/**
	 * @param depotLegal à définir.
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
	 * @param nomCommercial à définir.
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
	 * @param composition à définir.
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
	 * @param effets à définir.
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
	 * @param contreIndication à définir.
	 */
	public void setContreIndication(String contreIndication) {
		this.contreIndication = contreIndication;
	}
	
	/**
	 * @return Renvoie prixEchantillion.
	 */
	public int getPrixEchantillion() {
		return prixEchantillion;
	}
	/**
	 * @param prixEchantillion à définir.
	 */
	public void setPrixEchantillion(int prixEchantillion) {
		this.prixEchantillion = prixEchantillion;
	}
}
