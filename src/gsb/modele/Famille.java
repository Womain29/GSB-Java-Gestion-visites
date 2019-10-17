/*Créé le 17/10/2019*/
package gsb.modele;

/**
 * @author Gwendal
 * 17/10/2019
 * 
 */

public class Famille {
	
	protected String codeFamille;
	protected String libelleFamille;
	
	public Famille(String codeFamille, String libelleFamille) {
		this.codeFamille = codeFamille;
		this.libelleFamille = libelleFamille;
	}
	
	/**
	 * @return Renvoie codeFamille.
	 */
	public String getCodeFamille() {
		return codeFamille;
	}
	/**
	 * @param codeFamille à définir.
	 */
	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}
	
	/**
	 * @return Renvoie libelleFamille.
	 */
	public String getLibelleFamille() {
		return libelleFamille;
	}
	/**
	 * @param libelleFamille à définir.
	 */
	public void setLibelleFamille(String libelleFamille) {
		this.libelleFamille = libelleFamille;
	}
}
