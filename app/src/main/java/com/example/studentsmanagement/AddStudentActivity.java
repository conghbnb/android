package com.example.studentsmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {
    EditText fullNameEditText, yearBirthEditText, hometownEditText, schoolYearEditText;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);

        DatabaseHelper databaseHelper = new DatabaseHelper(AddStudentActivity.this);

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Năm một", "Năm hai", "Năm ba", "Năm bốn"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        fullNameEditText = findViewById(R.id.editTextTextPersonName);
        yearBirthEditText = findViewById(R.id.editTextDate);
        hometownEditText = findViewById(R.id.editTextTextPersonName2);

        addBtn = findViewById(R.id.button2);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentModel student = new StudentModel(-1, fullNameEditText.getText().toString(), Integer.parseInt(yearBirthEditText.getText().toString()), hometownEditText.getText().toString(), dropdown.getSelectedItem().toString());
                databaseHelper.addStudent(student);

                Intent intent = new Intent(AddStudentActivity.this, StudentListActivity.class);
                AddStudentActivity.this.startActivity(intent);
            }
        });

    }
}
