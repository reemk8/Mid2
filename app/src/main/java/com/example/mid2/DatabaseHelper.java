package com.example.mid2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "Citizens.db";
    public static final String TABLE_NAME="Citizens";
    public static final String COLUMN_ID="ID";
    public static final String COLUMN_NAME="Name";
    public static final String COLUMN_SURNAME="Surname";
    public static final String COLUMN_PHONE="Phone";
    public static final String COLUMN_PERSONAL_ID="PersonalID";



    public DatabaseHelper(@Nullable Context context) {
        super ( context, DATABASE_NAME, null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL (
                "CREATE TABLE " + TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY,"+COLUMN_NAME+" TEXT NOT NULL,"+COLUMN_SURNAME+" INTEGER NOT NULL, "+COLUMN_PHONE+" INTEGER NOT NULL, "+COLUMN_PERSONAL_ID+" INTEGER NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AddEmployees(String id, String name, String surname, String phone, String personalId) {
        SQLiteDatabase db=this.getWritableDatabase ();

        ContentValues values= new ContentValues (  );
        values.put ( COLUMN_ID,id );
        values.put ( COLUMN_NAME,name );
        values.put ( COLUMN_SURNAME,surname );
        values.put ( COLUMN_PHONE,phone );
        values.put ( COLUMN_PERSONAL_ID,personalId);

        db.insert ( TABLE_NAME, null,values );
    }

    public Cursor ViewEmployees(){
        SQLiteDatabase db=this.getWritableDatabase ();
        Cursor x=db.rawQuery ( "SELECT * FROM "+TABLE_NAME,null);
        return x;
    }

    public Integer DeleteEmployees(String id){
        SQLiteDatabase db=this.getWritableDatabase ();
        return db.delete (TABLE_NAME, "PersonalID = ?", new String[] {id});
    }




}

