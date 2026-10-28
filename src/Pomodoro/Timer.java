package Pomodoro;

public class Timer {
    private Session session;
    private int duration;
    public boolean isRunning = false;
    public boolean isStopped = false;
    public boolean isPaused = false;

    public Timer(Session session, int duration) {
        this.session = session;
        this.duration = duration;
    }

    public void start() {
        isRunning = true;
        isPaused = false;


        while (isRunning) {
            if (isPaused) {
                try { Thread.sleep(200); 

                } catch (InterruptedException e) {break;}
                continue; // we go back to the top of the loop so tick() is not called while isPaused is true
            }

            int remaining = session.getRemainingTime();

            int minutes = remaining / 60; //convert remaining times in minutes
            int seconds = remaining % 60; //convert remaining times in seconds
            System.out.printf("%02d:%02d\n", minutes, seconds); //shows the timer

            if (remaining == 0) {
                break; // 00:00 est affiché, on peut s'arrêter
            }

            session.tick();

            try {
                Thread.sleep(1000); // Wait for 1 second to have a countdown showing
            } catch (InterruptedException e) {
                System.out.println("Timer interrupted.");
                break;
            }

            
        }
        System.out.println(session.getType() + " session completed!");
    }



    public void skip() {
        session.setRemainingTime(0);
        System.out.println("Session skipped.");
    }



    public void pause() {
        isPaused = true;
        System.out.println("Timer paused.");
    }



    public void resume() {
        if (isPaused = false) {
            System.out.println("Timer is not paused.");
        }
        
        System.out.println("Resuming timer...");      
        isPaused = false;
    }



    public void exit() {
        isStopped = true;
        System.out.println("See you next time !!");
        System.exit(0);
    }
}


    