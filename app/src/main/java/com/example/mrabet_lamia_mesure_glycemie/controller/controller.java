package com.example.mrabet_lamia_mesure_glycemie.controller;
import com.example.mrabet_lamia_mesure_glycemie.modele.patient;
public class controller {
    private static controller instance = null;
    private static patient patient;
    private controller(){
        super();
    }
    public static final controller getInstance(){
        if(controller.instance == null)
            controller.instance = new controller();
            return controller.instance;
    }
    public void create_patient(int age ,float valeurMesuree , boolean isFasting){
        patient = new patient(isFasting, age, valeurMesuree);
    }
    public String getResult(){
        return patient.getR();//update patient to controller
    }

}
