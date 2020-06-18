package com.example.canteenapp.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.canteenapp.R;

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



        btn_add_stu = (Button) findViewById(R.id.btn_add_stu);

        btn_add_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et_stu_name = (EditText) findViewById(R.id.et_stu_name);
                et_father_name = (EditText) findViewById(R.id.et_father_name);
                et_phone = (EditText) findViewById(R.id.et_phone_no);
                et_degree_major = (EditText) findViewById(R.id.et_deg_major);
                et_address = (EditText) findViewById(R.id.et_address);
                et_stu_id = (EditText) findViewById(R.id.et_stu_id);
                et_password = (EditText) findViewById(R.id.et_password);

                DataBaseHandler db = new DataBaseHandler(AddStudent.this);
                Log.d("Insert: ", "Inserting ..");

                db.addStudent(new Student(
                        et_stu_name.getText().toString(),
                        et_father_name.getText().toString(),
                        et_phone.getText().toString(),
                        et_degree_major.getText().toString(),
                        et_address.getText().toString(),
                        et_stu_id.getText().toString(),
                        et_password.getText().toString()
                ));

                Toast.makeText(AddStudent.this, "Added", Toast.LENGTH_LONG).show();

            }
        });
    }
}