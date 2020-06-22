package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.canteenapp.Canteen;
import com.example.canteenapp.DatabaseHandler;
import com.example.canteenapp.R;

import java.util.List;

public class ShowCanteens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_canteens);
        getSupportActionBar().setTitle("Show Canteens");


        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("Reading: ", "Reading all canteens..");
        List<Canteen> canteens = db.getAllCanteens();
        String log=null;
        String [] canteen_array = new String[canteens.size()];
        int i=0;
        for (Canteen cn : canteens) {
            canteen_array[i] = "Id: " + cn.getId() + "\nManagement Name: " + cn.getManagement_name() +"\nHandler Name: "+ cn.getHandler_name() + "\nPhone No: " + cn.getPhone_no()
                            + "\nNo. of Workers: " + cn.getNo_of_workers() + "\nAddress: " + cn.getAddress() +"\nUsername: "+ cn.getUsername() + "\nPassword: " + cn.getPassword()
            ;
            log = log + "Id: " + cn.getId() + " ,Name: " + cn.getManagement_name() + " ,Phone: " + cn.getPhone_no();

            Log.d("Name: ", log);
            i++;
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, canteen_array);
        ListView listView = (ListView) findViewById(R.id.lv_canteen_list);
        listView.setAdapter(adapter);


    }
}