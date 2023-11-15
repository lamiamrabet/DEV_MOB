package com.example.mrabet_lamia_mesure_glycemie.modele;


public class patient {
    private boolean isFasting;
    private int age;
    private float valeurMesuree;
    private static String r;

    public patient(boolean isFasting, int age, float valeurMesuree) {
        this.isFasting = isFasting;
        this.age = age;
        this.valeurMesuree = valeurMesuree;
        calculer();
    }

    public void calculer () {

            if (isFasting) {
                if (age >= 13) {
                    if (valeurMesuree < 5.0)
                        r="Niveau de glycémie est trop bas";
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                        r="Niveau de glycémie est normale";
                    else
                        r="Niveau de glycémie est trop élevé";
                } else if (age >= 6 && age <= 12) {
                    if (valeurMesuree < 5.0)
                        r="Niveau de glycémie est trop bas";
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                        r="Niveau de glycémie est normale";
                    else
                        r="Niveau de glycémie est trop élevé";
                } else if (age < 6) {
                    if (valeurMesuree < 5.5)
                        r="Niveau de glycémie est trop bas";
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                        r="Niveau de glycémie est normale";
                    else
                        r="Niveau de glycémie est trop élevé";
                }
            } else {
                if (valeurMesuree > 10.5)
                    r="Niveau de glycémie est trop élevé";
                else
                    r="Niveau de glycémie est normale";
            }
        }

    public boolean isFasting() {
        return isFasting;
    }

    public int getAge() {
        return age;
    }

    public float getValeurMesuree() {
        return valeurMesuree;
    }

    public static String getR() {
        return r;
    }
}


