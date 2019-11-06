package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;

public class Main2Activity extends AppCompatActivity {

    EditText textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (EditText)findViewById(R.id.textView);

        Intent intent = getIntent();

        textView.setText(intent.getStringExtra("Value1"));


    }
}
