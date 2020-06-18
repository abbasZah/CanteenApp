package com.example.canteenapp.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.canteenapp.R;
import com.example.canteenapp.canteen.Canteen;
import com.example.canteenapp.canteen.DatabaseHandler;
import com.example.canteenapp.canteen.EditCanteen;

public class AddBalance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_balance);


        final EditText et_id = (EditText) findViewById(R.id.et_id2);

        final Button btn_go = (Button) findViewById(R.id.btn_go2);

        final EditText et_add_balance = (EditText) findViewById(R.id.et_add_balance);



        et_add_balance.setVisibility(View.INVISIBLE);

        btn_go.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                //Starting a new Intent
                final DataBaseHandler db = new DataBaseHandler(AddBalance.this);
                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfExist(et_id.getText().toString());
                if (found) {
                    et_add_balance.setVisibility(View.VISIBLE);

                    final Student oldStudent = db.getStudent(et_id.getText().toString());

                    Toast.makeText(getApplicationContext(), "Found Canteen",
                            Toast.LENGTH_SHORT).show();
                    // When user update
                    Button btn_update = findViewById(R.id.btn_update);
                    //Listening to button event
                    btn_update.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View arg0) {

                            oldStudent.addBalance(Integer.parseInt(et_add_balance.getText().toString()));
                            db.updateStudent(oldStudent);

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