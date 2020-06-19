package com.example.canteenapp.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.canteenapp.DatabaseHandler;
import com.example.canteenapp.R;

import java.util.List;

public class ShowStudents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);


        DatabaseHandler db = new DatabaseHandler(this);


        Log.d("Reading: ", db.getDatabaseName());
        List<Student> students = db.getAllStudents();
        String log=null;
        String [] student_array = new String[students.size()];
        int i=0;
        for (Student cn : students) {
            student_array[i] = "Id: " + cn.getId() + "\nStudent Name: " + cn.getFather_name() +"\nFather Name: "+ cn.getFather_name() + "\nPhone No: " + cn.getPhone()
                    + "\nDegree: " + cn.getDegree_major() + "\nAddress: " + cn.getAddress() +"\nUser id: "+ cn.getStu_id() + "\nPassword: " + cn.getPassword()
            ;
            log = log + "Id: " + cn.getId() + " ,Name: " + cn.getFather_name() + " ,Phone: " + cn.getPhone();

            Log.d("Name: ", log);
            i++;
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, student_array);
        ListView listView = (ListView) findViewById(R.id.lv_student_list);
        listView.setAdapter(adapter);

    }


}