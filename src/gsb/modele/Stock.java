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
	 * @return Renvoie matricule.
	 */
	public String getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule à définir.
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	/**
	 * @return Renvoie qteStock.
	 */
	public int getQteStock() {
		return qteStock;
	}
	/**
	 * @param qteStock à définir.
	 */
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	
	
}
