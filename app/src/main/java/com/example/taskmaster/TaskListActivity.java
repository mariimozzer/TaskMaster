/*
 * File Name: TaskListActivity.java
 * Description: Get and Setter for tasks
 *
 * Project Revision:
 *      Mariana Mozzer Arantes, 2023.03.24: Created
 */



package com.example.taskmaster;
import java.util.Date;

public class TaskListActivity {


        private String name;
        private String description;
        private String date;
        private int priority;
        private String notes;

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

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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




