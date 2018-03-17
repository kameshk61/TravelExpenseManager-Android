package com.example.kam.travelexpensemanager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class TripDatabase extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase db;
    Button b1,b2;
    EditText et1,et2,et3,et4,et5,et6,et7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_database);

        b1= (Button) findViewById(R.id.button);
        b2= (Button) findViewById(R.id.button2);
        et1= (EditText) findViewById(R.id.editText);
        et2= (EditText) findViewById(R.id.editText2);
        et3= (EditText) findViewById(R.id.editText3);
        et4= (EditText) findViewById(R.id.editText4);
        et5= (EditText) findViewById(R.id.editText5);
        et6= (EditText) findViewById(R.id.editText6);
        et7= (EditText) findViewById(R.id.editText7);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        try {
            db = openOrCreateDatabase("travel_expense_mgr_db", MODE_PRIVATE, null);
            Toast.makeText(this, "Database Created", Toast.LENGTH_SHORT).show();
        }catch(ArithmeticException e){
            Toast.makeText(this, "Error: "+e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        if(v==b1) {

            String id = et1.getText().toString();
            String from = et2.getText().toString();
            String to = et3.getText().toString();
            String start = et4.getText().toString();
            String end = et5.getText().toString();
            String approved = et6.getText().toString();
            String balance = et7.getText().toString();

            try {
                db.execSQL("insert into Travel VALUES('" + id + "','" + from + "','" + to + "','" + start + "','" + end + "','" + approved + "','" + balance + "')");
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            } catch (ArithmeticException e) {
                Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
            }

            Intent i=new Intent(this,Menu.class);
            startActivity(i);
        }
        else if(v==b2)
        {
            Intent i=new Intent(this,Travelling.class);
            startActivity(i);
        }
    }
}
