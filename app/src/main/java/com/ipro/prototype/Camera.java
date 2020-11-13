package com.ipro.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {
    private ImageView myImage;
    private android.widget.Button Button;
    private android.widget.Button Button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        myImage = (ImageView)findViewById(R.id.myImage);
        Button  = (Button)findViewById(R.id.snap);
        Button1 = (Button)findViewById(R.id.create_Object);


        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openObjectAdding();
            }
        });

    }
    public void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    public void openObjectAdding(){
        Intent a = new Intent(this, objectAdding.class);
        if(myImage.getDrawable() == null){
            startActivity(a);
        }
        else{
            Bitmap bm = ((BitmapDrawable) myImage.getDrawable()).getBitmap();
            a.putExtra("yes", bm);
            startActivity(a);
        }

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Bitmap b = (Bitmap) data.getExtras().get("data");
            myImage.setImageBitmap(b);
        }
    }
}