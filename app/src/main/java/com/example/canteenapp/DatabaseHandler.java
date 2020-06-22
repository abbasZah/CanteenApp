package com.example.canteenapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int db_version = 1;
    private static final String db_name = "canteen_app";

    //Canteen Table name and Columns Names
    private static final String table_canteen = "canteens";
    private static final String col_c_id = "id";
    private static final String col_c_management_name = "management_name";
    private static final String col_c_handler_name = "handler_name";
    private static final String col_c_phone_no = "phone_no";
    private static final String col_c_no_of_workers = "no_of_workers";
    private static final String col_c_address = "address";
    private static final String col_c_username = "username";
    private static final String col_c_password = "password";

    //Student Table name and Columns Names
    private static final String table_student = "student";
    private static final String col_s_id = "id";
    private static final String col_s_stu_name = "stu_name";
    private static final String col_s_father_name = "father_name";
    private static final String col_s_phone_no = "phone_no";
    private static final String col_s_deg_major = "deg_major";
    private static final String col_s_address = "address";
    private static final String col_s_stu_id = "stu_id";
    private static final String col_s_password = "password";
    private static final String col_s_balance = "balance";

    //Item Table name and Columns Names
    private static final String table_item = "item";
    private static final String col_item_id = "id";
    private static final String col_item_name = "item_name";
    private static final String col_item_desc = "item_desc";
    private static final String col_item_cost = "item_cost";
    private static final String col_item_time_to_get_ready = "deg_major";


    public DatabaseHandler(Context context) {
        super(context, db_name, null, db_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creates Canteen Table
        String CREATE_CANTEENS_TABLE = "CREATE TABLE " + table_canteen + "("
                + col_c_id + " INTEGER PRIMARY KEY,"
                + col_c_management_name + " TEXT,"
                + col_c_handler_name + " TEXT,"
                + col_c_phone_no + " TEXT,"
                + col_c_no_of_workers + " TEXT,"
                + col_c_address + " TEXT,"
                + col_c_username + " TEXT,"
                + col_c_password + " TEXT" + ")";
        db.execSQL(CREATE_CANTEENS_TABLE);

        //Creates Student Table
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " + table_student + "("
                + col_s_id + " INTEGER PRIMARY KEY,"
                + col_s_stu_name + " TEXT,"
                + col_s_father_name + " TEXT,"
                + col_s_phone_no + " TEXT,"
                + col_s_deg_major + " TEXT,"
                + col_s_address + " TEXT,"
                + col_s_stu_id + " TEXT,"
                + col_s_password + " TEXT,"
                + col_s_balance + " TEXT" + ")";
        db.execSQL(CREATE_STUDENTS_TABLE);


        //Creates Item Table
        String CREATE_ITEM_TABLE = "CREATE TABLE " + table_item + "("
                + col_item_id + " INTEGER PRIMARY KEY,"
                + col_item_name + " TEXT,"
                + col_item_desc + " TEXT,"
                + col_item_cost + " TEXT,"
                + col_item_time_to_get_ready + " TEXT )";
        db.execSQL(CREATE_ITEM_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_canteen);
        db.execSQL("DROP TABLE IF EXISTS " + table_student);
        db.execSQL("DROP TABLE IF EXISTS " + table_item);

        onCreate(db);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////    Canteen Functions//////////////------------------------///////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void addCanteen(Canteen canteen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(col_c_management_name, canteen.getManagement_name());
        values.put(col_c_handler_name, canteen.getHandler_name());
        values.put(col_c_phone_no, canteen.getPhone_no());
        values.put(col_c_no_of_workers, canteen.getNo_of_workers());
        values.put(col_c_address, canteen.getAddress());
        values.put(col_c_username, canteen.getUsername());
        values.put(col_c_password, canteen.getPassword());

        long newRow = db.insert(table_canteen, null, values);
        Log.d("NewRowAdded", "" + newRow);
        db.close();
    }

    public boolean checkIfExist(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_canteen, new String[]{col_c_id,
                        col_c_management_name,
                        col_c_handler_name,
                        col_c_phone_no,
                        col_c_no_of_workers,
                        col_c_address,
                        col_c_username,
                        col_c_password}, col_c_id + "=?",
                new String[]{id}, null, null, null, null);
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public List<Canteen> getAllCanteens() {
        List<Canteen> canteenList = new ArrayList<Canteen>();
        String selectQuery = "SELECT * FROM " + table_canteen;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {


                Canteen canteen = new Canteen();
                canteen.setId(Integer.parseInt(cursor.getString(0)));
                canteen.setManagement_name(cursor.getString(1));
                canteen.setHandler_name(cursor.getString(2));
                canteen.setPhone_no(cursor.getString(3));
                canteen.setNo_of_workers(cursor.getString(4));
                canteen.setAddress(cursor.getString(5));
                canteen.setUsername(cursor.getString(6));
                canteen.setPassword(cursor.getString(7));


                canteenList.add(canteen);
            } while (cursor.moveToNext());
        }

        return canteenList;
    }

    public Canteen getCanteen(String id) {

        String selectQuery = "SELECT * FROM " + table_canteen + " WHERE id = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {

                Canteen canteen = new Canteen();
                canteen.setId(Integer.parseInt(cursor.getString(0)));
                canteen.setManagement_name(cursor.getString(1));
                canteen.setHandler_name(cursor.getString(2));
                canteen.setPhone_no(cursor.getString(3));
                canteen.setNo_of_workers(cursor.getString(4));
                canteen.setAddress(cursor.getString(5));
                canteen.setUsername(cursor.getString(6));
                canteen.setPassword(cursor.getString(7));

                return canteen;
            } while (cursor.moveToNext());
        }

        return null;

    }

    public void deleteCanteen(Canteen canteen) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_canteen, col_c_id + " = ?",
                new String[]{Integer.toString(canteen.getId())});
        db.close();

    }

    public int updateCanteen(Canteen canteen) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(col_c_management_name, canteen.getManagement_name());
        values.put(col_c_handler_name, canteen.getHandler_name());
        values.put(col_c_phone_no, canteen.getPhone_no());
        values.put(col_c_no_of_workers, canteen.getNo_of_workers());
        values.put(col_c_address, canteen.getAddress());
        values.put(col_c_username, canteen.getUsername());
        values.put(col_c_password, canteen.getPassword());


        return db.update(table_canteen, values, col_c_id + " = ?",
                new String[]{String.valueOf(canteen.getId())});
    }

    public Canteen isCanteenHandler(String username, String password) {

        String selectQuery = "SELECT * FROM " + table_canteen + " WHERE username = " + username + " AND password = " + password;
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {

                do {

                    Canteen canteen = new Canteen();
                    canteen.setId(Integer.parseInt(cursor.getString(0)));
                    canteen.setManagement_name(cursor.getString(1));
                    canteen.setHandler_name(cursor.getString(2));
                    canteen.setPhone_no(cursor.getString(3));
                    canteen.setNo_of_workers(cursor.getString(4));
                    canteen.setAddress(cursor.getString(5));
                    canteen.setUsername(cursor.getString(6));
                    canteen.setPassword(cursor.getString(7));

                    return canteen;
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////    Student Functions//////////////------------------------///////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(col_s_stu_name, student.getStu_name());
        values.put(col_s_father_name, student.getFather_name());
        values.put(col_s_phone_no, student.getPhone());
        values.put(col_s_deg_major, student.getDegree_major());
        values.put(col_s_address, student.getAddress());
        values.put(col_s_stu_id, student.getStu_id());
        values.put(col_s_password, student.getPassword());
        values.put(col_s_balance, student.getBalance());

        long newRow = db.insert(table_student, null, values);
        Log.d("NewRowAdded", "" + newRow);
        db.close();
    }


    public boolean checkIfStudentExist(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_student, new String[]{col_s_id,
                        col_s_stu_name,
                        col_s_father_name,
                        col_s_phone_no,
                        col_s_deg_major,
                        col_s_address,
                        col_s_stu_id,
                        col_s_password,
                        col_s_balance}, col_s_id + "=?",
                new String[]{id}, null, null, null, null);
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }


    public List<Student> getAllStudents() {

        List<Student> studentList = new ArrayList<Student>();
        String selectQuery = "SELECT * FROM " + table_student;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setStu_name(cursor.getString(1));
                student.setFather_name(cursor.getString(2));
                student.setPhone(cursor.getString(3));
                student.setDegree_major(cursor.getString(4));
                student.setAddress(cursor.getString(5));
                student.setStu_id(cursor.getString(6));
                student.setPassword(cursor.getString(7));
                student.setBalance(Double.parseDouble(cursor.getString(8)));

                studentList.add(student);
            } while (cursor.moveToNext());
        }

        return studentList;
    }


    public Student getStudent(String id) {

        String selectQuery = "SELECT * FROM " + table_student + " WHERE id = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {

                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setStu_name(cursor.getString(1));
                student.setFather_name(cursor.getString(2));
                student.setPhone(cursor.getString(3));
                student.setDegree_major(cursor.getString(4));
                student.setAddress(cursor.getString(5));
                student.setStu_id(cursor.getString(6));
                student.setPassword(cursor.getString(7));
                student.setBalance(Double.parseDouble(cursor.getString(8)));

                return student;
            } while (cursor.moveToNext());
        }

        return null;

    }

    public void deleteStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_student, col_s_id + " = ?",
                new String[]{Integer.toString(student.getId())});
        db.close();

    }




    //Start from Here

    public int updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();



        values.put(col_s_stu_name, student.getStu_name());
        values.put(col_s_father_name, student.getFather_name());
        values.put(col_s_phone_no, student.getPhone());
        values.put(col_s_deg_major, student.getDegree_major());
        values.put(col_s_address, student.getAddress());
        values.put(col_s_stu_id, student.getStu_id());
        values.put(col_s_password, student.getPassword());
        values.put(col_s_balance, student.getBalance());

        return db.update(table_student, values, col_s_id + " = ?",
                new String[]{String.valueOf(student.getId())});

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////    Item Functions//////////////------------------------///////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void addItem(FoodItem item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(col_item_id, item.getItem_id());
        values.put(col_item_name, item.getFood_name());
        values.put(col_item_desc, item.getItem_desc());
        values.put(col_item_cost, item.getCost());
        values.put(col_item_time_to_get_ready, item.getTime_to_get_ready());

        long newRow = db.insert(table_item, null, values);
        Log.d("NewRowAdded", "" + newRow);
        db.close();
    }

    public List<FoodItem> getAllItems() {

        List<FoodItem> itemList = new ArrayList<FoodItem>();
        String selectQuery = "SELECT * FROM " + table_item;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                FoodItem item = new FoodItem();
                item.setItem_id(Integer.parseInt(cursor.getString(0)));
                item.setFood_name(cursor.getString(1));
                item.setItem_desc(cursor.getString(2));
                item.setCost(cursor.getString(3));
                item.setTime_to_get_ready(cursor.getString(4));

                itemList.add(item);
            } while (cursor.moveToNext());
        }

        return itemList;
    }

}