package com.example.kam.travelexpensemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Travelling extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase db;
    ImageButton b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelling);
        b= (ImageButton) findViewById(R.id.imageButton);
        b.setOnClickListener(this);

        try {
            db = openOrCreateDatabase("travel_expense_mgr_db", MODE_PRIVATE, null);
            Toast.makeText(this, "Database Created", Toast.LENGTH_SHORT).show();
        }catch(ArithmeticException e){
            Toast.makeText(this, "Error: "+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        try {
            db.execSQL("create table if not exists Travel(_id varchar(20) PRIMARY KEY, loc_from varchar(40), loc_to varchar(40), start varchar(12), end varchar(12), approved varchar(10), balance varchar(10))");
            Toast.makeText(this, "Travel Table Created ", Toast.LENGTH_SHORT).show();
        }catch(ArithmeticException e){
            Toast.makeText(this, "Error :"+e, Toast.LENGTH_SHORT).show();
        }

        Intent i=new Intent(this,TripDatabase.class);
        startActivity(i);
    }
}
