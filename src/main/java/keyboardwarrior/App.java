package keyboardwarrior;

public class App {
    public static void main(final String[] args) throws InterruptedException {
        final GameLoop gameLoop = new GameLoopImpl();
        final Thread gameLoopThread = new Thread(() -> gameLoop.start());
        gameLoopThread.start();
        Thread.sleep(10000);
        gameLoop.stop();
    }
}
