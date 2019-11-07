/*Créé le 17/10/2019 */
package gsb.modele;

/**
 * @author Gwendal
 * 7/11/2019
 * 
 */

public class Stock {
	
	protected Visiteur unVisiteur;
	protected Medicament unMedicament;
	protected int qteStock;
	
	
	
	public Stock(Medicament unMedicament, Visiteur unVisiteur, int qteStock) {		
		this.unVisiteur = unVisiteur;
		this.unMedicament = unMedicament;		
		this.qteStock = qteStock;
	}
	
	/**
	 * @return Renvoie unMedicament.
	 */
	public Medicament getUnMedicament() {
		return unMedicament;
	}
	/**
	 * @param unMedicament à définir.
	 */
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}
	
	/**
	 * @return Renvoie unVisiteur.
	 */
	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}
	/**
	 * @param unVisiteur à définir.
	 */
	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
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
