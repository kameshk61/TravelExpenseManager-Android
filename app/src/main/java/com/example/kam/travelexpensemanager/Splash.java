package com.example.kam.travelexpensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        class MyThread extends Thread{
             public void run()
             {
                 MyThread thread=new MyThread();
                 try {
                     thread.sleep(3000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 Intent i=new Intent(Splash.this,Menu.class);
                 startActivity(i);

             }
        }

        MyThread th=new MyThread();
        th.start();
    }
}


