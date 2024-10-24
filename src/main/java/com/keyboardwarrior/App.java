package com.keyboardwarrior;

import javafx.application.Application;

public class App {
    /*
    public static void main(final String[] args) throws InterruptedException {
        final GameLoop gameLoop = new GameLoopImpl();
        final Thread gameLoopThread = new Thread(() -> gameLoop.start());
        gameLoopThread.start();
        Thread.sleep(10000);
        gameLoop.stop();
    }
    */

    private App() { }

    public static void main(final String[] args) {
        Application.launch(JavaFXApp.class, args);
    }
}
