package keyboardwarrior;

public class GameLoopImpl implements GameLoop{

    public static final int TARGET_FPS = 15;
    private static final long PERIOD = 1_000 / TARGET_FPS;
    private boolean hasToRun;
    private long lastElapsedTime;

    public GameLoopImpl() {
        this.hasToRun = true;
        this.lastElapsedTime = 0;
    }

    @Override
    public void start() {
        long lastTime = System.currentTimeMillis();
        while (hasToRun) {
            final long currentTime = System.currentTimeMillis();
            final long elapsedTime = currentTime - lastTime;
            if (elapsedTime > 0) {
                this.lastElapsedTime = elapsedTime;
                System.out.println("Elapsed Time: " + this.getLastElapsedTime() + " ms");
                System.out.printf("FPS: %.1f%n", this.getFrameRate());
            }
            processInput();
            update(elapsedTime);
            render();
            waitForSync(lastTime);
            lastTime = currentTime;
        }
    }

    @Override
    public void stop() {
        this.hasToRun = false;
    }

    @Override
    public long getLastElapsedTime() {
        return this.lastElapsedTime;
    }

    @Override
    public float getFrameRate() {
        return 1000f / lastElapsedTime;
    }
    
    private void processInput() {

    }

    private void update(final long time) {

    }

    private void render() {

    }

    private void waitForSync(final long lastTime) {
        final long delta = System.currentTimeMillis() - lastTime;
        if (delta < PERIOD) {
            try {
                Thread.sleep(PERIOD - delta);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(final String[] args) {
        final GameLoop gameLoop = new GameLoopImpl();
        final Thread gameLoopThread = new Thread(() -> gameLoop.start());
        gameLoopThread.start();
    }
}
