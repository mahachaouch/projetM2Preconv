/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexis.lebreton.utilities.entities;

import com.alexis.lebreton.utilities.Etudiant;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author ben
 */

@Singleton
@LocalBean
public class EtudiantsSingleton {
    
    private final ArrayList<Etudiant> etds = new ArrayList<>();
    
        public Etudiant ajouterEtudiant(Etudiant e) {
        etds.add(e);
        return e;
    }
    
    
}
