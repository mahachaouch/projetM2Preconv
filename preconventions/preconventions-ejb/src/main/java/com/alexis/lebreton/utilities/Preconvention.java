/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexis.lebreton.utilities;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author ben
 */


public class Preconvention implements Serializable{
    

    private int refConv;
    private Etudiant etudiant;
    private String diplome;
    private int entreprise;
    private int assurance;
    private float gratification;
    private Date debut;
    private Date fin;
    private String sujetStage;    
    private ReponseTraitPrec RepJur;
    private ReponseTraitPrec RepEn;
    private ReponseTraitPrec RepSco;

    public Preconvention(int refConv, Etudiant etudiant, String d, int e, int a, float gratification, Date debut, Date fin, String sujetStage) {
        this.refConv = refConv;
        this.etudiant = etudiant;
        this.diplome = d;
        this.entreprise = e;
        this.assurance = a;
        this.gratification = gratification;
        this.debut = debut;
        this.fin = fin;
        this.sujetStage = sujetStage;
        this.RepJur = new ReponseTraitPrec(false,"");
        this.RepEn = new ReponseTraitPrec(false,"");
        this.RepSco = new ReponseTraitPrec(false,"");
    }

    public void setRepJur(ReponseTraitPrec RepJur) {
        this.RepJur = RepJur;
    }

    public void setRepEn(ReponseTraitPrec RepEn) {
        this.RepEn = RepEn;
    }

    public void setRepSco(ReponseTraitPrec RepSco) {
        this.RepSco = RepSco;
    }

    public ReponseTraitPrec getRepJur() {
        return RepJur;
    }

    public ReponseTraitPrec getRepEn() {
        return RepEn;
    }

    public ReponseTraitPrec getRepSco() {
        return RepSco;
    }

    public int getRefConv() {
        return refConv;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public String getDiplome() {
        return diplome;
    }

    public int getEntreprise() {
        return entreprise;
    }

    public int getAssurance() {
        return assurance;
    }

    public float getGratification() {
        return gratification;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }

    public String getSujetStage() {
        return sujetStage;
    }

    public void setRefConv(int refConv) {
        this.refConv = refConv;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setDiplome(String d) {
        this.diplome = d;
    }

    public void setEntreprise(int e) {
        this.entreprise = e;
    }

    public void setAssurance(int a) {
        this.assurance = a;
    }

    public void setGratification(float gratification) {
        this.gratification = gratification;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setSujetStage(String sujetStage) {
        this.sujetStage = sujetStage;
    }

    
 
}
