/*
 * File Name: ViewTasksActivity.java
 * Description: View Task retrieving tasks from database
 *
 * Project Revision:
 *      Mariana Mozzer Arantes, 2023.03.24: Created
 */


package com.example.taskmaster;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ViewTaskActivity extends AppCompatActivity {

    private ListView listView;
    private TaskListAdapter adapter;
    private List<TaskModel> taskList = new ArrayList<>();
    private TaskDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_tasks);

        listView = findViewById(R.id.taskList);
        databaseHelper = new TaskDatabaseHelper(this);

        // Retrieve data from database
        taskList = databaseHelper.getAllTasks();

        // Create and set adapter
        adapter = new TaskListAdapter(this, taskList);
        listView.setAdapter(adapter);
    }
}


