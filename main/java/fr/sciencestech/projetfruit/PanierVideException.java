/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sciencestech.projetfruit;

/**
 *
 * @author roudet
 */
public class PanierVideException extends Exception {
    public PanierVideException()
    {
	super("Impossible de supprimer une orange dans le panier qui est vide !");
    }
}
