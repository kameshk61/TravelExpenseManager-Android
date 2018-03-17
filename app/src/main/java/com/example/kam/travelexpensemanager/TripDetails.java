package com.example.kam.travelexpensemanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class TripDetails extends AppCompatActivity {

    TableLayout tl;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_details);

        tl= (TableLayout) findViewById(R.id.tableLayout);
        tv1= (TextView) findViewById(R.id.textView15);
        tv2= (TextView) findViewById(R.id.textView16);
        tv3= (TextView) findViewById(R.id.textView17);
        tv4= (TextView) findViewById(R.id.textView18);
        tv5= (TextView) findViewById(R.id.textView19);
        tv6= (TextView) findViewById(R.id.textView20);
        tv7= (TextView) findViewById(R.id.textView21);

        try {
            db = openOrCreateDatabase("travel_expense_mgr_db", MODE_PRIVATE, null);
            Toast.makeText(this, "Opening...", Toast.LENGTH_SHORT).show();
        }catch(ArithmeticException e){
            Toast.makeText(this, "Error: "+e, Toast.LENGTH_SHORT).show();
        }

        Cursor c=db.rawQuery("select * from Travel",null);

        while(c.moveToNext())
        {
            String x=c.getString(0);
            String y=c.getString(1);
            String z=c.getString(2);
            String p=c.getString(3);
            String q=c.getString(4);
            String r=c.getString(5);
            String s=c.getString(6);

            TableRow tr=new TableRow(this);
            TextView tv1=new TextView(this);
            TextView tv2=new TextView(this);
            TextView tv3=new TextView(this);
            TextView tv4=new TextView(this);
            TextView tv5=new TextView(this);
            TextView tv6=new TextView(this);
            TextView tv7=new TextView(this);

            tv1.setText(x);
            tv2.setText(y);
            tv3.setText(z);
            tv4.setText(p);
            tv5.setText(q);
            tv6.setText(r);
            tv7.setText(s);
            tr.addView(tv1);
            tr.addView(tv2);
            tr.addView(tv3);
            tr.addView(tv4);
            tr.addView(tv5);
            tr.addView(tv6);
            tr.addView(tv7);
            tl.addView(tr);
        }
    }
}
