package com.example.studentsmanagement;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ClassListViewAdapter extends BaseAdapter {
    final List<ClassModel> listClass;

    ClassListViewAdapter(List<ClassModel> listClass) {
        this.listClass = listClass;
    }

    @Override
    public int getCount() {
        return listClass.size();
    }

    @Override
    public Object getItem(int position) {
        return listClass.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listClass.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewClass;
        if (convertView == null) {
            viewClass = View.inflate(parent.getContext(), R.layout.class_view, null);
        } else viewClass = convertView;

        ClassModel classModel = (ClassModel) getItem(position);

        ((TextView) viewClass.findViewById(R.id.textView4)).setText(classModel.getName());
        ((TextView) viewClass.findViewById(R.id.textView5)).setText(classModel.getDesc());

        return viewClass;
    }
}
