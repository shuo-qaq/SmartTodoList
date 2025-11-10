package com.example.smarttodolist;

public class TaskData {
    private String title;
    private String description;
    private String dueDate;
    private String category;
    private String priority;
    private String completed;

    public TaskData() {}

    public TaskData(String title, String description, String dueDate,
                    String category, String priority, String completed) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.category = category;
        this.priority = priority;
        this.completed = completed;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getCompleted() { return completed; }
    public void setCompleted(String completed) { this.completed = completed; }
}
