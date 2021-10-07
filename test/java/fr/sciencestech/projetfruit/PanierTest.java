/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sciencestech.projetfruit;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.mockito.Mockito.*;

/**
 *
 * @author celine
 */
public class PanierTest {
    Panier p0, p2, p2plein, p3, p4;
    Fruit o1, o2, o3;
    Fruit a1, a2;
    Fruit mocko1, mocko2;
    
    public PanierTest() {
    }
    
    @Before
    public void setUp() throws PanierPleinException {
        p0 = new Panier(0);
        p2 = new Panier(2);
        p2plein = new Panier(2);
        
        p3 = new Panier(3);
        p4 = new Panier(4);

	o1 = new Orange(0.50, "France");
	o2 = new Orange(0.60, "Espagne");
	o3 = new Orange(0.70, "USA");
        
        a1 = new Ananas(1.0, "France");
	a2 = new Ananas(1.5, "Espagne");
        
        p2plein.ajoute();
        p2plein.ajoute();

        mocko1 = mock(Fruit.class);
        mocko2 = mock(Fruit.class);
        
        when(mocko1.getPrix()).thenReturn(1.0);   //comportement des doublures (stubbing)
        when(mocko2.getPrix()).thenReturn(0.5); 
    }

    //Mocks :
    //Attention, on ne peut pas mocker les méthodes equals, hashCode, toString, 
    //une classe ou une méthode final, une méthode statique ou privée
    @Ignore
    public void testGetPrixMock() throws PanierPleinException, PanierVideException {
        System.out.println("GetPrix Mock");
        
        Panier panier = new Panier(3);
        panier.ajoute(mocko1);
        panier.ajoute(mocko2);
        double res = panier.getPrix();

        //tests d’interaction :
        verify(mocko1, times(1)).getPrix();    //getPrix() doit avoir été appelé exactement 1 fois
        verify(mocko2, times(1)).getPrix();
        assertTrue(res == 1.5);
        
        panier.retire();
        res = panier.getPrix();
        //tests d’interaction :
        verify(mocko1, times(2)).getPrix();    //getPrix() doit avoir été appelé exactement 2 fois
        verify(mocko2, times(1)).getPrix();
        assertTrue(res == 1.0);
    }

/**
     * Test of ajoute method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testAddValideMock() throws PanierPleinException {
        System.out.println("add Valide Mock");
   
        //p4 : panier vide
	assertTrue(p4.getTaille() == 0);
        p4.ajoute(mocko1);
        assertTrue(p4.getTaille() == 1);
        p4.ajoute(mocko2);
        assertTrue(p4.getTaille() == 2);
    }
    
    /**
     * Test of ajoute method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test(expected=PanierPleinException.class)
    public void testAddInvalideMock() throws PanierPleinException {
        System.out.println("add Invalide Mock");
        
        //test avec un panier deja plein
	p2plein.ajoute(mocko1);
    }
    
    /**
     * Test of getPrice method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testGetPrix() throws PanierPleinException {
        System.out.println("getPrix");
        //panier vide
        double expResult = 0.0;
        double result = p3.getPrix();
        assertTrue(expResult == result);

        //panier à un element à 0.50
        p3.ajoute(o1);
        double expResult2 = 0.50;
        double result2 = p3.getPrix();
        assertTrue(expResult2 == result2);
        
        //panier ou il reste une place
        p3.ajoute(o1);
        double expResult3 = 0.50*2;
        double result3 = p3.getPrix();
        assertTrue(expResult3 == result3);
        
        //panier plein
        p3.ajoute(o1);
        double expResult4 = 0.5*3;
        double result4 = p3.getPrix();
        assertTrue(expResult4 == result4);
        
    }

    /**
     * Test of getTaille method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testGetTaille() throws PanierPleinException {
        System.out.println("getSize");
        //panier sans place
        int expResult = 0;
        int result = p0.getTaille();
        assertTrue(expResult == result);
        
        //panier avec place
        int expResult2 = 0;
        int result2 = p2.getTaille();
        assertTrue(expResult2 == result2);
        
        //panier avec place et a 1 element
        p2.ajoute();
        int expResult3 = 1;
        int result3 = p2.getTaille();
        assertTrue(expResult3 == result3);
        
        //panier avec place et plein
        p2.ajoute();
        int expResult4 = 2;
        int result4 = p2.getTaille();
        assertTrue(expResult4 == result4);
    }
    
    /**
     * Test of getOranges method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testGetOranges() throws PanierPleinException {
        System.out.println("getOranges");
        
        //test dans un panier vide
        Fruit expResult = null;
        Fruit result = p2.getFruits(0);
        Fruit result2 = p2.getFruits(-1);
        Fruit result3 = p2.getFruits(1);
        assertEquals(expResult, result);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
        
        //test dans un panier plein
        Fruit expResult4 = new Orange();
        Fruit result4 = p2plein.getFruits(0);
        Fruit result5 = p2plein.getFruits(1);
        assertEquals(expResult4, result4);
        assertEquals(expResult4, result5);
    }
    
    /**
     * Test of getContMax method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testGetContMax() throws PanierPleinException {
        System.out.println("getContMax");
        
        //panier sans place
        int expResult = 0;
        int result = p0.getContMax();
        assertTrue(expResult == result);
        
        //panier vide avec place
        int expResult2 = 2;
        int result2 = p2.getContMax();
        assertTrue(expResult2 == result2);
        
        //panier a 1 element avec place
        p2.ajoute();
        int expResult3 = 2;
        int result3 = p2.getContMax();
        assertTrue(expResult3 == result3);
    }
    
     /**
     * Test of setFruit method, of class Panier.
     */
    @Test
    public void testSetFruit() {
        System.out.println("setFruit");
        
        ArrayList<Fruit> fruitsvide = new ArrayList<>(4);
        p2.setFruits(fruitsvide);
        assertTrue(p2.estVide());
    }

    /**
     * Test of estVide method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testEstVide() throws PanierPleinException {
        System.out.println("estVide");
        
        //test d'un panier vide
        boolean expResult = true;
        boolean result = p2.estVide();
        assertTrue(expResult == result);
        
        //test d'un panier non vide
        p2.ajoute();
        boolean expResult2 = false;
        boolean result2 = p2.estVide();
        assertTrue(expResult2 == result2);
        
        //test d'un panier plein
        p2.ajoute();
        boolean expResult3 = false;
        boolean result3 = p2.estVide();
        assertTrue(expResult3 == result3);
    }

    /**
     * Test of estPlein method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testEstPlein() throws PanierPleinException {
        System.out.println("estPlein");
        
        //test d'un panier vide
        boolean expResult = false;
        boolean result = p2.estPlein();
        assertTrue(expResult == result);
        
        //test d'un panier non vide
        p2.ajoute();
        boolean expResult2 = false;
        boolean result2 = p2.estPlein();
        assertTrue(expResult2 == result2);
        
        //test d'un panier plein
        p2.ajoute();
        boolean expResult3 = true;
        boolean result3 = p2.estPlein();
        assertTrue(expResult3 == result3);
    }

    /**
     * Test of ajoute method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testAddValide_0args() throws PanierPleinException {
        System.out.println("addOargsValide");
   
        //panier vide
	assertTrue(p4.getTaille() == 0);
        
        //test d'ajout de null
        p4.ajoute(null);  
        assertTrue(p4.getTaille() == 0);
		
	//test avec panier à une orange
	p4.ajoute(o1);  //1 orange
	assertTrue(p4.getTaille() == 1);
		
	//test avec un panier où il reste une place
	p4.ajoute(o1);  //2 oranges
	p4.ajoute(o1);	//3 oranges
	assertEquals(p4.getTaille(), p4.getContMax()-1);
		
	//test que le panier est plein
	p4.ajoute(o1);	//4 oranges
	assertEquals(p4.getTaille(), p4.getContMax());
    }
    
    /**
     * Test of ajoute method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test(expected=PanierPleinException.class)
    public void testAddInvalide_0args() throws PanierPleinException {
        System.out.println("addOargsInvalide");
        
        //test avec un panier deja plein
	p2plein.ajoute(o1);
    }

    /**
     * Test of ajoute method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testAddValide_Orange() throws PanierPleinException {
        System.out.println("addOrangeValide");
        
        //test avec panier vide
	assertTrue(p4.getTaille() == 0);
		
	//test avec panier à une orange
	p4.ajoute();  //1 orange
	assertTrue(p4.getTaille() == 1);
		
	//test avec un panier où il reste une place
	p4.ajoute();  //2 oranges
	p4.ajoute();	//3 oranges
	assertEquals(p4.getTaille(), p4.getContMax()-1);
		
	//test que le panier est plein
	p4.ajoute();	//4 oranges
	assertEquals(p4.getTaille(), p4.getContMax());
		
    }
    
    /**
     * Test of ajoute method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test(expected=PanierPleinException.class)
    public void testAddInvalide_Orange() throws PanierPleinException {
        System.out.println("addOrangeInvalide");
	//test avec un panier deja plein
	p2plein.ajoute();		
    }

    /**
     * Test of retire method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierVideException
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testRemoveValide() throws PanierVideException, PanierPleinException {
        System.out.println("remove");

        //test avec panier à une orange
	p4.ajoute();   //1 orange
        p4.retire(); 
	assertTrue(p4.getTaille() == 0);
		
	//test avec un panier plein
	p4.ajoute();  //1 orange
        p4.ajoute();   //2 oranges
	p4.ajoute();	//3 oranges
        p4.ajoute();	//4 oranges
        p4.retire();
	assertEquals(p4.getTaille(), p4.getContMax()-1);
    }
    
    /**
     * Test of retire method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierVideException
     */
    @Test(expected=PanierVideException.class)
    public void testRemoveInvalide() throws PanierVideException {
        System.out.println("remove");
        p4.retire();
    }

    /**
     * Test of boycotteOrigine method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testBoycotteOrigine() throws PanierPleinException {
        System.out.println("boycottOrigin");
        //mock
        Fruit mocko1 = mock(Fruit.class);
        Fruit mocko2 = mock(Fruit.class);
        
        when(mocko1.getOrigine()).thenReturn("France");   //comportement des doublures (stubbing)
        when(mocko2.getOrigine()).thenReturn("Espagne"); 

        Panier panier = new Panier(3);
        panier.ajoute(mocko1);
        panier.ajoute(mocko2);
        panier.boycotteOrigine("Espagne");

        //tests d’interaction :
        verify(mocko1, times(1)).getOrigine();    //getCountry() doit avoir été appelé exactement 1 fois
        verify(mocko2, times(1)).getOrigine();
        assertTrue(panier.getTaille() == 1);
        
        
        //DT chemin limite :
	p4.boycotteOrigine("France");  //aucun passage dans le while
	assertTrue(p4.estVide());
		
	//DT 2-chemin
	p4.ajoute(o1);
	p4.ajoute(o2);
	assertTrue(p4.getTaille() == 2);
	p4.boycotteOrigine("USA");  //2 passages dans le while et aucun retrait (car aucune orange du pays boycotté)
	assertTrue(p4.getTaille() == 2);
		
	assertEquals(p4.getFruits(0).getOrigine(), "France");
	p4.boycotteOrigine("France");  //2 passages dans le while et 1 retrait (car 1 orange du pays boycotté)
	assertTrue(p4.getTaille() == 1);
		
	//DT 1-chemin
	assertEquals(p4.getFruits(0).getOrigine(), "Espagne");
	p4.boycotteOrigine("France");  //1 passage dans le while et 0 retrait : DT2
	assertTrue(p4.getTaille() == 1); 
		
	p4.boycotteOrigine("Espagne");  //1 passage dans le while et 1 retrait (car 1 orange du pays boycotté) : DT1
	assertTrue(p4.estVide()); 
        
        //DT 3-chemin avec 2 fois le pays boycotté
        p4.ajoute(o1);
        p4.ajoute(o2);
        p4.ajoute(o1);
        assertTrue(p4.getTaille() == 3);
        p4.boycotteOrigine("France");  //3 passages dans le while et 2 retrait (car 2 oranges du pays boycotté)
	assertTrue(p4.getTaille() == 1);
        
        //DT 4-chemin avec 3 fois le pays boycotté, car il reste une o2
        p4.ajoute(o1);
        p4.ajoute(o1);
        p4.ajoute(o1);
        assertTrue(p4.getTaille() == 4);
        p4.boycotteOrigine("France");  //4 passages dans le while et 3 retrait (car 3 oranges du pays boycotté)
	assertTrue(p4.getTaille() == 1);
    }

    /**
     * Test of toString method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testToString() throws PanierPleinException {
        System.out.println("toString");
 
        //test panier vide
        String expResultvide = "[]";
        String resultvide = p2.toString();
        assertEquals(expResultvide, resultvide);
        
        //test panier à 1 element
        p2.ajoute(o2);
        String expResult = "[Orange]";
        String result = p2.toString();
        assertEquals(expResult, result);
        
        //test panier plein
        p4.ajoute(o1);
        p4.ajoute(a2);
        String expResult2 = "[Orange, Ananas]";
        String result2 = p4.toString();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of equals method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     * @throws fr.ufrsciencestech.panier.PanierVideException
     */
    @Test
    public void testEquals() throws PanierPleinException, PanierVideException {
        System.out.println("equals");
        
        //test avec null
        Panier pnull = null;
        assertFalse(p2.equals(pnull));
        
        //tests de 2 paniers vides
        assertTrue(p2.getTaille() == p4.getTaille());
        assertTrue(p2.equals(p4));
        
        //test de 2 paniers avec 1 meme element 
        p2.ajoute(o1);
        p4.ajoute(o1);
        assertTrue(p2.getTaille() == p4.getTaille());
        assertTrue(p2.equals(p4));
    
        //test de 2 paniers avec les 3 memes elements 
        p3.ajoute(o1);
        p3.ajoute(o1);
        p3.ajoute(o2);
            
        p4.ajoute(o1);
        p4.ajoute(o2);
        assertTrue(p3.getTaille() == p4.getTaille());
        assertTrue(p3.equals(p4));
        
        //test de 2 paniers avec le meme nb mais pas les memes oranges
        p3.retire();
        p3.ajoute(o3);
        assertTrue(p3.getTaille() == p4.getTaille());
        assertFalse(p3.equals(p4));
        
        //test de 2 paniers avec le meme nb mais pas les memes oranges
        p3.retire();
        p3.ajoute(new Orange(0.60, "France"));
        assertTrue(p3.getTaille() == p4.getTaille());
        assertFalse(p3.equals(p4));
        
        //test de 2 paniers avec le meme nb mais pas les memes oranges
        p3.retire();
        p3.ajoute(new Orange(0.80, "Espagne"));
        assertTrue(p3.getTaille() == p4.getTaille());
        assertFalse(p3.equals(p4));
        
        //test de 2 paniers ayant un nb différents d'elements
        p4.ajoute(o2);
        assertTrue(p2.getTaille() != p4.getTaille());
        assertFalse(p2.equals(p4));
    }
    
     /**
     * Test of nbFruits method, of class Panier.
     * @throws fr.ufrsciencestech.panier.PanierPleinException
     */
    @Test
    public void testNbFruits() throws PanierPleinException{
        System.out.println("nbFruits");

        p4.ajoute(o1);
        p4.ajoute(a1);
        p4.ajoute(o2);
        p4.ajoute(a2);
        int expOranges = 1;
        int expAnanas = 1;
        int resultOranges = p4.nbFruits(o1);
        int resultAnanas = p4.nbFruits(a1);
        assertTrue(expOranges==resultOranges);
        assertTrue(expAnanas==resultAnanas);
    }
}
