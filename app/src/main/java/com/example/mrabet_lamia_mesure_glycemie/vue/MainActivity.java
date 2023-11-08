package com.example.mrabet_lamia_mesure_glycemie.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrabet_lamia_mesure_glycemie.R;

public class MainActivity extends AppCompatActivity {

    private EditText v;
    private TextView txt, r;
    private SeekBar sb;
    private RadioButton rbOui;
    private RadioButton rbNon;
    private Button b;
    private void init(){
        v = findViewById(R.id.sbValeur);
        txt = findViewById(R.id.tvAge);
        sb = findViewById(R.id.sbAge);
        rbOui = findViewById(R.id.rbtOui);
        rbNon = findViewById(R.id.rbtNon);
        b = findViewById(R.id.btnConsulter);
        r = findViewById(R.id.tvReponse);
    }
    public void calculer (View vw) {

        Log.i("Information", "button cliqué");
        int age;
        float valeurMesuree;
        boolean verifAge = false, verifValeur = false;
        if(sb.getProgress()!=0)
            verifAge = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre age !",
                    Toast.LENGTH_SHORT).show();
        if(!v.getText().toString().isEmpty())
            verifValeur = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !",
                    Toast.LENGTH_LONG).show();
        if(verifAge && verifValeur)
        {
            age = sb.getProgress();
            valeurMesuree = Float.valueOf(v.getText().toString());
            boolean isFasting = rbNon.isChecked();
            if (isFasting) {
                if (age >= 13) {
                    if (valeurMesuree < 5.0)
                        r.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                        r.setText("Niveau de glycémie est normale");
                    else
                        r.setText("Niveau de glycémie est trop élevé");
                } else if (age >= 6 && age <= 12) {
                    if (valeurMesuree < 5.0)
                        r.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                        r.setText("Niveau de glycémie est normale");
                    else
                        r.setText("Niveau de glycémie est trop élevé");
                } else if (age < 6) {
                    if (valeurMesuree < 5.5)
                        r.setText("Niveau de glycémie est trop bas");
                    else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                        r.setText("Niveau de glycémie est normale");
                    else
                        r.setText("Niveau de glycémie est trop élevé");
                }
            } else {
                if (valeurMesuree > 10.5)
                    r.setText("Niveau de glycémie est trop élevé");
                else
                    r.setText("Niveau de glycémie est normale");
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            public void onProgressChanged(SeekBar sb, int progress, boolean fromUser)
            {
                Log.i("Information", "onProgressChanged "+progress);
                // affichage dans le Log de Android studio pour voir les changements détectés sur le SeekBar ..
                txt.setText("Votre âge : "+ progress);
                // Mise à jour du TextView par la valeur : progress à chaque changement.
            }
            public void onStartTrackingTouch(SeekBar sb) {}
            public void onStopTrackingTouch(SeekBar sb) {}
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer(v);
            }
        });

    }






}