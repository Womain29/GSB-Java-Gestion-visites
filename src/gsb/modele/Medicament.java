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
	
	
}
