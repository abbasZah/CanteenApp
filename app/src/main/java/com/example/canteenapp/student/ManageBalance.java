package com.example.canteenapp.student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.canteenapp.R;

public class ManageBalance extends AppCompatActivity {

    Button btn_add_balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_balance);

        btn_add_balance = findViewById(R.id.btn_add_balance);

        btn_add_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageBalance.this, AddBalance.class);
                startActivity(i);
            }
        });

    }
}