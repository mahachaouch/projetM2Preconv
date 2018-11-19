/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexis.lebreton.utilities.entities;

import com.alexis.lebreton.utilities.Etudiant;
import com.alexis.lebreton.utilities.Preconvention;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.ObjectMessage;
import javax.jms.Topic;

/**
 *
 * @author ben
 */
@Singleton
@LocalBean
public class PreconventionSingleton {
        @Resource(lookup = "jms/PreconventionDeposee")
    private Topic topic;
    
    @Inject
    private JMSContext context;
    
    private HashMap<Integer, Preconvention> preconvs;
    private Integer lastid=0;
    
     public Preconvention ajouterPreConvention(int etudiant, String d, int e, int a, float gratification, Date debut, Date fin, String sujetStage) {      
        Preconvention prec = new Preconvention(lastid, etudiant, d, e, a,  gratification,  debut,  fin,  sujetStage);
        this.preconvs.put(lastid, prec);
       // deposerPreconv(lastid);
        this.lastid ++;        
        return prec;
    }

    public Preconvention validerEnseignement(int refPreConv, boolean v) {
      //  this.preconvs.get(refPreConv).setValidE(v);
        return this.preconvs.get(refPreConv);
    }

    public Preconvention validerJuridique(int refPreConv, boolean v) {
      //  this.preconvs.get(refPreConv).setValidJ(v);
        return this.preconvs.get(refPreConv);
    }

    public Preconvention validerScolarite(int refPreConv, boolean v) {
       // this.preconvs.get(refPreConv).setValidS(v);
        return this.preconvs.get(refPreConv);
    }

        public void validerEns(int refPreconv,boolean b) {
        Preconvention prec = preconvs.get(refPreconv);
        prec.getRepEn().setValRep(b);
    }
    
    
    public Preconvention getPrevention(int refPreconv) {
        return this.preconvs.get(refPreconv);
    }

    public Etudiant getEtudiant(int refPreconv) {
       int numEtud = this.preconvs.get(refPreconv).getEtudiant();
       return   Etudiant.getEtudiantById(numEtud);
    }

    //sert à déposer sur le topic
    public Preconvention deposerPreconv(int refPrec) {
        Preconvention prec = preconvs.get(refPrec);
        //ObjectMessage om = context.createObjectMessage(prec);
        context.createProducer().send(topic, prec);
        return prec;
    }
}
