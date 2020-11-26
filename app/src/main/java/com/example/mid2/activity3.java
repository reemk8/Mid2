package com.example.mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_activity3 );
        final DatabaseHelper myDB = new DatabaseHelper ( this );
        final EditText employeeId = (EditText) findViewById ( R.id.personalId );
        final EditText employeeName = (EditText) findViewById ( R.id.name );
        final Button search = findViewById ( R.id.search );
        final Button view = findViewById ( R.id.view );

        search.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String id=employeeId.getText ().toString ();
                myDB.DeleteEmployees ( id );
                Toast toast = Toast.makeText ( getApplicationContext (),
                        "Sucessful Delete",
                        Toast.LENGTH_SHORT );

                toast.show ();
            }
        } );}}

view.setOnClickListener ( new View.OnClickListener () {
public void onClick(View v) {

        Cursor cur = myDB.ViewEmployees ();
        StringBuffer buffer = new StringBuffer ();
        while (cur.moveToNext ()) {
        buffer.append ( "id: " + cur.getString ( 0 ) + "\n" );
        buffer.append ( "Name: " + cur.getString ( 1 ) + "\n" );
        buffer.append ( "Surname " + cur.getString ( 2 ) + "\n\n" );
        buffer.append ( "PersonalID " + cur.getString ( 2 ) + "\n\n\n" );
        buffer.append ( "Phone " + cur.getString ( 2 ) + "\n\n\n\n" );


        }
        AlertDialog.Builder builder = new AlertDialog.Builder ( MainActivity.this );
        builder.setCancelable ( true );
        builder.setTitle ( "All employees" );
        builder.setMessage ( buffer.toString () );
        builder.show ();

        Toast toast = Toast.makeText ( getApplicationContext (),
        "Sucessful View",
        Toast.LENGTH_SHORT );

        toast.show ();
        }
        } );