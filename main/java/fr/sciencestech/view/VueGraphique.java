/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.sciencestech.view;

import fr.sciencestech.controler.Controleur;
import java.util.*;

/**
 *
 * @author ag425107
 */
public interface VueGraphique extends Observer{
    public void update(Observable m, Object o);
    public void addControleur(Controleur c);
}
