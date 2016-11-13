package com.example.agath.eseoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by agath on 03/11/2016.
 */

public class Des extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.des);

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Des.this, DiceActivity.class);
                intent.putExtra("max", 6);
                startActivity(intent);
            }
        });

        Button button20 = (Button) findViewById(R.id.button20);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Des.this, DiceActivity.class);
                intent.putExtra("max", 20);
                startActivity(intent);
            }
        });
    }
}
