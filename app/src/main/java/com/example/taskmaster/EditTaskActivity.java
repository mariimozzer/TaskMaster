package com.example.taskmaster;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditTaskActivity extends AppCompatActivity {
    private EditText editName, editDescription, editDate, editPriority, editNotes;
    private Button btnEdit;
    private TaskDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_tasks);

        /*editName = findViewById(R.id.editName);
        editDescription = findViewById(R.id.editDescription);
        editDate = findViewById(R.id.editDate);
        editPriority = findViewById(R.id.editPriority);
        editNotes = findViewById(R.id.editNotes);
        btnEdit = findViewById(R.id.btnEdit);*/

        dbHelper = new TaskDatabaseHelper(this);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTask();
            }
        });
    }

    private void createTask() {
        /*String name = nameEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        String dueDate = dueDateEditText.getText().toString().trim();
        int priority = Integer.parseInt(priorityEditText.getText().toString().trim());
        String notes = notesEditText.getText().toString().trim();

        TaskModel task = new TaskModel();
        task.setName(name);
        task.setDescription(description);
        task.setDueDate(dueDate);
        task.setPriority(priority);
        task.setNotes(notes);

        dbHelper.addTask(task);

        Toast.makeText(this, "Task created successfully", Toast.LENGTH_SHORT).show();

        finish();*/
    }
}