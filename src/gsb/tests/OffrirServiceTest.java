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
        System.out.println("---------------------------------- rechercherOffrirReferenceNull -----------------------------------");
        Assertions.assertNull(uneOffreService.rechercherOffrir("3MYC7", null), "Résultat null car reference null");
    }

    @Test
    void rechercherOffrirDepot50carac() {
        System.out.println("---------------------------------- rechercherOffrirDepot50carac -----------------------------------");
        Assertions.assertNull(uneOffreService.rechercherOffrir("3MYC7YYYYY3MYC7YYYYY3MYC7YYYYY3MYC7YYYYY3MYC7YYYYY3", "v0001"), "Résultat null car depot trop long");
    }

    @Test
    void rechercherOffrirDepotKO() {
        System.out.println("---------------------------------- rechercherOffrirDepotKO -----------------------------------");
        Assertions.assertNull(uneOffreService.rechercherOffrir("AAAAA", "v0001"), "Résultat null car le dépot n'existe pas dans la base");
    }

    @Test
    void rechercherOffrirReference6carac() {
        System.out.println("---------------------------------- rechercherOffrirReference6carac -----------------------------------");
        Assertions.assertNull(uneOffreService.rechercherOffrir("3MYC7", "v00066"), "Résultat null car la reference est trop longue");
    }

    @Test
    void rechercherOffrirReferenceKO() {
        System.out.println("---------------------------------- rechercherOffrirReferenceKO -----------------------------------");
        Assertions.assertNull(uneOffreService.rechercherOffrir("3MYC7", "v7777"), "Résultat null car la reference n'existe pas");
    }

    @Test
    void rechercherOffrirOK() {
        System.out.println("---------------------------------- rechercherOffrirOK -----------------------------------");
        Assertions.assertNotNull(uneOffreService.rechercherOffrir("3MYC7", "v0001"), "Résultat OK");
    }

    @Test
    void creerOffrirDepotNull() {
        System.out.println("---------------------------------- creerOffrirDepotNull -----------------------------------");
        Assertions.assertEquals(0,uneOffreService.creerOffrir(null,"v0001", 4), "Résultat null car depot null");
    }

    @Test
    void creerOffrirReferenceNull() {
        System.out.println("---------------------------------- creerOffrirReferenceNull -----------------------------------");
        Assertions.assertEquals(0,uneOffreService.creerOffrir("3MYC7",null, 4), "Résultat null car reference null");
    }

    @Test
    void creerOffrirQuantiteInf1() {
        System.out.println("---------------------------------- creerOffrirQuantitéInf1 -----------------------------------");
        Assertions.assertEquals(0,uneOffreService.creerOffrir("3MYC7","v0001", 0), "Résultat null car quantité inférieur à 1");
    }

    @Test
    void soustraireStock() {
    }
}