package com.ipro.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Camera extends AppCompatActivity {
    private ImageView myImage;
    private android.widget.Button Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        myImage = (ImageView)findViewById(R.id.myImage);
        Button  = (Button)findViewById(R.id.snap);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

    }
    public void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
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