import java.io.IOException;
import java.util.Scanner;

import Pomodoro.Session;
import Pomodoro.Timer;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

            Scanner userInput = new Scanner(System.in);

            // Menu of the pomodoro console
            System.out.println("Welcome to you Pomodoro App! Ready to get some work done?");
            System.out.println("1. It's focus time!!");
            System.out.println("2. Mmmh, maybe later...");
            System.out.print("Enter your choice: ");


            int x = userInput.nextInt();
            userInput.nextLine();

            switch(x) {
                case 1 -> { // We start Pomodoro Sessions
                    // Choosing number of sessions 
                    System.out.println("How many sessions do you want to do ? =^_^= ");
                    int nbSession = userInput.nextInt();
                    userInput.nextLine();


                    // Choosing number of minutes for each sessions (Work, ShortBreak, LongBreak)
                    System.out.println("How many minutes for the Work session ?");
                    int worksession = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("How many minutes for the Short Break session ?");
                    int shortBsession = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("How many minutes for the Long Break session ?");
                    int longBsession = userInput.nextInt();
                    userInput.nextLine();
                    
                    
                    
                    // Beginning of the Pomodoro Sessions
                    // System.out.println("Type 'p' to pause, 'r' to resume, 's' to skip the session, 'q' to exit.");
                    System.out.println("Starting a Pomodoro session... =^.^=");

                    try {
                        Thread.sleep(2000); // Wait for 2 seconds
                    } catch (InterruptedException e) {
                        System.out.println("Timer interrupted.");
                        break;
                    }

                    int i = 1;
                    while (i <= nbSession) {
                        System.out.println("Session " + (i) + " started! Lock in!!");

                        // Work Session
                        Session session = new Session(Session.SessionType.Work, worksession);
                        Timer timer = new Timer(session, worksession);
                        timer.start();


                        // Conditions for a consistent Pomodoro Session

                            // If we have one session (Work) then no need for a break after
                        if (i == nbSession) {
                            System.out.println("All sessions are done !!");
                            
                            // For two consecutive sessions we have a short break
                        } else if (i % 3 != 0) {
                            System.out.println("Break time! It's important to clear your head =^.^=");
                            // System.out.println("Type 'p' to pause, 'r' to resume, 's' to skip the session, 'q' to exit.");
                            Session breakSession = new Session(Session.SessionType.ShortBreak, shortBsession);
                            Timer breakTimer = new Timer(breakSession, shortBsession);
                            breakTimer.start();


                            // After two full sessions (Work + ShortBreak), we have a Work + LongBreak session
                        } else {
                            System.out.println("Watch some videos, play some games, talk to your friends and come back stronger! =^.^=");
                            // System.out.println("Type 'p' to pause, 'r' to resume, 's' to skip the session, 'q' to exit.");
                            Session longBreakSession = new Session(Session.SessionType.LongBreak, longBsession);
                            Timer longBreakTimer = new Timer(longBreakSession, longBsession);
                            longBreakTimer.start();

                        }
                        i++;
                    }
                    userInput.close();
                    System.out.println("Amazing Work! See you next time <3");
                }

                case 2 -> { // Leaving the pomodro console
                    System.out.println("You got this! See you soon! <3");
                    System.exit(0);
                }
            }
    }
}


