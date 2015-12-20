package com.algosee.prerk.isola;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;



public class Welcome extends ActionBarActivity {

    public static int PlayerFlag = 0;

    //String key = "848bd69a3169a138522c20e22d97c2b6bcbae01a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


    }

    public void start(View view){
        PlayerFlag = 2;
        Intent startgame = new Intent(getApplicationContext(),game.class);
        startActivity(startgame);
        finish();

        //Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
    }

    public void start_one(View view){
        PlayerFlag = 1;
        Intent startgame = new Intent(getApplicationContext(),game.class);
        startActivity(startgame);
        finish();

        //Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
    }

    public void help(View view)
    {
        Intent instructions = new Intent(getApplicationContext(),Instructions.class);
        startActivity(instructions);
    }

    public void exit(View view){
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        //Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
