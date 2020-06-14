package com.example.canteenapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int db_version = 1;
    private static final String db_name = "canteen_app";

    private static final String table_canteens = "canteens";
    private static final String col_c_id = "id";
    private static final String col_c_management_name = "management_name";
    private static final String col_c_handler_name = "handler_name";
    private static final String col_c_phone_no = "phone_no";
    private static final String col_c_no_of_workers = "no_of_workers";
    private static final String col_c_address = "address";
    private static final String col_c_username = "username";
    private static final String col_c_password = "password";


    public DatabaseHandler(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ table_canteens + "("
                + col_c_id + "INT PRIMARY KEY, "
                + col_c_management_name + "TEXT, "
                + col_c_handler_name + "TEXT, "
                + col_c_phone_no + "TEXT, "
                + col_c_no_of_workers + "INT, "
                + col_c_address + "TEXT, "
                + col_c_username + "TEXT, "
                + col_c_password + "TEXT"
                + ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    void addCanteen(Canteen canteen){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(col_c_management_name,canteen.getManagement_name());
        values.put(col_c_handler_name,canteen.getHandler_name());
        values.put(col_c_phone_no,canteen.getPhone_no());
        values.put(col_c_no_of_workers,canteen.getNo_of_workers());
        values.put(col_c_address,canteen.getAddress());
        values.put(col_c_username,canteen.getUsername());
        values.put(col_c_password,canteen.getPassword());

        db.insert(table_canteens,null, values);
        db.close();

    }

}
