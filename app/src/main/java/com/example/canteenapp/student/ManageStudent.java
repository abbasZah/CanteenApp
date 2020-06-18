package com.example.canteenapp.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.canteenapp.R;


public class ManageStudent extends AppCompatActivity {

    Button btn_add;
    Button btn_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_student);

        btn_add = findViewById(R.id.btn_add);
        btn_show = findViewById(R.id.btn_show);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageStudent.this, AddStudent.class);
                startActivity(i);
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageStudent.this, ShowStudents.class);
                startActivity(i);
            }
        });
    }
}