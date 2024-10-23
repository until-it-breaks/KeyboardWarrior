package keyboardwarrior;

public interface GameLoop {
    
    void start();

    void stop();

    long getLastElapsedTime();

    double getFrameRate();
}
