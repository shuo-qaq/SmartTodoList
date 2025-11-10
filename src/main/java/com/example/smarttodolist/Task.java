package com.example.smarttodolist;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Task {
    private final StringProperty title;
    private final StringProperty description;
    private final StringProperty dueDate;
    private final StringProperty category;
    private final StringProperty priority;
    private final StringProperty completed;

    public Task(String title, String description, String dueDate,
                String category, String priority, String completed) {
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.category = new SimpleStringProperty(category);
        this.priority = new SimpleStringProperty(priority);
        this.completed = new SimpleStringProperty(completed);
    }

    // === Property ===
    public StringProperty titleProperty() { return title; }
    public StringProperty descriptionProperty() { return description; }
    public StringProperty dueDateProperty() { return dueDate; }
    public StringProperty categoryProperty() { return category; }
    public StringProperty priorityProperty() { return priority; }
    public StringProperty completedProperty() { return completed; }

    // === Getter / Setter ===
    public String getTitle() { return title.get(); }
    public void setTitle(String t) { title.set(t); }

    public String getDescription() { return description.get(); }
    public void setDescription(String d) { description.set(d); }

    public String getDueDate() { return dueDate.get(); }
    public void setDueDate(String d) { dueDate.set(d); }

    public String getCategory() { return category.get(); }
    public void setCategory(String c) { category.set(c); }

    public String getPriority() { return priority.get(); }
    public void setPriority(String p) { priority.set(p); }

    public String getCompleted() { return completed.get(); }
    public void setCompleted(String c) { completed.set(c); }
}
