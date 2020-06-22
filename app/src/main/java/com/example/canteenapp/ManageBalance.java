package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManageBalance extends AppCompatActivity {

    Button btn_add_balance;
    Button btn_withdraw_balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_balance);
        getSupportActionBar().hide();

        btn_add_balance = findViewById(R.id.btn_add_balance);
        btn_withdraw_balance = findViewById(R.id.btn_withdraw_balance);

        btn_add_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageBalance.this, AddBalance.class);
                startActivity(i);
            }
        });
        btn_withdraw_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ManageBalance.this, WithdrawBalance.class);
                startActivity(i);
            }
        });

    }
}