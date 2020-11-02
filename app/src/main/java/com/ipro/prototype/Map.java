package com.ipro.prototype;

import android.content.ClipData;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Layout;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Map extends AppCompatActivity {
    private ViewGroup mainlayout;
    private ImageView image;
    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = findViewById(R.id.mapBar);
        setSupportActionBar(toolbar);
        mainlayout = (RelativeLayout) findViewById(R.id.content);
        image = (ImageView) findViewById(R.id.fab);
        image.setOnTouchListener(OnTouchListener());

    }

    private View.OnTouchListener OnTouchListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;
                    case MotionEvent.ACTION_UP:
                        Toast.makeText(Map.this, "Updated", Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams Layoutparams = (RelativeLayout.LayoutParams) v.getLayoutParams();
                        Layoutparams.leftMargin = x - xDelta;
                        Layoutparams.topMargin = y - yDelta;
                        Layoutparams.rightMargin = 0;
                        Layoutparams.bottomMargin = 0;
                        v.setLayoutParams(Layoutparams);
                        break;
                };
              mainlayout.invalidate();
             return true;
            };
        };
    }

}