package Pomodoro;

public class Session {
    
    public enum SessionType {
        Work, ShortBreak, LongBreak,
    }

    private SessionType type;
    private int duration;
    private int remainingTime;

    public Session (SessionType type, int duration) {
        this.type = type;
        this.duration = duration;
        this.remainingTime = duration * 60; // Convert minutes to seconds
    }


    public SessionType getType() {
        return type;
    }


    public int getDuration() {
        return duration;
    }


    public int getRemainingTime() {
        return remainingTime;
    }


    public void setRemainingTime(int y) {
        this.remainingTime = y;
    }


    public void tick() {
        if (remainingTime >= 0) {
            remainingTime--;
        } 
    }
}
