package com.example.canteenapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ShowItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);

        DatabaseHandler db = new DatabaseHandler(this);
        List<FoodItem> items = db.getAllItems();

        String[] item_array = new String[items.size()];
        int i = 0;
        for (FoodItem fi : items) {
            item_array[i] = "Id: " + fi.getItem_id() + "\nFood Item Name: " + fi.getFood_name() + "\nDescription: "
                    + fi.getItem_desc() + "\nCost: " + fi.getCost()
                    + "\nTime to get Ready: " + fi.getTime_to_get_ready();

            i++;
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, item_array);
        ListView listView = (ListView) findViewById(R.id.lv_items_list);
        listView.setAdapter(adapter);

    }
}