package com.example.canteenapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);


        final EditText et_id = (EditText) findViewById(R.id.et_id);

        final Button btn_go = (Button) findViewById(R.id.btn_go);

        final EditText et_stu_name = (EditText) findViewById(R.id.et_stu_name);
        final EditText et_father_name = (EditText) findViewById(R.id.et_father_name);
        final EditText et_phone_no = (EditText) findViewById(R.id.et_phone_no);
        final EditText et_deg_major = (EditText) findViewById(R.id.et_deg_major);
        final EditText et_address = (EditText) findViewById(R.id.et_address);
        final EditText et_stu_id = (EditText) findViewById(R.id.et_stu_id);
        final EditText et_password = (EditText) findViewById(R.id.et_password);

        final TextView tv_stu_name = (TextView) findViewById(R.id.tv_stu_name);
        final TextView tv_father_name = (TextView) findViewById(R.id.tv_father_name);
        final TextView tv_phone_no = (TextView) findViewById(R.id.tv_phone);
        final TextView tv_deg_major = (TextView) findViewById(R.id.tv_deg_major);
        final TextView tv_address = (TextView) findViewById(R.id.tv_address);
        final TextView tv_stu_id = (TextView) findViewById(R.id.tv_stu_id);
        final TextView tv_password = (TextView) findViewById(R.id.tv_password);


        et_stu_name.setVisibility(View.INVISIBLE);
        et_father_name.setVisibility(View.INVISIBLE);
        et_phone_no.setVisibility(View.INVISIBLE);
        et_deg_major.setVisibility(View.INVISIBLE);
        et_address.setVisibility(View.INVISIBLE);
        et_stu_id.setVisibility(View.INVISIBLE);
        et_password.setVisibility(View.INVISIBLE);

        tv_stu_name.setVisibility(View.INVISIBLE);
        tv_father_name.setVisibility(View.INVISIBLE);
        tv_phone_no.setVisibility(View.INVISIBLE);
        tv_deg_major.setVisibility(View.INVISIBLE);
        tv_address.setVisibility(View.INVISIBLE);
        tv_stu_id.setVisibility(View.INVISIBLE);
        tv_password.setVisibility(View.INVISIBLE);

        //Start from Here


        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starting a new Intent
                final DatabaseHandler db = new DatabaseHandler(EditStudent.this);
                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfStudentExist(et_id.getText().toString());
                if (found) {
                    et_stu_name.setVisibility(View.VISIBLE);
                    et_father_name.setVisibility(View.VISIBLE);
                    et_phone_no.setVisibility(View.VISIBLE);
                    et_deg_major.setVisibility(View.VISIBLE);
                    et_address.setVisibility(View.VISIBLE);
                    et_stu_id.setVisibility(View.VISIBLE);
                    et_password.setVisibility(View.VISIBLE);

                    et_stu_id.setEnabled(false); //Can't change id

                    tv_stu_name.setVisibility(View.VISIBLE);
                    tv_father_name.setVisibility(View.VISIBLE);
                    tv_phone_no.setVisibility(View.VISIBLE);
                    tv_deg_major.setVisibility(View.VISIBLE);
                    tv_address.setVisibility(View.VISIBLE);
                    tv_stu_id.setVisibility(View.VISIBLE);
                    tv_password.setVisibility(View.VISIBLE);

                    final Student oldStudent = db.getStudent(et_id.getText().toString());

                    et_stu_name.setText(oldStudent.getStu_name().toString());
                    et_father_name.setText(oldStudent.getFather_name().toString());
                    et_phone_no.setText(oldStudent.getPhone().toString());
                    et_deg_major.setText(oldStudent.getDegree_major().toString());
                    et_address.setText(oldStudent.getAddress().toString());
                    et_stu_id.setText(oldStudent.getStu_id().toString());
                    et_password.setText(oldStudent.getPassword().toString());

                    Toast.makeText(getApplicationContext(), "Found Student",
                            Toast.LENGTH_SHORT).show();
                    // When user update
                    Button btn_update = findViewById(R.id.btn_update);
                    //Listening to button event
                    btn_update.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View arg0) {
                            db.updateStudent(new Student(
                                    oldStudent.getId(),
                                    et_stu_name.getText().toString(),
                                    et_father_name.getText().toString(),
                                    et_phone_no.getText().toString(),
                                    et_deg_major.getText().toString(),
                                    et_address.getText().toString(),
                                    et_stu_id.getText().toString(),
                                    et_password.getText().toString()

                            ));
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