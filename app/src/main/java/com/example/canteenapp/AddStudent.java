package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    private EditText et_stu_name,
    et_father_name,
    et_phone,
    et_degree_major,
    et_address,
    et_stu_id,
    et_password;

    private Button btn_add_stu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        et_stu_name = findViewById(R.id.et_management_name);
        et_father_name = findViewById(R.id.et_handler_name);
        et_phone = findViewById(R.id.et_phone_no);
        et_degree_major = findViewById(R.id.et_no_of_workers);
        et_address = findViewById(R.id.et_address);
        et_stu_id = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_add_stu = findViewById(R.id.btn_add_student);


        btn_add_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddStudent.this, "Added", Toast.LENGTH_LONG).show();

            }
        });
    }
}