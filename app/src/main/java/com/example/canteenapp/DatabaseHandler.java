package com.example.canteenapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.canteenapp.canteen.Canteen;
import com.example.canteenapp.student.Student;

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
    private static final String stu_name = "stu_name";
    private static final String father_name = "father_name";
    private static final String phone_no = "phone_no";
    private static final String deg_major = "deg_major";
    private static final String address = "address";
    private static final String id = "id";
    private static final String password = "password";




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
        String CREATE_Student_TABLE = "CREATE TABLE " + table_student + "("
                + id + " TEXT PRIMARY KEY,"
                + stu_name + " TEXT,"
                + father_name + " TEXT,"
                + phone_no + " TEXT,"
                + deg_major + " TEXT,"
                + address + " TEXT,"
                + password + " TEXT" + ")";
        db.execSQL(CREATE_Student_TABLE);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + table_canteen);
        db.execSQL("DROP TABLE IF EXISTS " + table_student);

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

    public boolean checkIfExist(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_canteen, new String[] { col_c_id,
                        col_c_management_name,
                        col_c_handler_name,
                        col_c_phone_no,
                        col_c_no_of_workers,
                        col_c_address,
                        col_c_username,
                        col_c_password }, col_c_id + "=?",
                new String[] { name }, null, null, null, null);
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
                new String[] { Integer.toString(canteen.getId()) });
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
                new String[] { String.valueOf(canteen.getId()) });
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////    Student Functions//////////////------------------------///////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(id, student.getStu_id());
        values.put(stu_name, student.getStu_name());
        values.put(father_name, student.getFather_name());
        values.put(phone_no, student.getPhone());
        values.put(deg_major, student.getDegree_major());
        values.put(address, student.getAddress());
        values.put(password, student.getPassword());

        long newRow = db.insert(table_student, null, values);
        Log.d("NewRowAdded", "" + newRow);
        db.close();
    }





//    public boolean checkIfExist(String name) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query(table_student, new String[] {
//                        id,
//                        stu_name,
//                        father_name,
//                        phone_no,
//                        deg_major,
//                        address,
//                        password }, id + "=?",
//                new String[] { name }, null, null, null, null);
//        if (cursor.getCount() > 0)
//            return true;
//        else
//            return false;
//
//    }






    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<Student>();
        String selectQuery = "SELECT * FROM " + table_student;
        SQLiteDatabase db = this.getWritableDatabase();
//        Log.d("Nammmme", db.isOpen()+"");
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {


                Student student = new Student();
                student.setStu_id(cursor.getString(0));
                student.setStu_name(cursor.getString(1));
                student.setFather_name(cursor.getString(2));
                student.setPhone(cursor.getString(3));
                student.setDegree_major(cursor.getString(4));
                student.setAddress(cursor.getString(5));
                student.setPassword(cursor.getString(6));


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
                student.setStu_id(cursor.getString(0));
                student.setStu_name(cursor.getString(1));
                student.setFather_name(cursor.getString(2));
                student.setPhone(cursor.getString(3));
                student.setDegree_major(cursor.getString(4));
                student.setAddress(cursor.getString(5));
                student.setPassword(cursor.getString(6));

                return student;
            } while (cursor.moveToNext());
        }

        return null;

    }

    public void deleteStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(table_student, id + " = ?",
                new String[] { student.getStu_id() });
        db.close();

    }




    //Start from Here

    public int updateStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(id, student.getStu_id());
        values.put(stu_name, student.getStu_name());
        values.put(father_name, student.getFather_name());
        values.put(phone_no, student.getPhone());
        values.put(deg_major, student.getDegree_major());
        values.put(address, student.getAddress());
        values.put(password, student.getPassword());


        return db.update(table_student, values, id + " = ?",
                new String[] { String.valueOf(student.getStu_id()) });
    }


}
