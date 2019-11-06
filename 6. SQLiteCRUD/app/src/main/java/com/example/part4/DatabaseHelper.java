package com.example.part4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "List.db";
    public static final String TABLE_NAME = "List_table";

    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String LIST = "LIST";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,LIST TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean insertData(String name, String list){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("LIST", list);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

//    provides random read-write access to result
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
//querying database and storing in res
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+ TABLE_NAME;
        db.execSQL(clearDBQuery);
        db.close();
    }

    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + ID + " FROM " + TABLE_NAME + " WHERE " + NAME + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemList(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + LIST + " FROM " + TABLE_NAME + " WHERE " + NAME + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + NAME + " = '" + newName + "' WHERE " + ID + " = '" + id + "'" +  " AND " + NAME + " = '" + oldName + "'";
        db.execSQL(query);
    }

    public void updateList(String newList, int id, String oldList){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + LIST + " = '" + newList + "' WHERE " + ID + " = '" + id + "'" +  " AND " + LIST + " = '" + oldList + "'";
        db.execSQL(query);
    }
}
