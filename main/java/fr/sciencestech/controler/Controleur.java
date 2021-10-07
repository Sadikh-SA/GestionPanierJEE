package fr.sciencestech.controler;


import fr.sciencestech.projetfruit.Panier;
import fr.sciencestech.projetfruit.PanierPleinException;
import fr.sciencestech.projetfruit.PanierVideException;
import fr.sciencestech.view.VueGraphique;
import java.awt.*;
import java.awt.event.*;import java.util.logging.Level;
import java.util.logging.Logger;
;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ag425107
 */
public class Controleur implements ActionListener {
    private Panier panier;
    private VueGraphique vg;
    
    @Override
    public void actionPerformed(ActionEvent e){   //Invoked when an action occurs
        if(((Component)e.getSource()).getName().equals("Plus")) 
            try {
                panier.ajoute();
            } catch (PanierPleinException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        else
            try {
                panier.retire();
            } catch (PanierVideException ex) {
                Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void setModele(Panier m){
        this.panier = m;
    }
    public void setVue(VueGraphique vg){
        this.vg = vg;
    }
}
