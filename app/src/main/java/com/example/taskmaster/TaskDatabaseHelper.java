/*
 * File Name: TaskDatabaseHelper.java
 * Description: Create Data, Table and Database inside SQLLite
 *
 * Project Revision:
 *      Guilherme Medes Cunha Bueno, 2023.03.16: Created
 */


package com.example.taskmaster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class TaskDatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TaskDatabase.db";

    private static final String TABLE_NAME = "tasks";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_DUE_DATE = "due_date";
    private static final String COLUMN_PRIORITY = "priority";
    private static final String COLUMN_NOTES = "notes";

    public TaskDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT,"
                + COLUMN_DUE_DATE + " TEXT,"
                + COLUMN_PRIORITY + " INTEGER,"
                + COLUMN_NOTES + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addTask(TaskModel task) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, task.getName());
        values.put(COLUMN_DESCRIPTION, task.getDescription());
        values.put(COLUMN_DUE_DATE, task.getDueDate());
        values.put(COLUMN_PRIORITY, task.getPriority());
        values.put(COLUMN_NOTES, task.getNotes());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<TaskModel> getAllTasks() {
        List<TaskModel> tasks = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                TaskModel task = new TaskModel();
                task.setId(Integer.parseInt(cursor.getString(0)));
                task.setName(cursor.getString(1));
                task.setDescription(cursor.getString(2));
                task.setDueDate(cursor.getString(3));
                task.setPriority(Integer.parseInt(cursor.getString(4)));
                task.setNotes(cursor.getString(5));
                tasks.add(task);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return tasks;
    }

    public TaskModel getTaskById(int taskId) {
        TaskModel task = null;

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = " + taskId;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            task = new TaskModel();
            task.setId(Integer.parseInt(cursor.getString(0)));
            task.setName(cursor.getString(1));
            task.setDescription(cursor.getString(2));
            task.setDueDate(cursor.getString(3));
            task.setPriority(Integer.parseInt(cursor.getString(4)));
            task.setNotes(cursor.getString(5));
        }

        cursor.close();
        db.close();

        return task;
    }


    public void updateTask(TaskModel task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, task.getName());
        values.put(COLUMN_DESCRIPTION, task.getDescription());
        values.put(COLUMN_DUE_DATE, task.getDueDate());
        values.put(COLUMN_PRIORITY, task.getPriority());
        values.put(COLUMN_NOTES, task.getNotes());
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[] { String.valueOf(task.getId()) });
        db.close();
    }

    public void deleteTask(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(id) });
        db.close();
    }

}
