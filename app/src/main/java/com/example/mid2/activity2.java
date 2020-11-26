package com.example.mid2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_activity2 );
        final DatabaseHelper myDB = new DatabaseHelper ( this );


        final Button view = findViewById ( R.id.read );
        final Button delete = findViewById ( R.id.delete );



        view.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                Cursor cur = myDB.ViewEmployees ();
                StringBuffer buffer = new StringBuffer ();
                while (cur.moveToNext ()) {
                    buffer.append ( "id: " + cur.getString ( 0 ) + "\n" );
                    buffer.append ( "Name: " + cur.getString ( 1 ) + "\n" );
                    buffer.append ( "Surname: " + cur.getString ( 2 ) + "\n\n" );
                    buffer.append ( "Phone: " + cur.getString ( 2 ) + "\n\n\n" );
                    buffer.append ( "PersonalId: " + cur.getString ( 2 ) + "\n\n\n\n" );
                }
                AlertDialog.Builder builder = new AlertDialog.Builder ( activity2.this );
                builder.setCancelable ( true );
                builder.setTitle ( "All citizens" );
                builder.setMessage ( buffer.toString () );
                builder.show ();

                Toast toast = Toast.makeText ( getApplicationContext (),
                        "Sucessful View",
                        Toast.LENGTH_SHORT );

                toast.show ();
            }
        } );

        delete.setOnClickListener ( new View.OnClickListener () {
            public void deleteFirstRow(String id) {
                
                SQLiteDatabase db = dbHelper.getWritableDatabase();


