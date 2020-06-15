package com.example.canteenapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int db_version = 1;
    private static final String db_name = "canteen_app";

    private static final String table_canteen = "canteens";
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
        String CREATE_CHEFS_TABLE = "CREATE TABLE " + table_canteen + "("
                + col_c_id + " INTEGER PRIMARY KEY,"
                + col_c_management_name + " TEXT,"
                + col_c_handler_name + " TEXT,"
                + col_c_phone_no + " TEXT,"
                + col_c_no_of_workers + " TEXT,"
                + col_c_address + " TEXT,"
                + col_c_username + " TEXT,"
                + col_c_password + " TEXT" + ")";
        db.execSQL(CREATE_CHEFS_TABLE);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_canteen);
        onCreate(db);
    }




    void addCanteen(Canteen con) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(col_c_management_name, con.getManagement_name());
        values.put(col_c_handler_name, con.getHandler_name());
        values.put(col_c_phone_no, con.getPhone_no());
        values.put(col_c_no_of_workers, con.getNo_of_workers());
        values.put(col_c_address, con.getAddress());
        values.put(col_c_username, con.getUsername());
        values.put(col_c_password, con.getPassword());

        db.insert(table_canteen, null, values);
        db.close();
    }



/*

    boolean checkIfExist(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_canteen, new String[] { col_c_id,
                        col_c_NAME, col_c_PH_NO }, col_c_PH_NO + "=?",
                new String[] { name }, null, null, null, null);
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }


*/



    public List<Canteen> getAllCanteens() {
        List<Canteen> chefList = new ArrayList<Canteen>();
        String selectQuery = "SELECT * FROM " + table_canteen;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Canteen chef = new Canteen();
                chef.setId(Integer.parseInt(cursor.getString(0)));
                chef.setManagement_name(cursor.getString(1));
                chef.setHandler_name(cursor.getString(2));
                chef.setPhone_no(cursor.getString(3));
                chef.setNo_of_workers(cursor.getString(4));
                chef.setAddress(cursor.getString(5));
                chef.setUsername(cursor.getString(6));
                chef.setPassword(cursor.getString(7));


                chefList.add(chef);
            } while (cursor.moveToNext());
        }

        return chefList;
    }











}
