package com.example.part3;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
//import android.graphics.drawable.Drawable;
import android.renderscript.ScriptGroup;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText imgUrl;
    Button clearBtn, subBtn ;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgUrl = findViewById(R.id.imgURL);
        clearBtn = findViewById(R.id.clearBtn);
        subBtn = findViewById(R.id.subBtn);
        imgView = findViewById(R.id.imgView);

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgUrl.setText("");
                imgView.setImageBitmap(null);
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlLink = imgUrl.getText().toString();
                if (urlLink.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter URL!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    LoadImage loadImage = new LoadImage(imgView);
                    loadImage.execute(urlLink);
                }
            }
        });
    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public LoadImage(ImageView youimg) {
            this.imageView = imgView;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlLink = strings[0];
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new URL(urlLink).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imgView.setImageBitmap(bitmap);
        }

    }

}