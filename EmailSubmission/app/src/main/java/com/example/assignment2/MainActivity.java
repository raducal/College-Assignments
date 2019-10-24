package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import 	android.net.Uri;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String name, email, password;
    int phoneNumber;

    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editText.getText().toString();
                password = editText2.getText().toString();
                email = editText3.getText().toString();
                phoneNumber = Integer.valueOf(editText3.getText().toString());


                editText.getText().clear();
                editText2.getText().clear();
                editText3.getText().clear();
                editText4.getText().clear();



                openActivity2(email, name);

            }
        });
    }

    public void openActivity2(String email, String name){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
        intent.putExtra(Intent.EXTRA_EMAIL, name);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Form Submitted");
        intent.putExtra(Intent.EXTRA_TEXT, "Thank you" + name);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}