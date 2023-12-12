package com.example.mrabet_lamia_mesure_glycemie.vue;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mrabet_lamia_mesure_glycemie.R;
import com.example.mrabet_lamia_mesure_glycemie.controller.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 1;
    private EditText etValeur;
    private TextView tvAge;  // tvReponse; pas plus nécessaire
    private SeekBar sbAge;
    private RadioButton rbIsFasting, rbIsNotFasting;
    private Button btnConsulter;

    private Controller controller = Controller.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged "+progress);
                tvAge.setText("Votre âge : "+ progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Information", "button cliqué");

                int age;
                float valeurMesuree;
                boolean verifAge = false, verifValeur = false;

                if(sbAge.getProgress()!=0)
                    verifAge = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre age !", Toast.LENGTH_SHORT).show();

                if(!etValeur.getText().toString().isEmpty())
                    verifValeur = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !", Toast.LENGTH_LONG).show();

                if(verifAge && verifValeur)
                {
                    age = sbAge.getProgress();
                    valeurMesuree = Float.valueOf(etValeur.getText().toString());

                    //Flèche "User action" Vue --> Controller
                    controller.createPatient(age, valeurMesuree, rbIsFasting.isChecked());

                    //Flèche "Update" Controller --> vue

                    Intent intent = new Intent (MainActivity.this, ConsultActivity.class);
                    intent.putExtra("reponse",controller.getReponse());
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE)
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "ERROR : RESULT_CANCELED", Toast.LENGTH_SHORT).show();
            }
    }
    private void init()
    {
        sbAge = findViewById(R.id.sbAge);
        tvAge = findViewById(R.id.tvAge);
        etValeur = findViewById(R.id.sbValeur);
        rbIsFasting = findViewById(R.id.rbtOui);
        rbIsNotFasting = findViewById(R.id.rbtNon);
        btnConsulter = findViewById(R.id.btnConsulter);
        // tvReponse = findViewById(R.id.tvReponse); Pas plus nécessaire
    }
}