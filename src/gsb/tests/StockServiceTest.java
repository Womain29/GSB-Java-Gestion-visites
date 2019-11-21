/*
 * Créé le 21/11/2019
*/

package gsb.tests;
import gsb.modele.*;
import gsb.service.StockService;
import gsb.service.VisiteService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/*
 * @author Gwendal
 * 21/11/2019
 */

public class StockServiceTest {
	 
	 private StockService unStockService;
	 private Stock unStock;
	 
	 @BeforeEach
	    void setUp() {
	        unStockService = new StockService();
	    }

	    @AfterEach
	    void tearDown() {
	        
	    }
	    
	    @Test
	    void ajoutStockAllNull() {
	        System.out.println("--------------------------- ajoutStockAllNull ---------------------------------");
	        Assertions.assertEquals(0, unStockService.ajoutStock(null, null, 0), "Résultat 0 car paramètres null");
	    }
	    
	    @Test
	    void ajoutStockDepotLegalNull() {
	        System.out.println("--------------------------- ajoutStockDepotLegalNull ---------------------------------");
	        Assertions.assertEquals(0, unStockService.ajoutStock(null, "a131", 15), "Résultat 0 car depotLegal null");
	    }
	    
	    @Test
	    void ajoutStockMatriculeNull() {
	        System.out.println("--------------------------- ajoutStockMatriculeNull ---------------------------------");
	        Assertions.assertEquals(0, unStockService.ajoutStock("3MYC7", null, 15), "Résultat 0 car matricule null");
	    }
	    
	    @Test
	    void ajoutStockQteStockNull() {
	        System.out.println("--------------------------- ajoutStockQteStockNull ---------------------------------");
	        Assertions.assertEquals(0, unStockService.ajoutStock("3MYC7", "a131", 0), "Résultat 0 car qteStock null");
	    }
}
