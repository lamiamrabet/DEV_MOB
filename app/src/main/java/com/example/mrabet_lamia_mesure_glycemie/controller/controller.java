package com.example.mrabet_lamia_mesure_glycemie.controller;
import com.example.mrabet_lamia_mesure_glycemie.modele.patient;
public class controller {
    private static patient patient;
    public controller()
    {
        super();
    }
    public void create_patient(int age ,float valeurMesuree , boolean isFasting){
        patient = new patient(isFasting, age, valeurMesuree);
    }
    public String getResult(){
        return patient.getR();//update patient to controller
    }
}
