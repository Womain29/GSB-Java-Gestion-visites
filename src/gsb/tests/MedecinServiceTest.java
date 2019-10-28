package gsb.tests;

import gsb.service.MedecinService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de test de MedecinService
 *
 * @author womain
 * 28/10/2019
 */
class MedecinServiceTest {

    private MedecinService unMedecinService;

    @BeforeEach
    void setUp() {
        unMedecinService = new MedecinService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rechercherMedecinCodeNull() {
        System.out.println("--------------------------------- rechercherMedecinCodeNull ------------------------------");
        Assertions.assertNull(unMedecinService.rechercherMedecin(null), "Résultat null car code null");
    }

    @Test
    void rechercherMedecinCode5Carac() {
        System.out.println("--------------------------------- rechercherMedecinCode5Carac ------------------------------");
        Assertions.assertNull(unMedecinService.rechercherMedecin("AAAAA"), "Résultat null car code trop long");
    }

}