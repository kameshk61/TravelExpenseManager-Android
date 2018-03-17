package com.example.kam.travelexpensemanager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MealDatabase extends AppCompatActivity implements View.OnClickListener {

    EditText et1,et2,et3;
    SQLiteDatabase db;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_database);
        b1= (Button) findViewById(R.id.button3);
        b2= (Button) findViewById(R.id.button4);
        et1= (EditText) findViewById(R.id.editText8);
        et2= (EditText) findViewById(R.id.editText9);
        et3= (EditText) findViewById(R.id.editText10);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        try {
            db = openOrCreateDatabase("travel_expense_mgr_db", MODE_PRIVATE, null);
            Toast.makeText(this, "Opening Database", Toast.LENGTH_SHORT).show();
        }catch(ArithmeticException e){
            Toast.makeText(this, "Error: "+e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            String id = et1.getText().toString();
            String name = et2.getText().toString();
            String cost = et3.getText().toString();

            try {
                db.execSQL("insert into Meal VALUES('" + id + "','" + name + "','" + cost + "')");
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
            } catch (ArithmeticException e) {
                Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
            }

            Intent i=new Intent(this,Menu.class);
            startActivity(i);
        }
        else if(v==b2)
        {
            Intent i=new Intent(this,Meal.class);
            startActivity(i);
        }
    }
}
