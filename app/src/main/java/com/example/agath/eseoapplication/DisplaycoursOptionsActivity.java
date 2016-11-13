package com.example.agath.eseoapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DisplaycoursOptionsActivity extends Activity {
    private  HTMLAsyncTask _task = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaycours_options);

        setTitle("Actualités");

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listCoursOptions);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        RSSAdapter adapter = new RSSAdapter();
        recyclerView.setAdapter(adapter);

        _task = new HTMLAsyncTask(adapter);
        _task.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(_task != null)
            _task.cancel(true);
    }
}
