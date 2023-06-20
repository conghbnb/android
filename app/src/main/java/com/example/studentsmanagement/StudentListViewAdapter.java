package com.example.studentsmanagement;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentListViewAdapter extends BaseAdapter {
    final List<StudentModel> listStudent;

    StudentListViewAdapter(List<StudentModel> listProduct) {
        this.listStudent = listProduct;
    }

    @Override
    public int getCount() {
        return listStudent.size();
    }

    @Override
    public Object getItem(int position) {
        return listStudent.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listStudent.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.student_view, null);
        } else viewProduct = convertView;

        StudentModel student = (StudentModel) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.nameTextView)).setText(student.getName());
        ((TextView) viewProduct.findViewById(R.id.textView)).setText("Năm sinh: " + String.valueOf(student.getDob()));
        ((TextView) viewProduct.findViewById(R.id.textView2)).setText("Quê quán: " + student.getHometown());
        ((TextView) viewProduct.findViewById(R.id.textView3)).setText("Năm học: " + student.getSchoolYear());
        return viewProduct;
    }
}
