package gsb.tests;

import gsb.modele.Offrir;
import gsb.service.OffrirService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OffrirServiceTest {

    private OffrirService uneOffreService;
    private Offrir uneOffre;

    @BeforeEach
    void setUp() {
        uneOffreService = new OffrirService();
    }

    @AfterEach
    void tearDown() {
        if(uneOffreService.rechercherOffrir("3MYC7", "a131") != null) {
            uneOffreService.supprimerOffre("3MYC7", "a131");
        }
    }

    @Test
    void rechercherOffrirDepotNull() {
        System.out.println("---------------------------------- rechercherOffrirDepotNull -----------------------------------");
        Assertions.assertNull(uneOffreService.rechercherOffrir(null, "v0001"), "Résultat null car Depot null");
    }

    @Test
    void rechercherOffrirReferenceNull() {
        System.out.println("---------------------------------- rechercherOffrirDepotNull -----------------------------------");
        Assertions.assertNull(uneOffreService.rechercherOffrir("3MYC7", null), "Résultat null car reference null");
    }

    @Test
    void creerOffrir() {
    }

    @Test
    void soustraireStock() {
    }
}