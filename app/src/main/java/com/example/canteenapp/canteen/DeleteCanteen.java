package com.example.canteenapp.canteen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.canteenapp.R;

public class DeleteCanteen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_canteen);

        Button btn_delete = (Button) findViewById(R.id.btn_delete);

        btn_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                EditText et_delete_canteen = (EditText) findViewById(R.id.et_delete_canteen);

                DatabaseHandler db = new DatabaseHandler(DeleteCanteen.this);

                Log.d("deleting: ", "Deleting ..");
                boolean found =
                        db.checkIfExist((et_delete_canteen.getText().toString()));
                if(found)
                {
// deleting

                    Canteen canteen = new Canteen();

                    canteen.setId(Integer. parseInt(et_delete_canteen.getText().toString()));
                    db.deleteCanteen(canteen);
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