package com.example.smarttodolist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {

    // === 表格列 ===
    @FXML private TableView<Task> taskTable;
    @FXML private TableColumn<Task, String> taskNameColumn;
    @FXML private TableColumn<Task, String> descriptionColumn;
    @FXML private TableColumn<Task, String> dueDateColumn;
    @FXML private TableColumn<Task, String> categoryColumn;
    @FXML private TableColumn<Task, String> priorityColumn;
    @FXML private TableColumn<Task, String> completedColumn;

    // === 输入控件 ===
    @FXML private TextField taskNameInput;
    @FXML private TextField descriptionInput;
    @FXML private DatePicker dueDatePicker;
    @FXML private ChoiceBox<String> categoryChoiceBox;
    @FXML private ChoiceBox<String> priorityChoiceBox;

    // === 搜索与筛选 ===
    @FXML private TextField searchField;
    @FXML private ChoiceBox<String> filterCategoryBox;
    @FXML private ChoiceBox<String> filterStatusBox;
    @FXML private DatePicker filterDatePicker;

    // === 数据源 ===
    private final ObservableList<Task> taskList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // 列绑定
        taskNameColumn.setCellValueFactory(c -> c.getValue().titleProperty());
        descriptionColumn.setCellValueFactory(c -> c.getValue().descriptionProperty());
        dueDateColumn.setCellValueFactory(c -> c.getValue().dueDateProperty());
        categoryColumn.setCellValueFactory(c -> c.getValue().categoryProperty());
        priorityColumn.setCellValueFactory(c -> c.getValue().priorityProperty());
        completedColumn.setCellValueFactory(c -> c.getValue().completedProperty());
        taskTable.setItems(taskList);

        // 初始化下拉框
        categoryChoiceBox.setItems(FXCollections.observableArrayList("Work", "Study", "Personal", "Other"));
        categoryChoiceBox.setValue("Work");

        priorityChoiceBox.setItems(FXCollections.observableArrayList("High", "Medium", "Low"));
        priorityChoiceBox.setValue("Medium");

        filterCategoryBox.setItems(FXCollections.observableArrayList("", "Work", "Study", "Personal", "Other"));
        filterStatusBox.setItems(FXCollections.observableArrayList("", "Yes", "No"));

        // 示例数据
        taskList.add(new Task("Assignment", "Finish JavaFX", "2025-12-01", "Study", "High", "No"));
    }

    // === 添加任务 ===
    @FXML
    private void handleAddTask() {
        String title = taskNameInput.getText();
        String desc = descriptionInput.getText();
        String due = (dueDatePicker.getValue() != null) ? dueDatePicker.getValue().toString() : "";
        String category = categoryChoiceBox.getValue();
        String priority = priorityChoiceBox.getValue();

        if (title.isEmpty() || due.isEmpty()) {
            showAlert("Please fill in required fields (Title and Due Date).");
            return;
        }
        taskList.add(new Task(title, desc, due, category, priority, "No"));
        clearInputs();
    }

    // === 编辑任务 ===
    @FXML
    private void handleEditTask() {
        Task selected = taskTable.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Select a task to edit."); return; }

        selected.setTitle(taskNameInput.getText());
        selected.setDescription(descriptionInput.getText());
        selected.setDueDate(dueDatePicker.getValue() != null ? dueDatePicker.getValue().toString() : "");
        selected.setCategory(categoryChoiceBox.getValue());
        selected.setPriority(priorityChoiceBox.getValue());
        taskTable.refresh();
        clearInputs();
    }

    // === 删除任务 ===
    @FXML
    private void handleDeleteTask() {
        Task selected = taskTable.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Select a task to delete."); return; }
        taskList.remove(selected);
    }

    // === 标记完成 ===
    @FXML
    private void handleMarkCompleted() {
        Task selected = taskTable.getSelectionModel().getSelectedItem();
        if (selected == null) { showAlert("Select a task to mark as completed."); return; }
        selected.setCompleted("Yes");
        taskTable.refresh();
    }

    // === 搜索 ===
    @FXML
    private void handleSearchTasks() {
        String keyword = searchField.getText().toLowerCase();
        if (keyword.isEmpty()) { taskTable.setItems(taskList); return; }

        ObservableList<Task> filtered = taskList.filtered(t ->
                t.getTitle().toLowerCase().contains(keyword) ||
                        t.getDescription().toLowerCase().contains(keyword));
        taskTable.setItems(filtered);
    }

    // === 筛选 ===
    @FXML
    private void handleFilterTasks() {
        String category = filterCategoryBox.getValue();
        String status = filterStatusBox.getValue();
        String date = (filterDatePicker.getValue() != null) ? filterDatePicker.getValue().toString() : null;

        ObservableList<Task> filtered = FXCollections.observableArrayList(taskList);
        if (category != null && !category.isEmpty())
            filtered = filtered.filtered(t -> t.getCategory().equals(category));
        if (status != null && !status.isEmpty())
            filtered = filtered.filtered(t -> t.getCompleted().equals(status));
        if (date != null)
            filtered = filtered.filtered(t -> t.getDueDate().equals(date));

        taskTable.setItems(filtered);
    }

    @FXML
    private void handleClearFilter() {
        filterCategoryBox.setValue("");
        filterStatusBox.setValue("");
        filterDatePicker.setValue(null);
        taskTable.setItems(taskList);
    }

    // === 菜单 ===
    @FXML private void handleMenuExit() { System.exit(0); }
    @FXML private void handleMenuNew() { taskList.clear(); }
    @FXML private void handleMenuOpen() { showInfo("Open", "Feature under development."); }
    @FXML private void handleMenuAbout() {
        showInfo("About", "Smart Todo List v3.0\nDeveloped by Lyndon White\nEnhanced JavaFX Todo App.");
    }

    // === 工具方法 ===
    private void clearInputs() {
        taskNameInput.clear();
        descriptionInput.clear();
        dueDatePicker.setValue(null);
        categoryChoiceBox.setValue("Work");
        priorityChoiceBox.setValue("Medium");
    }

    private void showAlert(String msg) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Warning");
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private void showInfo(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
