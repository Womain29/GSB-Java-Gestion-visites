package gsb.tests;

import gsb.modele.Visite;
import gsb.service.VisiteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VisiteServiceTest {

    private VisiteService uneVisiteService;

    @BeforeEach
    void setUp() {
        uneVisiteService = new VisiteService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void rechercherVisiteReferenceVide() {
        System.out.println("--------------------------- rechercherVisiteReferenceVide ---------------------------------");
        Assertions.assertNull(uneVisiteService.rechercherVisite(null), "Résultat null car référence vide");
    }

    @Test
    void rechercherVisiteReference6caracteres() {
        System.out.println("--------------------------- rechercherVisiteReference6caracteres ---------------------------------");
        Assertions.assertNull(uneVisiteService.rechercherVisite("AAAAAA"), "Résultat null car référence trop longue");
    }

    @Test
    void rechercherVisiteReferenceKO() {
        System.out.println("--------------------------- rechercherVisiteReferenceKO ---------------------------------");
        Assertions.assertNull(uneVisiteService.rechercherVisite("aaaaa"), "Résultat null car pas de visite correspondante");
    }

    @Test
    void rechercherVisiteReferenceOK() {
        System.out.println("--------------------------- rechercherVisiteReferenceOK ---------------------------------");
        Assertions.assertNotNull(uneVisiteService.rechercherVisite("v0001"), "Résultat objet car une visite correspondante");

        Visite uneVisite = uneVisiteService.rechercherVisite("v0001");
        System.out.println("Référence : " + uneVisite.getReference());
        System.out.println("Date : " + uneVisite.getDateVisite());
        System.out.println("Commentaire : " + uneVisite.getUnCommentaire());
        System.out.println("Matricule Visiteur : " + uneVisite.getUnVisiteur().getMatricule());
        System.out.println("Code Médecin : " + uneVisite.getUnMedecin().getCodeMed());
    }

    @Test
    void creerVisite() {
    }
}