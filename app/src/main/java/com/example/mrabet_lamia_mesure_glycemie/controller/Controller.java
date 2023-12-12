package com.example.mrabet_lamia_mesure_glycemie.controller;
import com.example.mrabet_lamia_mesure_glycemie.modele.patient;
public class Controller {
    private static Controller instance = null;
    private static patient patient;
    private Controller(){
        super();
    }
    public static final Controller getInstance(){
        if(Controller.instance ==null){
            Controller.instance = new Controller();
        }
        return Controller.instance;
    }
    public void createPatient(int age, float valeurMesuree, boolean isFasting){
        patient = new patient(isFasting, age, valeurMesuree);
    }

    public String getReponse() {
        return patient.getR();
    }

    public static patient getPatient() {
        return patient;
    }
}