package gsb.tests;

import gsb.modele.*;
import gsb.service.VisiteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VisiteServiceTest {

    private VisiteService uneVisiteService;
    private Visite uneVisite;
    private Unite uneUnite;
    private Visiteur unVisiteur;
    private Medecin unMedecin;
    private Localite uneLocalite;

    @BeforeEach
    void setUp() {
        uneVisiteService = new VisiteService();

        uneUnite = new Unite("SW", "SWISS");
        unVisiteur = new Visiteur("a131", "Villechalane", "Louis", "lvillachane", "jux7g", "8 rue des Charmes", "46000", "21/12/2005", 0, uneUnite);
        uneLocalite = new Localite("23200", "Guéret");
        unMedecin = new Medecin("m001", "SMITH", "JEAN", "5 rue de la Poste", uneLocalite, "05-55-12-65-45", "", "Cardiologue");
    }

    @AfterEach
    void tearDown() {
        if(uneVisiteService.rechercherVisite("test") != null) {
            //Suppresion de la visite de test si existante
            uneVisiteService.supprimerVisite("test");
        }
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

        uneVisite = uneVisiteService.rechercherVisite("v0001");
        System.out.println("Référence : " + uneVisite.getReference());
        System.out.println("Date : " + uneVisite.getDateVisite());
        System.out.println("Commentaire : " + uneVisite.getUnCommentaire());
        System.out.println("Matricule Visiteur : " + uneVisite.getUnVisiteur().getMatricule());
        System.out.println("Code Médecin : " + uneVisite.getUnMedecin().getCodeMed());
    }

    @Test
    void creerVisiteAllNull() {
        System.out.println("--------------------------- creerVisiteAllNull ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite(null, null, null, null, null), "Résultat 0 car paramètres null");
    }

    @Test
    void creerVisiteRefNull() {
        System.out.println("--------------------------- creerVisiteRefNull ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite(null, "06/06/1996", "", "a131", "m001"), "Résultat 0 car référence null");
    }

    @Test
    void creerVisiteRefExistante() {
        System.out.println("--------------------------- creerVisiteRefExistante ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("v0001", "06/06/1996", "", "a131", "m001"), "Résultat 0 car référence existante");
    }
}