package com.example.canteenapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditCanteen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_canteen);
        getSupportActionBar().setTitle("Update Canteen");

        final EditText et_id = (EditText) findViewById(R.id.et_id);

        final Button btn_go = (Button) findViewById(R.id.btn_go);
        final Button btn_update = (Button) findViewById(R.id.btn_update);

        final EditText et_management_name = (EditText) findViewById(R.id.et_management_name);
        final EditText et_handler_name = (EditText) findViewById(R.id.et_handler_name);
        final EditText et_phone_no = (EditText) findViewById(R.id.et_phone_no);
        final EditText et_no_of_workers = (EditText) findViewById(R.id.et_no_of_workers);
        final EditText et_address = (EditText) findViewById(R.id.et_address);
        final EditText et_username = (EditText) findViewById(R.id.et_username);
        final EditText et_password = (EditText) findViewById(R.id.et_password);

        final TextView tv_management_name = (TextView) findViewById(R.id.tv_management_name);
        final TextView tv_handler_name = (TextView) findViewById(R.id.tv_handler_name);
        final TextView tv_phone_no = (TextView) findViewById(R.id.tv_phone);
        final TextView tv_no_of_workers = (TextView) findViewById(R.id.tv_no_of_worker);
        final TextView tv_address = (TextView) findViewById(R.id.tv_address);
        final TextView tv_username = (TextView) findViewById(R.id.tv_username);
        final TextView tv_password = (TextView) findViewById(R.id.tv_password);


        et_management_name.setVisibility(View.INVISIBLE);
        et_handler_name.setVisibility(View.INVISIBLE);
        et_phone_no.setVisibility(View.INVISIBLE);
        et_no_of_workers.setVisibility(View.INVISIBLE);
        et_address.setVisibility(View.INVISIBLE);
        et_username.setVisibility(View.INVISIBLE);
        et_password.setVisibility(View.INVISIBLE);
        btn_update.setVisibility(View.INVISIBLE);


        tv_management_name.setVisibility(View.INVISIBLE);
        tv_handler_name.setVisibility(View.INVISIBLE);
        tv_phone_no.setVisibility(View.INVISIBLE);
        tv_no_of_workers.setVisibility(View.INVISIBLE);
        tv_address.setVisibility(View.INVISIBLE);
        tv_username.setVisibility(View.INVISIBLE);
        tv_password.setVisibility(View.INVISIBLE);

        //Start from Here


        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starting a new Intent
                final DatabaseHandler db = new DatabaseHandler(EditCanteen.this);
                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfExist(et_id.getText().toString());
                if (found) {
                    et_management_name.setVisibility(View.VISIBLE);
                    et_handler_name.setVisibility(View.VISIBLE);
                    et_phone_no.setVisibility(View.VISIBLE);
                    et_no_of_workers.setVisibility(View.VISIBLE);
                    et_address.setVisibility(View.VISIBLE);
                    et_username.setVisibility(View.VISIBLE);
                    et_password.setVisibility(View.VISIBLE);

                    btn_update.setVisibility(View.VISIBLE);

                    tv_management_name.setVisibility(View.VISIBLE);
                    tv_handler_name.setVisibility(View.VISIBLE);
                    tv_phone_no.setVisibility(View.VISIBLE);
                    tv_no_of_workers.setVisibility(View.VISIBLE);
                    tv_address.setVisibility(View.VISIBLE);
                    tv_username.setVisibility(View.VISIBLE);
                    tv_password.setVisibility(View.VISIBLE);

                    final Canteen oldCanteen = db.getCanteen(et_id.getText().toString());

                    et_management_name.setText(oldCanteen.getManagement_name().toString());
                    et_handler_name.setText(oldCanteen.getHandler_name().toString());
                    et_phone_no.setText(oldCanteen.getPhone_no().toString());
                    et_no_of_workers.setText(oldCanteen.getNo_of_workers().toString());
                    et_address.setText(oldCanteen.getAddress().toString());
                    et_username.setText(oldCanteen.getUsername().toString());
                    et_password.setText(oldCanteen.getPassword().toString());

                    Toast.makeText(getApplicationContext(), "Found Canteen",
                            Toast.LENGTH_SHORT).show();
                    // When user update
                    Button btn_update = findViewById(R.id.btn_update);
                    //Listening to button event
                    btn_update.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View arg0) {
                            db.updateCanteen(new Canteen(
                                    oldCanteen.getId(),
                                    et_management_name.getText().toString(),
                                    et_handler_name.getText().toString(),
                                    et_phone_no.getText().toString(),
                                    et_no_of_workers.getText().toString(),
                                    et_address.getText().toString(),
                                    et_username.getText().toString(),
                                    et_password.getText().toString()

                            ));
                            Toast.makeText(getApplicationContext(), "Record is Updated", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Not Found Canteen", Toast.LENGTH_SHORT).show();
                }
            }
    });


    }
}