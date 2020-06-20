package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        Button btn_add_stu = (Button) findViewById(R.id.btn_add_stu);

        btn_add_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et_stu_name = (EditText) findViewById(R.id.et_stu_name);
                EditText et_father_name = (EditText) findViewById(R.id.et_father_name);
                EditText et_phone_no = (EditText) findViewById(R.id.et_phone_no);
                EditText et_degree_major = (EditText) findViewById(R.id.et_deg_major);
                EditText et_address = (EditText) findViewById(R.id.et_address);
                EditText et_stu_id = (EditText) findViewById(R.id.et_stu_id);
                EditText et_password = (EditText) findViewById(R.id.et_password);

                DatabaseHandler db = new DatabaseHandler(AddStudent.this);
                Log.d("Insert: ", "Inserting ..");

                db.addStudent(new Student(

                        et_stu_name.getText().toString(),
                        et_father_name.getText().toString(),
                        et_phone_no.getText().toString(),
                        et_degree_major.getText().toString(),
                        et_address.getText().toString(),
                        et_stu_id.getText().toString(),
                        et_password.getText().toString()
                ));
                Log.d("Nammmme",db.getDatabaseName());

                Toast.makeText(AddStudent.this, "Added", Toast.LENGTH_LONG).show();

            }
        });
    }
}