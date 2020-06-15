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
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Canteen> contacts = db.getAllCanteens();
        String log=null;
        String [] contact_array = new String[contacts.size()];
        int i=0;
        for (Canteen cn : contacts) {
            contact_array[i] = cn.getManagement_name() +" ("+ cn.getPhone_no() + ") ";
            log = log + "Id: " + cn.getId() + " ,Name: " + cn.getHandler_name() + ",Phone: " + cn.getPhone_no();
            // Writing Contacts to log
            Log.d("Name: ", log);
            i++;
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview , contact_array);
        ListView listView = (ListView) findViewById(R.id.lv_canteen_list);
        listView.setAdapter(adapter);

/*
        String [] canteen_array = {"Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X","Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X","Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X"};


        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview , canteen_array);
        ListView listView = (ListView) findViewById(R.id.lv_canteen_list);
        listView.setAdapter(adapter);

 */


    }
}