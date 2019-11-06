package com.example.part4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Main3Activity extends AppCompatActivity {

    Button saveData;

    EditText editData,editContent;

    DatabaseHelper myDb;

    String name, list;
    int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        saveData = findViewById(R.id.saveData);
        editData = findViewById(R.id.editData);
        editContent = findViewById(R.id.editContent);

        myDb = new DatabaseHelper(this);

        Intent intent = getIntent();

        selectedID = intent.getIntExtra("id", -1);

        name = intent.getStringExtra("name");

        list = intent.getStringExtra("list");

        editData.setText(name);
        editContent.setText(list);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editData.getText().toString();
                String newList = editContent.getText().toString();

                if(!item.equals("")){
                    myDb.updateName(item, selectedID, name);
                    myDb.updateList(newList, selectedID, list);
                    Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Main3Activity.this, "You must enter a name", LENGTH_SHORT).show();
                }
            }
        });
    }
}
