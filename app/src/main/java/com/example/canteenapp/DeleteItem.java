package com.example.canteenapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteItem extends AppCompatActivity {

    private Button btn_delete;
    private EditText et_delete_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_item);

        btn_delete = (Button) findViewById(R.id.btn_delete);

        btn_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                et_delete_item = (EditText) findViewById(R.id.et_delete_item);

                DatabaseHandler db = new DatabaseHandler(DeleteItem.this);

                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfItemExist(et_delete_item.getText().toString());
                if (found) {
// deleting

                    FoodItem item = new FoodItem();

                    item.setItem_id(Integer.parseInt(et_delete_item.getText().toString()));

                    db.deleteItem(item);
                    Toast.makeText(getApplicationContext(), "Record Deleted",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Record Not Found",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}