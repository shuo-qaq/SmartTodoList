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

    // === 构造函数 ===
    public Task(String title, String description, String dueDate, String category, String priority, String completed) {
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.category = new SimpleStringProperty(category);
        this.priority = new SimpleStringProperty(priority);
        this.completed = new SimpleStringProperty(completed);
    }

    // === Getter / Setter for Property ===
    public StringProperty titleProperty() { return title; }
    public StringProperty descriptionProperty() { return description; }
    public StringProperty dueDateProperty() { return dueDate; }
    public StringProperty categoryProperty() { return category; }
    public StringProperty priorityProperty() { return priority; }
    public StringProperty completedProperty() { return completed; }

    // === 普通 Getter / Setter （Gson 用）===
    public String getTitle() { return title.get(); }
    public void setTitle(String value) { title.set(value); }

    public String getDescription() { return description.get(); }
    public void setDescription(String value) { description.set(value); }

    public String getDueDate() { return dueDate.get(); }
    public void setDueDate(String value) { dueDate.set(value); }

    public String getCategory() { return category.get(); }
    public void setCategory(String value) { category.set(value); }

    public String getPriority() { return priority.get(); }
    public void setPriority(String value) { priority.set(value); }

    public String getCompleted() { return completed.get(); }
    public void setCompleted(String value) { completed.set(value); }

    // === Gson 需要的无参构造函数 ===
    public Task() {
        this("", "", "", "", "", "No");
    }
}
