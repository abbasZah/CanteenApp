package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);

        Button btn_canteen = findViewById(R.id.btn_canteen);
        Button btn_student = findViewById(R.id.btn_student);
        Button btn_balance = findViewById(R.id.btn_balance);

        btn_canteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminScreen.this, ManageCanteen.class);
                startActivity(i);
            }
        });

        btn_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminScreen.this, ManageStudent.class);
                startActivity(i);
            }
        });

        btn_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminScreen.this, ManageBalance.class);
                startActivity(i);
            }
        });

    }
}