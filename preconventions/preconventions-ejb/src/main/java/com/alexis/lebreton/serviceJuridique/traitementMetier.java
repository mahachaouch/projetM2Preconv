/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexis.lebreton.serviceJuridique;

import com.alexis.lebreton.utilities.Preconvention;
import com.alexis.lebreton.utilities.entities.PreconventionSingleton;

/**
 *
 * @author maha-
 */
public class traitementMetier {
    
    public PreconventionSingleton ps;
    /*
    vérifie si la durée du stage ne dépasse pas 6 mois et que le stage ne se déroule pas sur 2 annes uiv.
    */
        public static Boolean periodeStageOK(Preconvention p){
        long duree = p.getDuréeStage();
        int an1 = p.getDebut().getYear();        
        int an2 = p.getFin().getYear();
        return duree < 7  && an1==an2;
    }
    
        /*
        on suppose  la seule règle à vérifier et que l'entreprise doit payer l'etudiant si la durée de stage dépasse deux mois
        */
    public static Boolean gratificationOK(Preconvention p){
       return p.getDuréeStage() > 2 && p.getGratification()>0 ;
    }
    
    public Preconvention validationJuridique(Preconvention p){
      //  validerJuridique(int refPreConv, boolean v,String cause)
      Boolean validEntreprise = verificationsEntreprise.getSIREN(p.getEntreprise().toString())=="";
      Boolean finV = periodeStageOK(p) && gratificationOK(p)&& validEntreprise;
      return ps.validerJuridique(p.getRefConv(), finV, "");
      
    }
}

