/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sciencestech.projetfruit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class AnanasTest {
    
    /**
     *
     */
    @Before
    public void setUp() {
    }

    @Test
    public void testPrixNegatif() {
        System.out.println("prix negatif");
        Ananas instance = new Ananas(-2.0,"Cameroun");
        double expResult = 2.0;
        double result = instance.getPrix();
        assertTrue(expResult == result);
    }
    
    /**
     * Test of constructeur, of class Ananas.
     */
    @Test
    public void testChaineVide() {
        System.out.println("chaine vide");
        Ananas instance = new Ananas(2.0,"");
        String expResult = "Finlande";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        Ananas instance = new Ananas(3.0,"Martinique");
        String expResult = "Martinique";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetCountry() {
        System.out.println("setOrigine");
        Ananas instance = new Ananas(3.0,"");
        String expResult = "Maroc";
        instance.setOrigine("Maroc");
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        Ananas instance = new Ananas(2.0,"");
        double expResult = 2.0;
        double result = instance.getPrix();
        assertTrue(expResult == result);
    }
    
    @Test
    public void testSetPrix() {
        System.out.println("setPrix");
        Ananas instance = new Ananas(1.0,"");
        double expResult = 0.7;
        instance.setPrix(0.7);
        double result = instance.getPrix();
        assertTrue(expResult == result);
    }
    

    /**
     * Test of toString method, of class Ananas.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ananas instance = new Ananas();
        String expResult = "Ananas de Cameroun coutant 0.5 euros";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSeedless method, of class Ananas.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Ananas instance = new Ananas();
        boolean expResult = true;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
    }
}
