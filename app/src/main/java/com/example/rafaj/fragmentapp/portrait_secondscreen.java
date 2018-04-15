package com.example.rafaj.fragmentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class portrait_secondscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portrait_secondscreen);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();


        FragmentViewer frag = new FragmentViewer();
        frag.setArguments(getIntent().getExtras());

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.viewer2, frag);
        fragmentTransaction.commit();


    }

}
