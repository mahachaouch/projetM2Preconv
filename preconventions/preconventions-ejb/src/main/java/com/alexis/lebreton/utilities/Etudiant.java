/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexis.lebreton.utilities;

import java.io.Serializable;
import java.util.HashMap;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author ben
 */

public class Etudiant implements Serializable{
     private static HashMap<Integer, Etudiant> etudiants;
    
    private String nom;
    private String prenom;
    private int numEt;
    private String dipActuel;

    public void setDipActuel(String dipActuel) {
        this.dipActuel = dipActuel;
    }

    public String getDipActuel() {
        return dipActuel;
    }

    public Etudiant(String nom, String prenom, int numEt) {
        this.nom = nom;
        this.prenom = prenom;
        this.numEt = numEt;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumEt() {
        return numEt;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumEt(int numEt) {
        this.numEt = numEt;
    }
    
    public static Etudiant getEtudiantById(int numEt){
        return Etudiant.etudiants.get(numEt);
    }
}
