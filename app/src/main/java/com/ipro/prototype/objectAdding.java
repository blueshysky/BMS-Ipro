package com.ipro.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class objectAdding extends AppCompatActivity {
    String name;
    int serialID;
    ImageView someImage;
    EditText nameinput;
    EditText serialinput;

    Button addButton;
    Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_adding);
        nameinput = (EditText) findViewById(R.id.asset_name_input);
        serialinput = (EditText) findViewById(R.id.asset_id_input);
        someImage = (ImageView) findViewById(R.id.someimage) ;
        addButton = (Button) findViewById(R.id.addobject);
        updateButton = (Button)findViewById(R.id.update_button);
        Intent tent = getIntent();

        if(tent.hasExtra("yes"))  {
            Bitmap bit = tent.getParcelableExtra("yes");
            someImage.setImageBitmap(bit);
        }


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameinput.getText().toString();
                serialID = Integer.valueOf(serialinput.getText().toString());

                updatesomething(name);
                updatesomething(String.valueOf(serialID));
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameinput.getText().toString();
                serialID = Integer.valueOf(serialinput.getText().toString());

                showsomething(name);
                showsomething(String.valueOf(serialID));
            }
        });

    }
    public void showsomething(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    public void updatesomething(String text){
        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
    }
}