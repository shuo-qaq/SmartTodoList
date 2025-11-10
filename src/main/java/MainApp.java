package com.example.smarttodolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 加载FXML文件
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/main.fxml"));
        BorderPane root = loader.load();

        // 设置场景
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // 设置标题
        primaryStage.setTitle("Smart Todo List");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
