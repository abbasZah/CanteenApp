package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCanteen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_canteen);


        final EditText et_management_name = findViewById(R.id.et_student_name);
        final EditText et_handler_name = findViewById(R.id.et_father_name);
        final EditText et_phone_no= findViewById(R.id.et_phone_no);
        final EditText et_no_of_workers= findViewById(R.id.et_degree_major);
        final EditText et_address= findViewById(R.id.et_address);
        final EditText et_username= findViewById(R.id.et_student_id);
        final EditText et_password_= findViewById(R.id.et_password);


        Button btn_add_canteen = findViewById(R.id.btn_add_student);

        btn_add_canteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHandler db = new DatabaseHandler(AddCanteen.this);
                Log.d("Insert: ", "Inserting ..");

                db.addCanteen(new Canteen(et_management_name.getText().toString(),
                        et_handler_name.getText().toString(),
                        et_phone_no.getText().toString(),
                        Integer.parseInt(et_no_of_workers.getText().toString()),
                        et_address.getText().toString(),
                        et_username.getText().toString(),
                        et_password_.getText().toString()));



                Toast.makeText(getApplicationContext(),"Canteen Added Successfuly !",Toast.LENGTH_SHORT).show();


            }
        });




    }
}