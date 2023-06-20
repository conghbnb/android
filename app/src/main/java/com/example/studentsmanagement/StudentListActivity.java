package com.example.studentsmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list);

        Button addBtn = findViewById(R.id.button);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentListActivity.this, AddStudentActivity.class);
                StudentListActivity.this.startActivity(intent);
            }
        });


        ListView listView = findViewById(R.id.listView);

        DatabaseHelper databaseHelper = new DatabaseHelper(StudentListActivity.this);
        List<StudentModel> students = databaseHelper.getAllStudents();

        StudentListViewAdapter studentsAdapter = new StudentListViewAdapter(students);
        listView.setAdapter(studentsAdapter);
    }
}
