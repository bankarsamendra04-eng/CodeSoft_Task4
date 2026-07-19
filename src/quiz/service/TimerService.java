package quiz.service;
import javax.swing.Timer;

public class TimerService {
    private Timer timer;
    private int secondsLeft;
    private TimerListener listener;

    public interface TimerListener {
        void onTick(int secondsLeft);
        void onTimeUp();
    }

    public TimerService(int seconds, TimerListener listener) {
        this.secondsLeft = seconds;
        this.listener = listener;
        timer = new Timer(1000, e -> {
            secondsLeft--;
            if (secondsLeft > 0) {
                listener.onTick(secondsLeft);
            } else {
                timer.stop();
                listener.onTimeUp();
            }
        });
    }

    public void start() { timer.start(); }
    public void stop() { timer.stop(); }
    public void reset(int seconds) {
        this.secondsLeft = seconds;
        listener.onTick(secondsLeft);
        timer.restart();
    }
}