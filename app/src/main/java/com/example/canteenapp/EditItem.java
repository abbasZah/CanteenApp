package com.example.canteenapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        final EditText et_id = (EditText) findViewById(R.id.et_item_id);

        final Button btn_go = (Button) findViewById(R.id.btn_go);
        final Button btn_update = (Button) findViewById(R.id.btn_update);

        final EditText et_food_name = (EditText) findViewById(R.id.et_food_name);
        final EditText et_item_desc = (EditText) findViewById(R.id.et_item_desc);
        final EditText et_cost = (EditText) findViewById(R.id.et_cost);
        final EditText et_time_to_get_ready = (EditText) findViewById(R.id.et_time_to_get_ready);


        final TextView tv_food_name = (TextView) findViewById(R.id.tv_food_name);
        final TextView tv_item_desc = (TextView) findViewById(R.id.tv_item_desc);
        final TextView tv_cost = (TextView) findViewById(R.id.tv_cost);
        final TextView tv_time_to_get_ready = (TextView) findViewById(R.id.tv_time_to_get_ready);


        et_food_name.setVisibility(View.INVISIBLE);
        et_item_desc.setVisibility(View.INVISIBLE);
        et_cost.setVisibility(View.INVISIBLE);
        et_time_to_get_ready.setVisibility(View.INVISIBLE);


        btn_update.setVisibility(View.INVISIBLE);

        tv_food_name.setVisibility(View.INVISIBLE);
        tv_item_desc.setVisibility(View.INVISIBLE);
        tv_cost.setVisibility(View.INVISIBLE);
        tv_time_to_get_ready.setVisibility(View.INVISIBLE);

        //Start from Here


        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starting a new Intent
                final DatabaseHandler db = new DatabaseHandler(EditItem.this);
//                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfItemExist(et_id.getText().toString());
                if (found) {
                    et_food_name.setVisibility(View.VISIBLE);
                    et_item_desc.setVisibility(View.VISIBLE);
                    et_cost.setVisibility(View.VISIBLE);
                    et_time_to_get_ready.setVisibility(View.VISIBLE);


                    btn_update.setVisibility(View.VISIBLE);

                    tv_food_name.setVisibility(View.VISIBLE);
                    tv_item_desc.setVisibility(View.VISIBLE);
                    tv_cost.setVisibility(View.VISIBLE);
                    tv_time_to_get_ready.setVisibility(View.VISIBLE);


                    final FoodItem oldItem = db.getItem(et_id.getText().toString());

                    et_food_name.setText(oldItem.getFood_name().toString());
                    et_item_desc.setText(oldItem.getItem_desc().toString());
                    et_cost.setText(oldItem.getCost().toString());
                    et_time_to_get_ready.setText(oldItem.getTime_to_get_ready().toString());


                    Toast.makeText(getApplicationContext(), "Found Item",
                            Toast.LENGTH_SHORT).show();
                    // When user update
                    Button btn_update = findViewById(R.id.btn_update);
                    //Listening to button event
                    btn_update.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View arg0) {
                            db.updateItem(new FoodItem(
                                    oldItem.getItem_id(),
                                    et_food_name.getText().toString(),
                                    et_item_desc.getText().toString(),
                                    et_cost.getText().toString(),
                                    et_time_to_get_ready.getText().toString()

                            ));
                            Toast.makeText(getApplicationContext(), "Record is Updated", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Not Found Student", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}