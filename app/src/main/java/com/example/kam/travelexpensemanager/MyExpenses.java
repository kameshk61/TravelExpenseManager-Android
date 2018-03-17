package com.example.kam.travelexpensemanager;

import android.app.ListActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyExpenses extends ListActivity {

    SQLiteDatabase db;
    String[] expense={"Travelling","Meal","Lodging","Misc."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,expense);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position)
        {
            case 0:
            {

                Intent i=new Intent(this,Travelling.class);
                startActivity(i);
                break;
            }
            case 1:
            {
                Intent i=new Intent(this,Meal.class);
                startActivity(i);
                break;
            }
            case 2:
            {
                Intent i=new Intent(this,Lodging.class);
                startActivity(i);
                break;
            }
            case 3:
            {
                Intent i=new Intent(this,Misc.class);
                startActivity(i);
                break;
            }
        }
    }
}
