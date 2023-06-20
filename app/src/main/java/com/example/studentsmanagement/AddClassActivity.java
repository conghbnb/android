package com.example.studentsmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddClassActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_class);

        TextView nameTextView = findViewById(R.id.editTextTextPersonName3);
        TextView descTextView = findViewById(R.id.editTextTextMultiLine);
        Button addBtn = findViewById(R.id.button3);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassModel classModel = new ClassModel(-1, nameTextView.getText().toString(), descTextView.getText().toString());
                DatabaseHelper databaseHelper = new DatabaseHelper(AddClassActivity.this);
                databaseHelper.addClass(classModel);
                Intent intent = new Intent(AddClassActivity.this, ClassListActivity.class);
                AddClassActivity.this.startActivity(intent);
            }
        });
    }
}
