package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CanteenScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_screen);
        getSupportActionBar().hide();

        Intent i = getIntent();
        int canteen_id = i.getIntExtra("CANTEEN_ID", -1);
        Toast.makeText(getApplicationContext(),"CANTEEN_ID " + canteen_id, Toast.LENGTH_SHORT).show();

        final Button btn_item = (Button) findViewById(R.id.btn_item);

        btn_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CanteenScreen.this, ManageItems.class);
                startActivity(i);
            }
        });

    }
}