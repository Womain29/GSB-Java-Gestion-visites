/*
 * Créé le 21/11/2019
 */

package gsb.tests;
import gsb.modele.Medicament;
import gsb.service.MedicamentService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * @author Gwendal
 * 21/11/2019
 */
public class MedicamentServiceTest {
	
	private MedicamentService unMedicamentService;
	
	 @BeforeEach
	    void setUp() {
	        unMedicamentService = new MedicamentService();
	    }

	 @AfterEach
	    void tearDown() {
	    }
	
	 @Test
	    void rechercherMedicamentDepotLegalVide() {
	        System.out.println("--------------------------- rechercherMedicamentDepotLegalVide -------------------------------");
	        Assertions.assertNull(unMedicamentService.rechercherMedicament(null), "Résultat null");
	    }
	 
	 @Test
	    void rechercherMedicamentDepotLegalKO() {
	        System.out.println("--------------------------- rechercherMedicamentDepotLegalKO -------------------------------");
	        Assertions.assertNull(unMedicamentService.rechercherMedicament("AAAA"), "Pas de médicament correspondant donc résultat null");
	    }
	 
	
}
