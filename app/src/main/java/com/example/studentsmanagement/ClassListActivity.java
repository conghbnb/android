package com.example.studentsmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ClassListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_list);

        Button addBtn = findViewById(R.id.button1);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClassListActivity.this, AddClassActivity.class);
                ClassListActivity.this.startActivity(intent);
            }
        });

        DatabaseHelper databaseHelper = new DatabaseHelper(ClassListActivity.this);
        List<ClassModel> classes = databaseHelper.getAllClasses();

        ClassListViewAdapter classListViewAdapter = new ClassListViewAdapter(classes);
        ListView listView = findViewById(R.id.listView1);
        listView.setAdapter(classListViewAdapter);
    }
}
