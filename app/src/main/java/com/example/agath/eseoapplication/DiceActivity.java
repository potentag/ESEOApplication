package com.example.agath.eseoapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.SecureRandom;

/**
 * Created by agath on 03/11/2016.
 */
public class DiceActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textResult;
    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydice);

        max = getIntent().getIntExtra("max", 0);

        TextView textTitle = (TextView) findViewById(R.id.textTitle);
        textTitle.setText(max + " sided dice");

        textResult = ((TextView) findViewById(R.id.textResult));
        textResult.setText("");

        Button buttonRoll = (Button) findViewById(R.id.buttonRoll);
        buttonRoll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SecureRandom random = new SecureRandom();
        int result = random.nextInt(max) + 1;
        textResult.setText(String.valueOf(result));
    }
}
