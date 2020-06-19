package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteStudent extends AppCompatActivity {

    private Button btn_delete;
    private EditText et_delete_student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);


         btn_delete = (Button) findViewById(R.id.btn_delete);

        btn_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                et_delete_student = (EditText) findViewById(R.id.et_delete_student);

                DatabaseHandler db = new DatabaseHandler(DeleteStudent.this);

                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfStudentExist(et_delete_student.getText().toString());
                if(found)
                {
// deleting

                    Student student = new Student();

                    student.setId(Integer. parseInt(et_delete_student.getText().toString()));

                    db.deleteStudent(student);
                    Toast.makeText(getApplicationContext(), "Record Deleted",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Record Not Found",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}