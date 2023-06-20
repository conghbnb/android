package com.example.studentsmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String STUDENT_TABLE = "STUDENT";
    public static final String CLASS_TABLE = "CLASS";
    public static final String STUDENT_CLASS_TABLE = "STUDENT_CLASS";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_HOMETOWN = "hometown";
    public static final String COLUMN_SCHOOL_YEAR = "schoolYear";
    public static final String COLUMN_DESC = "description";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStudentTableStatement = "create table " + STUDENT_TABLE + " (id integer primary key autoincrement, " + COLUMN_NAME + " text, "
                + COLUMN_DOB + " integer, " + COLUMN_HOMETOWN + " string, " + COLUMN_SCHOOL_YEAR + " integer)";

        String createClassTableStatement = "create table " + CLASS_TABLE + " (id integer primary key autoincrement, " + COLUMN_NAME + " text, " + COLUMN_DESC + " integer)";

        String createStudentClassTableStatement = "create table " + STUDENT_CLASS_TABLE + " (student_id integer not null, class_id integer not null , PRIMARY KEY (student_id, class_id) , FOREIGN KEY (student_id) REFERENCES " + STUDENT_TABLE + " (id), FOREIGN KEY (class_id) REFERENCES " + CLASS_TABLE + " (id))";

        db.execSQL(createStudentTableStatement);
        db.execSQL(createClassTableStatement);
        db.execSQL(createStudentClassTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addStudent(StudentModel studentModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, studentModel.getName());
        cv.put(COLUMN_HOMETOWN, studentModel.getHometown());
        cv.put(COLUMN_DOB, studentModel.getDob());
        cv.put(COLUMN_SCHOOL_YEAR, studentModel.getSchoolYear());

        long insert = db.insert(STUDENT_TABLE, null, cv);
        return insert != -1;
    }

    public List<StudentModel> getAllStudents() {
        List<StudentModel> returnList = new ArrayList<StudentModel>();
        String query = "SELECT * FROM " + STUDENT_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int dob = cursor.getInt(2);
                String hometown = cursor.getString(3);
                String schoolYear = cursor.getString(4);
                returnList.add(new StudentModel(id, name, dob, hometown, schoolYear));
            } while (cursor.moveToNext());
        }
        return returnList;

    }

    public boolean addClass(ClassModel classModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, classModel.getName());
        cv.put(COLUMN_DESC, classModel.getDesc());

        long insert = db.insert(CLASS_TABLE, null, cv);
        return insert != -1;
    }

    public  List<ClassModel> getAllClasses() {
        List<ClassModel> returnList = new ArrayList<ClassModel>();

        String query = "SELECT * FROM " + CLASS_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor  = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String desc = cursor.getString(2);
                returnList.add(new ClassModel(id, name, desc));
            } while (cursor.moveToNext());
        }

        return returnList;
    }
}
