package keyboardwarrior;

public interface GameLoop {
    
    void start();

    void stop();

    long getLastElapsedTime();

    float getFrameRate();
}
