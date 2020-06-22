package com.example.canteenapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button btn_add_item = (Button) findViewById(R.id.btn_add_item);

        btn_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et_food_name = (EditText) findViewById(R.id.et_food_name);
                EditText et_item_description = (EditText) findViewById(R.id.et_item_description);
                EditText et_cost = (EditText) findViewById(R.id.et_cost);
                EditText et_time_to_get_ready = (EditText) findViewById(R.id.et_time_to_get_ready);


                DatabaseHandler db = new DatabaseHandler(AddItem.this);
                Log.d("Insert: ", "Inserting ..");

                db.addItem(new FoodItem(

                        et_food_name.getText().toString(),
                        et_item_description.getText().toString(),
                        et_cost.getText().toString(),
                        et_time_to_get_ready.getText().toString()

                ));
                Log.d("DataBaseName", db.getDatabaseName());

                Toast.makeText(AddItem.this, "Added", Toast.LENGTH_LONG).show();

            }
        });
    }
}