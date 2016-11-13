package com.example.agath.eseoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayStageEmploiActivity extends AppCompatActivity {
    Spinner listeDomaine;
    CheckBox stageI1 = null, stageI2 = null, stageI3=null, emploi = null;
    TextView result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_stage_emploi);

        //Rédupération du spinner declaré dans le xml
        listeDomaine = (Spinner) findViewById(R.id.domaineListe);

        //création d'une liste d'élément
        List testDesDomaines = new ArrayList();
        testDesDomaines.add("Tous");
        testDesDomaines.add("domaine1");
        testDesDomaines.add("domaine2");
        testDesDomaines.add("domaine3");

        /*Le Spinner a besoin d'un adapter pour sa presentation alors on lui passe le context(this) et
                un fichier de presentation par défaut( android.R.layout.simple_spinner_item)
        Avec la liste des elements (exemple) */

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                testDesDomaines
        );

        /* On definit une présentation du spinner quand il est déroulé         (android.R.layout.simple_spinner_dropdown_item) */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Enfin on passe l'adapter au Spinner et c'est tout
        listeDomaine.setAdapter(adapter);
    }


    /** Called when the user clicks the send button */
    public void rechercherStageEmploi(View view) {
        Intent intent = new Intent(this, DisplayStageEmploiMap.class);
        stageI1 = (CheckBox)findViewById(R.id.checkBoxI1);
        //stageI1.setOnClickListener(checkedListener);
        startActivity(intent);
    }

}

