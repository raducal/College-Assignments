package com.example.part4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static android.widget.Toast.LENGTH_SHORT;

public class Main2Activity extends AppCompatActivity {

    ListView listView;

    DatabaseHelper myDb;

    ArrayList<String> listItem;
    ArrayAdapter adapter;

    Button deleteData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDb = new DatabaseHelper(this);

        deleteData = findViewById(R.id.deleteData);
        listView = findViewById(R.id.listView);
        listItem = new ArrayList<String>();

        viewAll();
        deleteAll();
    }


    private void viewAll(){
                Cursor res = myDb.getAllData();
                if(res.getCount() == 0){
                    Toast.makeText(Main2Activity.this, "Error", Toast.LENGTH_LONG).show();
                }else{

                    while(res.moveToNext()){
                        listItem.add(res.getString(1));
//                        listItem.add(res.getString(2));
//                        listItem.add(" ");
                    }

                adapter = new ArrayAdapter<>(Main2Activity.this, android.R.layout.simple_list_item_1
                , listItem);

                listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position,
                                                long id) {

                            String name = parent.getItemAtPosition(position).toString();

                        Cursor data = myDb.getItemID(name);
                            Cursor list = myDb.getItemList(name);

                        int itemID = -1;
                        String itemList = "";

                        while(data.moveToNext()){
                            itemID = data.getInt(0);
                        }

                        while(list.moveToNext()){
                            itemList = list.getString(0);
                        }


                        Toast.makeText(Main2Activity.this, "name" + itemList, LENGTH_SHORT).show();



                        if(itemID > -1){
                            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                            intent.putExtra("id",itemID);
                            intent.putExtra("name", name);
                            intent.putExtra("list", itemList);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Main2Activity.this, "name" + itemID, LENGTH_SHORT).show();
                        }
                        }
                    });

                }

    }


        public void deleteAll(){
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.clearDatabase();
                adapter.clear();
            }
        });
    }
}
