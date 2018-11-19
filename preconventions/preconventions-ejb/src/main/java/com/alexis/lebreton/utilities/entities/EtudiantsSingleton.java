/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexis.lebreton.utilities.entities;

import com.alexis.lebreton.utilities.Etudiant;
import java.util.HashMap;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author maha-
 */

@Singleton
@LocalBean
public class EtudiantsSingleton {
    
    private HashMap<Integer, Etudiant> etds = new HashMap<>();;
    
        public Etudiant ajouterEtudiant(String nom,String prenom,Integer n) {
        Etudiant et= new Etudiant(nom,prenom,n);
        etds.put(n,et);
        return et;
    }
    
        /*
            permet de vérifier si l'étudiant existe, et donc un num etudiant valide
        */
    public Boolean exists(Integer numE){
        return etds.containsKey(numE);
    }    
    
    public Etudiant getEtudiant(Integer numE){
        return etds.get(numE);
    }
    
}
