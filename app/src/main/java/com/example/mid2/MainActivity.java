package com.example.mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    DatePicker datepicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        datepicker = (DatePicker) findViewById(R.id.datePicker1);
        Button dialogButton = (Button) findViewById(R.id.button);
        Button activity2 = (Button) findViewById(R.id.activity2);

        textView = findViewById ( R.id.textView );
        // Time is in millisecond so 50sec = 50000 I have used
        // countdown Interveal is 1sec = 1000 I have used
        new CountDownTimer ( 50000, 1000 ) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat ( "00" );
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                textView.setText ( f.format ( hour ) + ":" + f.format ( min ) + ":" + f.format ( sec ) );
            }

            // When the task is over it will print 00:00:00 there
            public void onFinish() {
                textView.setText ( "00:00:00" );
            }
        }.start ();

        dialogButton.setOnClickListener(new View.OnClickListener () {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                int day = datepicker.getDayOfMonth();
                int month = datepicker.getMonth() + 1;
                int year = datepicker.getYear();
                Toast.makeText(MainActivity.this,
                        day + "/" + month + "/" + year, Toast.LENGTH_LONG)
                        .show();

            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent (this, activity2.class);
        startActivity(intent);
    }
}


