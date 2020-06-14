package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class AddCanteen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_canteen);


        EditText et_management_name = findViewById(R.id.et_management_name);
        EditText et_handler_name = findViewById(R.id.et_handler_name);
        EditText et_phone_no= findViewById(R.id.et_phone_no);
        EditText et_no_of_workers= findViewById(R.id.et_no_of_workers);
        EditText et_address= findViewById(R.id.et_address);
        EditText et_username= findViewById(R.id.et_username);
        EditText eet_password_= findViewById(R.id.et_password);



    }
}