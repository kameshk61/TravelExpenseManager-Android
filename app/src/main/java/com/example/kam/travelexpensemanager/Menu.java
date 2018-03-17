package com.example.kam.travelexpensemanager;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

    String[] menu={"My Expenses","Trip Details","Meal Details","Lodging Details","Misc Details","About App","Exit"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,menu);
        setListAdapter(adapter);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position)
        {
            case 0:
            {
                Intent i=new Intent(this,MyExpenses.class);
                startActivity(i);
                break;
            }

            case 1:
            {
                Intent i=new Intent(this,TripDetails.class);
                startActivity(i);
                break;
            }
            case 2:
            {
                Intent i=new Intent(this,MealDetails.class);
                startActivity(i);
                break;
            }
            case 3:
            {
                Intent i=new Intent(this,LodgingDetails.class);
                startActivity(i);
                break;
            }
            case 4:
            {
                Intent i=new Intent(this,MiscDetails.class);
                startActivity(i);
                break;
            }
            case 5:
            {
                Intent i=new Intent(this,About.class);
                startActivity(i);
                break;
            }
            case 6:
            {
                finishAffinity();
                break;
            }
        }

    }
}
