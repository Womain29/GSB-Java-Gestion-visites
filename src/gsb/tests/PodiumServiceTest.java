package gsb.tests;

import gsb.modele.Podium;
import gsb.service.PodiumService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author womain
 *
 * Classe de tests unitaires de la classe PodiumService
 *
 * Créée le 23 mars 2020
 */
class PodiumServiceTest {

    private ArrayList<Podium> podium;
    private PodiumService podiumService;

    @BeforeEach
    void setUp() {
        podium = new ArrayList<Podium>();
        podiumService = new PodiumService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rechercherPodiumIdInferieur1() {
        System.out.println("--------------------------- rechercherPodiumIdInferieur1 ---------------------------------");
        Assertions.assertNull(podiumService.rechercherPodium(0), "Résultat null car identifiant inférieur à 1");
    }

    @Test
    void rechercherPodiumIdKo() {
        System.out.println("--------------------------- rechercherPodiumIdKo ---------------------------------");
        Assertions.assertNull(podiumService.rechercherPodium(10), "Résultat null car pas d'identifiant correspondant");
    }

    @Test
    void rechercherPodiumOK() {
        System.out.println("--------------------------- rechercherPodiumOK ---------------------------------");
        Assertions.assertNotNull(podiumService.rechercherPodium(43), "Résultat non null");
    }

    @Test
    void podiumMoisPrecedent() {
    }
}