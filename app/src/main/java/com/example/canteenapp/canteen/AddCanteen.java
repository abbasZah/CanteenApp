package com.example.canteenapp.canteen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.canteenapp.R;

public class AddCanteen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_canteen);


        Button btn_add_canteen = (Button) findViewById(R.id.btn_update);

        btn_add_canteen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                EditText et_management_name = (EditText) findViewById(R.id.et_management_name);
                EditText et_handler_name = (EditText) findViewById(R.id.et_handler_name);
                EditText et_phone_no = (EditText) findViewById(R.id.et_phone_no);
                EditText et_no_of_workers = (EditText) findViewById(R.id.et_no_of_workers);
                EditText et_address = (EditText) findViewById(R.id.et_address);
                EditText et_username = (EditText) findViewById(R.id.et_username);
                EditText et_password = (EditText) findViewById(R.id.et_password);

                DatabaseHandler db = new DatabaseHandler(AddCanteen.this);
                Log.d("Insert: ", "Inserting ..");

                db.addCanteen(new Canteen(


                        et_management_name.getText().toString(),
                        et_handler_name.getText().toString(),
                        et_phone_no.getText().toString(),
                        et_no_of_workers.getText().toString(),
                        et_address.getText().toString(),
                        et_username.getText().toString(),
                        et_password.getText().toString()

                ));
                Toast.makeText(getApplicationContext(), "Canteen Added Successfully" , Toast.LENGTH_SHORT).show();
            }
        });


    }
}