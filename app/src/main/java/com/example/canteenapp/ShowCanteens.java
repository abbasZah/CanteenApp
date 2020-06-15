package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ShowCanteens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_canteens);


        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("Reading: ", "Reading all canteens..");
        List<Canteen> canteens = db.getAllCanteens();
        String log=null;
        String [] canteen_array = new String[canteens.size()];
        int i=0;
        for (Canteen cn : canteens) {
            canteen_array[i] = cn.getManagement_name() +" ("+ cn.getHandler_name() + " ,PhNo: " + cn.getPhone_no() + ") ";
            log = log + "Id: " + cn.getId() + " ,Name: " + cn.getManagement_name() + " ,Phone: " + cn.getPhone_no();

            Log.d("Name: ", log);
            i++;
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1 , canteen_array);
        ListView listView = (ListView) findViewById(R.id.lv_canteen_list);
        listView.setAdapter(adapter);


    }
}