/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexis.lebreton.serviceScolarite;


import com.alexis.lebreton.utilities.Preconvention;
import com.alexis.lebreton.utilities.entities.EtudiantsSingleton;
import com.alexis.lebreton.utilities.entities.PreconventionSingleton;

/**
 *
 * @author maha-
 */
public class VérificationAdministrative {
    public EtudiantsSingleton etdSingl ;
    public PreconventionSingleton ps;
    
    public Preconvention vérifierEtud(Preconvention p){
        String diplomePrecon= p.getDiplome();
        String diplomeReel = p.getEtudiant().getDipActuel();
        String cause = "";
        Boolean verif = etdSingl.exists(p.getEtudiant().getNumEt())&& diplomePrecon.equals(diplomeReel);
        if(!verif ){
        cause="L etudiant mentionne n existe pas, ou son diplome préparé n est pas valide";
    }        
        return ps.validerScolarite(p.getRefConv(), verif, cause);
    }
}
