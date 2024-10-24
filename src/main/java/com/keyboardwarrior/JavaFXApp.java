package com.keyboardwarrior;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public final class JavaFXApp extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Label message = new Label("Hello, JavaFX!"); 
        message.setFont(new Font(100));
        primaryStage.setScene(new Scene(message));
        primaryStage.setTitle("Hello");
        primaryStage.show();
    }
}
