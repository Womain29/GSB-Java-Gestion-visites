package gsb.tests;

import gsb.modele.*;
import gsb.service.VisiteService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class VisiteServiceTest {

    private VisiteService uneVisiteService;
    private Visite uneVisite;
    private ArrayList<Visite> colVisiteDateRef;

    @BeforeEach
    void setUp() {
        uneVisiteService = new VisiteService();
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

    @Test
    void creerVisiteRef6Caracteres() {
        System.out.println("--------------------------- creerVisiteRef6Caracteres ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("AAAAAA", "06/06/1996", "", "a131", "m001"), "Résultat 0 car référence de 6 caracteres");
    }

    @Test
    void creerVisiteDateNull() {
        System.out.println("--------------------------- creerVisiteDateNull ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("test", null, "", "a131", "m001"), "Résultat 0 car date null");
    }

    @Test
    void creerVisiteDateFormatKo() {
        System.out.println("--------------------------- creerVisiteDateFormatKo ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("test", "06-06-1996", "", "a131", "m001"), "Résultat 0 car date au mauvais format");
    }

    @Test
    void creerVisiteMatriNull() {
        System.out.println("--------------------------- creerVisiteMatriNull ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("test", "06/06/1996", "", null, "m001"), "Résultat 0 car matricule null");
    }

    @Test
    void creerVisiteMatri5Carac() {
        System.out.println("--------------------------- creerVisiteMatri5Carac ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("test", "06/06/1996", "", "AAAAA", "m001"), "Résultat 0 car matricule trop long");
    }

    @Test
    void creerVisiteMatriKO() {
        System.out.println("--------------------------- creerVisiteMatriKO ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("test", "06/06/1996", "", "BBBB", "m001"), "Résultat 0 car le matricule visiteur n'existe pas");
    }

    @Test
    void creerVisiteCodeMedNull() {
        System.out.println("--------------------------- creerVisiteCodeMedNull ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("test", "06/06/1996", "", "a131", null), "Résultat 0 car le code medecin null");
    }

    @Test
    void creerVisiteCodeMed5Carac() {
        System.out.println("--------------------------- creerVisiteCodeMed5Carac ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("test", "06/06/1996", "", "a131", "AAAAA"), "Résultat 0 car le code medecin trop long");
    }

    @Test
    void creerVisiteCodeMedKO() {
        System.out.println("--------------------------- creerVisiteCodeMedKO ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.creerVisite("test", "06/06/1996", "", "a131", "BBBB"), "Résultat 0 car le code medecin non existant");
    }

    @Test
    void creerVisiteOK() {
        System.out.println("--------------------------- creerVisiteOK ---------------------------------");
        Assertions.assertEquals(1, uneVisiteService.creerVisite("test", "06/06/1996", "", "a131", "m001"), "Résultat 1 car les paramètres sont corrects");
    }

    @Test
    void supprimerVisiteRefNull() {
        System.out.println("--------------------------- supprimerVisiteRefNull ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.supprimerVisite(null), "Résultat 0 car référence null");
    }

    @Test
    void suppprimerVisiteRef6Carac() {
        System.out.println("--------------------------- suppprimerVisiteRef6Carac ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.supprimerVisite("AAAAAA"), "Résultat 0 car référence trop longue");
    }

    @Test
    void suppprimerVisiteRefKo() {
        System.out.println("--------------------------- suppprimerVisiteRefKo ---------------------------------");
        Assertions.assertEquals(0, uneVisiteService.supprimerVisite("test"), "Résultat 0 car référence non existante");
    }

    @Test
    void suppprimerVisiteRefOk() {
        System.out.println("--------------------------- suppprimerVisiteRefOk ---------------------------------");
        uneVisiteService.creerVisite("test", "06/06/1996", "", "a131", "m001");
        Assertions.assertEquals(1, uneVisiteService.supprimerVisite("test"), "Résultat 1 car référence Ok");
    }

    @Test
    void rechercheVisiteDateRefAllNull() {
        System.out.println("--------------------------- rechercheVisiteDateRefAllNull ---------------------------------");
        colVisiteDateRef = new ArrayList<Visite>();
        Assertions.assertEquals(colVisiteDateRef, uneVisiteService.rechercheVisiteDateRef(null,null), "Résultat vide car reference et date null");
    }

    @Test
    void rechercheVisiteDateRefDateNull() {
        System.out.println("--------------------------- rechercheVisiteDateRefDateNull ---------------------------------");
        colVisiteDateRef = new ArrayList<Visite>();
        Assertions.assertEquals(colVisiteDateRef, uneVisiteService.rechercheVisiteDateRef(null,"v0001"), "Résultat vide car date null");
    }

    @Test
    void rechercheVisiteDateRefRefNull() {
        System.out.println("--------------------------- rechercheVisiteDateRefRefNull ---------------------------------");
        colVisiteDateRef = new ArrayList<Visite>();
        Assertions.assertEquals(colVisiteDateRef, uneVisiteService.rechercheVisiteDateRef("06/06/1996",null), "Résultat vide car ref null");
    }

    @Test
    void rechercheVisiteDateRefDateKo() {
        System.out.println("--------------------------- rechercheVisiteDateRefDateKo ---------------------------------");
        colVisiteDateRef = new ArrayList<Visite>();
        Assertions.assertEquals(colVisiteDateRef, uneVisiteService.rechercheVisiteDateRef("06-06-1996","v0001"), "Résultat vide car mauvais format date");
    }

    @Test
    void rechercheVisiteDateRefRef6Carac() {
        System.out.println("--------------------------- rechercheVisiteDateRefRef5Carac ---------------------------------");
        colVisiteDateRef = new ArrayList<Visite>();
        Assertions.assertEquals(colVisiteDateRef, uneVisiteService.rechercheVisiteDateRef("06/06/1996","v00066"), "Résultat vide car ref trop longue");
    }

    @Test
    void rechercheVisiteDateRefRefKo() {
        System.out.println("--------------------------- rechercheVisiteDateRefRefKo ---------------------------------");
        colVisiteDateRef = new ArrayList<Visite>();
        Assertions.assertEquals(colVisiteDateRef, uneVisiteService.rechercheVisiteDateRef("06/06/1996","v099"), "Résultat vide car mauvaise ref");
    }

    @Test
    void rechercheVisiteDateRefOk() {
        System.out.println("--------------------------- rechercheVisiteDateRefOk ---------------------------------");
        colVisiteDateRef = uneVisiteService.rechercheVisiteDateRef("20/01/2002","v0001");
        int nbElementsAttendus = 1; //Nombre de visite ce jour-là pour le visiteur

        Assertions.assertEquals(nbElementsAttendus, colVisiteDateRef.size(), "Un élément correspondant donc résultat ok");
        for(Visite uneVisite : colVisiteDateRef) {
            if(uneVisite.getReference().equals("v0001")) {
                System.out.println("Référence : " + uneVisite.getReference());
                System.out.println("Date : " + uneVisite.getDateVisite());
                System.out.println("Commentaire : " + uneVisite.getUnCommentaire());
                System.out.println("Matricule Médecin : " + uneVisite.getUnVisiteur().getMatricule());
                System.out.println("Code Médecin : " + uneVisite.getUnMedecin().getCodeMed());
            }
        }
    }


}