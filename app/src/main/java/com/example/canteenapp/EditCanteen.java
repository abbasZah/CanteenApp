package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditCanteen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_canteen);


        final EditText et_id = (EditText) findViewById(R.id.et_id);

        Button btn_go = (Button) findViewById(R.id.btn_go);

        /*

        //Start from Here


        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




        }
    });

         */

    }
}