package com.example.kam.travelexpensemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MealDetails extends AppCompatActivity {

    TableLayout tl;
    TextView tv1,tv2,tv3;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        tl= (TableLayout) findViewById(R.id.tableLayout);
        tv1= (TextView) findViewById(R.id.textView15);
        tv2= (TextView) findViewById(R.id.textView16);
        tv3= (TextView) findViewById(R.id.textView17);


        try {
            db = openOrCreateDatabase("travel_expense_mgr_db", MODE_PRIVATE, null);
            Toast.makeText(this, "Opening...", Toast.LENGTH_SHORT).show();
        }catch(ArithmeticException e){
            Toast.makeText(this, "Error: "+e, Toast.LENGTH_SHORT).show();
        }

        Cursor c=db.rawQuery("select * from Meal",null);

        while(c.moveToNext())
        {
            String x=c.getString(0);
            String y=c.getString(1);
            String z=c.getString(2);

            TableRow tr=new TableRow(this);
            TextView tv1=new TextView(this);
            TextView tv2=new TextView(this);
            TextView tv3=new TextView(this);

            tv1.setText(x);
            tv2.setText(y);
            tv3.setText(z);
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tl.addView(tr);
        }

    }
}
