package keyboardwarrior;


// Note to self: this implementation is highly accurate but causes busy waiting.
// The alternative is using Thread.sleep() but it has proven to be highly inaccurate past 60 fps.
// There could be room for a switch between the two?
public class GameLoopImpl implements GameLoop{

    public static final int TARGET_FPS = 100;
    private static final long SECOND_IN_NANOS = 1_000_000_000;
    private static final long PERIOD = SECOND_IN_NANOS / TARGET_FPS;
    private boolean hasToRun;
    private long lastElapsedTime;

    public GameLoopImpl() {
        this.hasToRun = true;
        this.lastElapsedTime = 0;
    }

    @Override
    public void start() {
        long lastTime = System.nanoTime();
        while (hasToRun) {
            final long currentTime = System.nanoTime();
            final long elapsedTime = currentTime - lastTime;
            lastTime = currentTime;
            this.lastElapsedTime = elapsedTime;

            System.out.println("Elapsed Time: " + this.getLastElapsedTime() + " ns");
            System.out.printf("FPS: %.3f%n", this.getFrameRate());

            processInput();
            update(elapsedTime);
            render();
            waitForSync(lastTime);
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
    public double getFrameRate() {
        return (double) SECOND_IN_NANOS / lastElapsedTime;
    }
    
    private void processInput() {

    }

    private void update(final long time) {

    }

    private void render() {

    }

    private void waitForSync(final long lastTime) {
        long delta = System.nanoTime() - lastTime;
        while (delta < PERIOD) {
            delta = System.nanoTime() - lastTime;
        }
    }
}
