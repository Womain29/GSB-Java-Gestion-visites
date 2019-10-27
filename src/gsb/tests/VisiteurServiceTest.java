package gsb.tests;

import gsb.modele.Unite;
import gsb.modele.Visiteur;
import gsb.service.VisiteurService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VisiteurServiceTest {

    private VisiteurService unVisiteurService;

    @BeforeEach
    void setUp() {
        unVisiteurService = new VisiteurService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rechercherVisiteurMatriculeVide() {
        System.out.println("--------------------------- rechercherVisiteurMatriculeVide -------------------------------");
        Assertions.assertNull(unVisiteurService.rechercherVisiteur(null), "Résultat null");
    }

    @Test
    void rechercherVisiteurMatricule5Caracteres() {
        System.out.println("--------------------------- rechercherVisiteurMatricule5Caracteres -------------------------------");
        Assertions.assertNull(unVisiteurService.rechercherVisiteur("ABCDE"), "Résultat null");
    }

    @Test
    void rechercherVisiteurMatricule3Caracteres() {
        System.out.println("--------------------------- rechercherVisiteurMatricule3Caracteres -------------------------------");
        Assertions.assertNull(unVisiteurService.rechercherVisiteur("ABC"), "Résultat null");
    }

    @Test
    void rechercherVisiteurMatriculeOK() {
        System.out.println("--------------------------- rechercherVisiteurMatriculeOK -------------------------------");
        Unite uneUnite = new Unite("SW", "SWISS");
        Visiteur unVisiteur = new Visiteur("a131", "Villechalane", "Louis", "lvillachane", "jux7g", "8 rue des Charmes", "46000", "2005-12-21", 0, uneUnite);
        Assertions.assertEquals(unVisiteur, unVisiteurService.rechercherVisiteur("a131"), "Résultat : unVisiteur");
    }

}