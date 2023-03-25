/*
 * File Name: TaskListAdapter.java
 * Description: Setting list adapter for list view
 *
 * Project Revision:
 *      Mariana Mozzer Arantes, 2023.03.24: Created
 */



package com.example.taskmaster;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TaskListAdapter extends ArrayAdapter<TaskModel> {

    private LayoutInflater layoutInflater;

    public TaskListAdapter(Context context, List<TaskModel> taskList) {
        super(context, 0, taskList);
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_row_tasks, parent, false);
        }

        // Get task at position
        TaskModel task = getItem(position);

        // Populate views with task data
        TextView taskName = convertView.findViewById(R.id.name);
        taskName.setText(task.getName());

        TextView taskDescription = convertView.findViewById(R.id.description);
        taskDescription.setText(task.getDescription());

        TextView taskDueDate = convertView.findViewById(R.id.date);
        taskDueDate.setText(task.getDueDate());

        return convertView;
    }
}