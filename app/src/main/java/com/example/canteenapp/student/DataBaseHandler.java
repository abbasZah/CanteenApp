package com.example.canteenapp.student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {
    private static final int db_version = 1;
    private static final String db_name = "canteen_app";

    private static final String table_student = "student";
    private static final String stu_name = "stu_name";
    private static final String father_name = "father_name";
    private static final String phone_no = "phone_no";
    private static final String deg_major = "deg_major";
    private static final String address = "address";
    private static final String id = "id";
    private static final String password = "password";

    public DataBaseHandler(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
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
        db.execSQL("DROP TABLE IF EXISTS " + table_student);
        onCreate(db);
    }

    void addStudent(Student student) {
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





    boolean checkIfExist(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_student, new String[] {
                        id,
                        stu_name,
                        father_name,
                        phone_no,
                        deg_major,
                        address,
                        password }, id + "=?",
                new String[] { name }, null, null, null, null);
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
                student.setStu_id(cursor.getString(0));
                student.setStu_name(cursor.getString(1));
                student.setFather_name(cursor.getString(2));
                student.setPhone(cursor.getString(3));
                student.setDegree_major(cursor.getString(4));
                student.setAddress(cursor.getString(5));
                student.setPassword(cursor.getString(7));


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
                student.setPassword(cursor.getString(7));

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
