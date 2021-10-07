/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.sciencestech.projetfruit;

import fr.sciencestech.controler.Controleur;
import fr.sciencestech.view.VueConsole;
import fr.sciencestech.view.VueGrapheSwing;
import fr.sciencestech.view.VueGraphique;
import javax.swing.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ag425107
 */
public class Tester {
    private VueGraphique vueg;      //pour pouvoir changer de vue si on le souhaite
    private Controleur controleur;  //pour pouvoir changer de controleur si on le souhaite
    
    /**
     * @return the vueg
     */
    public VueGraphique getVueg() {
        return vueg;
    }

    /**
     * @param vueg the vueg to set
     */
    public void setVueg(VueGraphique vueg) {
        this.vueg = vueg;
    }

    /**
     * @return the controleur
     */
    public Controleur getControleur() {
        return controleur;
    }

    /**
     * @param controleur the controleur to set
     */
    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }
    
    
    public Tester(){
        //sans utiliser SpringIoC :
        vueg = new VueGrapheSwing();
        controleur = new Controleur();
        Panier modele = new Panier(3);
        VueConsole vuec = new VueConsole();

        controleur.setModele(modele);                 
        modele.addObserver(vueg);        
        modele.addObserver(vuec);         
        vueg.addControleur(controleur);
    }
    
    public static void main(String[] args){
        Tester test = new Tester();    //sans utiliser SpringIoC
        
        //La meme chose mais avec SpringIoC :
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        test = (Tester)context.getBean("MVC");  //SpringIoC
        test.setControleur( (Controleur)context.getBean("Controleur") );  //SpringIoC
        test.setVueg( (VueGraphique)context.getBean("Vue") );   //SpringIoC
         
        Panier m = new Panier(3); 
        test.getControleur().setModele(m);  
        
        m.addObserver(test.getVueg());
        test.getVueg().addControleur(test.getControleur());
        
        VueConsole vuec = new VueConsole();
        m.addObserver(vuec);
    }
}
