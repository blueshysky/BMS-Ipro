package com.ipro.prototype;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Stuff> stuffList = new ArrayList<Stuff>();
    private RecyclerView recyclerView;
    private StuffAdapter StuffAdapter;
    private Button button;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.mapButton);
        button2 = (Button) findViewById(R.id.cambutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                openCam();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.stuffRecycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        for(int i = 0 ; i<10; i++){
            stuffList.add(new Stuff());
        };


        StuffAdapter = new StuffAdapter(stuffList, this);

        recyclerView.setAdapter(StuffAdapter);

    }

    private void openCam() {
        Intent intent = new Intent(this, Camera.class);
        startActivity(intent);
    }
    private void openMap() {
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }



}