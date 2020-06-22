package com.example.canteenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        final DatabaseHandler databaseHandler = new DatabaseHandler(Login.this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Canteen canteen = databaseHandler.isCanteenHandler(et_username.getText().toString(), et_password.getText().toString());

                if(et_username.getText().toString().equals(admin.getUsername()) && et_password.getText().toString().equals(admin.getPassword()) )
                {
                    Toast.makeText(getApplicationContext(), "Logged in Successfully ! ", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, AdminScreen.class);
                    startActivity(i);
                }
                else if(canteen != null)
                {
                    Toast.makeText(getApplicationContext(),"Canteen", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, CanteenScreen.class);
                    i.putExtra("CANTEEN_ID", canteen.getId());
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

//Commit test
    }

}