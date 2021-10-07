/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sciencestech.projetfruit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roudet
 */
public class OrangeTest {

    /**
     *
     */
    @Before
    public void setUp(){
    }

    @Test
    public void testPrixNegatif() {
        System.out.println("prix negatif");
        Orange instance = new Orange(-1.0,"Espagne");
        double expResult = 1.0;
        double result = instance.getPrix();
        assertTrue(expResult == result);
    }
    
    @Test
    public void testChaineVide() {
        System.out.println("chaine vide");
        Orange instance = new Orange(1.0,"");
        String expResult = "Espagne";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Orange.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Orange instance = new Orange();
        String expResult = "Orange de Espagne coutant 0.5 euros";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetOrigine() {
        System.out.println("getOrigine");
        Orange instance = new Orange(1.0,"");
        String expResult = "Espagne";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetCountry() {
        System.out.println("setOrigine");
        Orange instance = new Orange(1.0,"");
        String expResult = "France";
        instance.setOrigine("France");
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPrix() {
        System.out.println("getPrix");
        Orange instance = new Orange(2.0,"France");
        double expResult = 2.0;
        double result = instance.getPrix();
        assertTrue(expResult == result);
    }
    
    @Test
    public void testSetPrix() {
        System.out.println("setPrix");
        Orange instance = new Orange(1.0,"");
        double expResult = 0.7;
        instance.setPrix(0.7);
        double result = instance.getPrix();
        assertTrue(expResult == result);
    }
    
    /**
     * Test of isSeedless method, of class Orange.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Orange instanceavecpepins = new Orange();
        boolean expResult1 = false;
        boolean result1 = instanceavecpepins.isSeedless();
        assertTrue(expResult1 == result1);
    }
}
