package com.example.part4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    EditText name, content;

    ListView listView;

    Button createBtn, viewData, deleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        listItem = new ArrayList<String>();

        name = (EditText) findViewById(R.id.name);
        content = (EditText) findViewById(R.id.content);
        createBtn = (Button) findViewById(R.id.createBtn);
        viewData = (Button) findViewById(R.id.viewData);
        deleteData = (Button) findViewById(R.id.deleteData);
        listView = (ListView) findViewById(R.id.listView);

        addData();

        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }


    public void addData() {
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = name.getText().toString();
                String stuff = name.getText().toString();
                if(title.length() != 0 && stuff.length() != 0){
                    myDb.insertData(name.getText().toString(), content.getText().toString());
                    listItem.clear();
                    Toast.makeText(MainActivity.this, "Data Inseted", Toast.LENGTH_LONG).show();
                    name.setText("");
                    content.setText("");
                }

            }
        });
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }


}
