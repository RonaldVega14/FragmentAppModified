package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Portrait_second_screen extends AppCompatActivity {

    private TextView parole;
    private ImageView icone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portrait_secondscreen);

        parole = findViewById(R.id.vParole);
        icone = findViewById(R.id.vIcone);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        if (Intent.ACTION_SEND.equals(intentAction)){
            handleReceivedText(callingIntent);
        }

    }

    private void handleReceivedText(Intent intent){
        Planete planete = intent.getExtras().getParcelable("KEY");
        String intentText = planete.getSurnom();

        if(parole != null){
            parole.setText(intentText);
            icone.setImageResource(planete.getNombre());
        }
    }
}
