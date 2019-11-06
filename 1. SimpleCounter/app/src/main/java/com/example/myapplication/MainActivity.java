package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    Button btn1;
    TextView txtView1;
    int clickCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = (Button)findViewById(R.id.btn1);
        txtView1 = (TextView)findViewById(R.id.txtView1);

        btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                txtView1.setText(""+clickCount);
            }
        });
    }
}
