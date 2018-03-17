package com.example.kam.travelexpensemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Lodging extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase db;
    ImageButton b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodging);
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
            db.execSQL("create table if not exists Lodging(_id varchar(20) PRIMARY KEY, place varchar(40), cost varchar(40))");
            Toast.makeText(this, "Lodging Table Created ", Toast.LENGTH_SHORT).show();
        }catch(ArithmeticException e){
            Toast.makeText(this, "Error :"+e, Toast.LENGTH_SHORT).show();
        }

        Intent i=new Intent(this,LodgingDatabase.class);
        startActivity(i);
    }
}
