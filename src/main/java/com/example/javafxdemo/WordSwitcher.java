package com.example.javafxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WordSwitcher extends Application {
    private boolean isFirstToSecond = true; // Флаг для отслеживания направления

    @Override
    public void start(Stage primaryStage) {
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        textField2.setEditable(false); // Второе поле только для чтения

        Button switchButton = new Button("→"); // Начальная стрелка

        switchButton.setOnAction(event -> {
            if (isFirstToSecond) {
                textField2.setText(textField1.getText());
                textField1.clear();
                switchButton.setText("←"); // Меняем стрелку
            } else {
                textField1.setText(textField2.getText());
                textField2.clear();
                switchButton.setText("→"); // Меняем стрелку обратно
            }
            isFirstToSecond = !isFirstToSecond; // Переключаем направление
        });

        HBox hBox = new HBox(10, textField1, switchButton, textField2);
        hBox.setPadding(new Insets(20));

        Scene scene = new Scene(hBox, 400, 100);
        primaryStage.setTitle("Word Switcher");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
