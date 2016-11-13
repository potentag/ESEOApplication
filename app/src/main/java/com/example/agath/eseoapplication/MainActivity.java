package com.example.agath.eseoapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.agath.eseoapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("1ere page");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    public boolean OnOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_edit:
                //
                return true;
            case  R.id.action_add:
                //
                return true;
            case R.id.action_delete:
                //
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /** Called when the user clicks the send button */
    /*public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
    public void connexion(View view) {
        Intent intent = new Intent(this, DisplayConnexionActivity.class);
        startActivity(intent);
    }

    public void stageEmploi(View view) {
        Intent intent = new Intent(this, DisplayStageEmploiActivity.class);
        startActivity(intent);
    }

    public void CVTheque(View view) {
        Intent intent = new Intent(this, DisplayCVThequeActivity.class);
        startActivity(intent);
    }

    public void informationESEO(View view) {
        Intent intent = new Intent(this, DisplayinformationESEOActivity.class);
        startActivity(intent);
    }

    public void coursOptions(View view) {
        Intent intent = new Intent(this, DisplaycoursOptionsActivity.class);
        startActivity(intent);
    }

    public void des(View view) {
        Intent intent = new Intent(this, Des.class);
        startActivity(intent);
    }

}
