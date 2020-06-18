package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        final Admin admin = new Admin("admin","123","Ali");

        final EditText et_username = findViewById(R.id.et_username);
        final EditText et_password = findViewById(R.id.et_password);
        Button btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*
                if(et_username.getText().toString().equals(admin.getUsername()) && et_password.getText().toString().equals(admin.getPassword()) )
                {*/
                    Toast.makeText(getApplicationContext(),"Logged in. Successfully ! ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, AdminScreen.class);
                    startActivity(i);
                /*}
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Attempt ! ", Toast.LENGTH_SHORT).show();
                }
*/
            }
        });

//Commit test
    }
}