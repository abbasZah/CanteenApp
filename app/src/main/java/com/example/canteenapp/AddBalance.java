package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddBalance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);



        final EditText et_id = (EditText) findViewById(R.id.et_id);
        final TextView textView16 = (TextView) findViewById(R.id.textView16);

        final Button btn_go = (Button) findViewById(R.id.btn_go);

        final EditText et_add_balance = (EditText) findViewById(R.id.et_add_balance);



        et_add_balance.setVisibility(View.INVISIBLE);
        textView16.setVisibility(View.INVISIBLE);

        btn_go.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //Starting a new Intent
                final DatabaseHandler db = new DatabaseHandler(AddBalance.this);

                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfStudentExist(et_id.getText().toString());

                if (found) {

                    et_add_balance.setVisibility(View.VISIBLE);
                    textView16.setVisibility(View.VISIBLE);

                    final Student oldStudent = db.getStudent(et_id.getText().toString());


                    Toast.makeText(getApplicationContext(), "Found Student",
                            Toast.LENGTH_SHORT).show();
                    // When user update

                    Button button = findViewById(R.id.button);
                    //Listening to button event

                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View arg0) {

                            oldStudent.addBalance(Integer.parseInt(et_add_balance.getText().toString()));
                            db.updateStudent(oldStudent);

                            Toast.makeText(getApplicationContext(), "Record is Updated", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Not Found Student", Toast.LENGTH_SHORT).show();
                }
            }


        });







    }
}