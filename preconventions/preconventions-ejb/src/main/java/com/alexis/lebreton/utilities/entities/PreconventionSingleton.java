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
import javax.jms.Queue;
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
    
    @Resource(lookup="jms/GestionnairePreconventions")
    private Queue queue;
    
    @Inject
    private JMSContext context;
    
    private HashMap<Integer, Preconvention> preconvs = new HashMap<>();
    private Integer lastid=0;
    
     public Preconvention ajouterPreConvention(Etudiant etudiant, String d, int e, int a, float gratification, Date debut, Date fin, String sujetStage) {      
        Preconvention prec = new Preconvention(lastid, etudiant, d, e, a,  gratification,  debut,  fin,  sujetStage);
        this.preconvs.put(lastid, prec);
       // deposerPreconv(lastid);
        this.lastid ++;        
        return prec;
    }

    public Preconvention validerJuridique(int refPreConv, boolean v,String cause) {
        Preconvention prec = preconvs.get(refPreConv);
        prec.getRepJur().setValRep(v);
        prec.getRepJur().setCauseRep(cause);      
        context.createProducer().send(queue, prec);
        return prec;
    }

    public Preconvention validerScolarite(int refPreConv, boolean v,String cause) {
        Preconvention prec = preconvs.get(refPreConv);
        prec.getRepSco().setValRep(v);
        prec.getRepSco().setCauseRep(cause);
        context.createProducer().send(queue, prec);
        return prec;
    }

        public Preconvention validerEnseignement(int refPreconv,boolean b, String cause) {
        Preconvention prec = preconvs.get(refPreconv);
        prec.getRepEn().setValRep(b);
        prec.getRepEn().setCauseRep(cause);
        context.createProducer().send(queue, prec);
        return prec;
    }
    
    
    public Preconvention getPrevention(int refPreconv) {
        return this.preconvs.get(refPreconv);
    }

    public Etudiant getEtudiant(int refPreconv) {
       return this.preconvs.get(refPreconv).getEtudiant();
    }

    public HashMap<Integer,Preconvention> getAll(){
        return this.preconvs;
    }
    //sert à déposer une preconvention sur le topic dédié au dépot de demande préconventions
    public Preconvention deposerPreconv(int refPrec) {
        Preconvention prec = preconvs.get(refPrec);
        //ObjectMessage om = context.createObjectMessage(prec);
        context.createProducer().send(topic, prec);
        return prec;
    }
}
