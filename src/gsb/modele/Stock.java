/*Créé le 17/10/2019 */
package gsb.modele;

/**
 * @author Gwendal
 * 17/10/2019
 * 
 */

public class Stock {
	
	protected String depotLegal;
	protected String matricule;
	protected int qteStock;
	
	public Stock(String depotLegal, String matricule, int qteStock) {
		this.depotLegal = depotLegal;
		this.matricule = matricule;
		this.qteStock = qteStock;
	}
}
