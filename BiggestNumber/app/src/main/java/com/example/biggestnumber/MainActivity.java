package com.example.biggestnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int counter = 0;
    int buttonVal1, buttonVal2;
    boolean clicked1 = false, clicked2 = false;

    Button button;
    Button button1;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button1 = (Button)findViewById(R.id.button1);
        textView = (TextView)findViewById(R.id.textView);

        resetButtonNumbers();


        button.setOnClickListener(this);
        button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            clicked1 = true;
            buttonVal1 = Integer.parseInt(button.getText().toString());
            buttonVal2 = Integer.parseInt(button1.getText().toString());
            CheckClick();
            resetButtonNumbers();
        }
        if(v.getId() == R.id.button1){
            clicked2=true;
            buttonVal1 = Integer.parseInt(button.getText().toString());
            buttonVal2 = Integer.parseInt(button1.getText().toString());
            CheckClick();
            resetButtonNumbers();
        }

        }

        public void CheckClick(){
        if(clicked1 && buttonVal1>buttonVal2){
            counter++;
            textView.setText(""+counter);
        } else if(clicked2 && buttonVal2>buttonVal1){
            counter++;
            textView.setText(""+counter);
        }else{
            counter--;
            if(counter < 0){
                counter=0;
            }
            textView.setText(""+counter);
        }
        }


    public void resetButtonNumbers(){
        java.util.Random rand = new java.util.Random();

        java.util.Random rand2 = new java.util.Random();


        int randomNum = rand.nextInt((10 - 1) + 1) + 1;

        int randomNum2 = rand2.nextInt((10-1) + 1)+1;


        button.setText("" + randomNum);
        button1.setText("" + randomNum2);
        clicked1=false;
        clicked2=false;

    }
}
