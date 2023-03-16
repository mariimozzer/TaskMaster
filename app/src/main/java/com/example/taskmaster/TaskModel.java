/*
 * File Name: TaskModel.java
 * Description: Task Data Model for SQLLite Database
 *
 * Project Revision:
 *      Guilherme Medes Cunha Bueno, 2023.03.16: Created
 */

package com.example.taskmaster;

public class TaskModel {
    private int id;
    private String name;
    private String description;
    private String dueDate;
    private int priority;
    private String notes;

    public TaskModel() {
    }

    public TaskModel(int id, String name, String description, String dueDate, int priority, String notes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
