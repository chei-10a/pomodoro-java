import java.io.IOException;
import java.util.Scanner;

import Pomodoro.Session;
import Pomodoro.Timer;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

            Scanner userInput = new Scanner(System.in);

            System.out.println("Welcome to you Pomodoro App! Ready to get some work done?");
            System.out.println("1. It's focus time!!");
            System.out.println("2. Mmmh, maybe later...");
            System.out.print("Enter your choice: ");


            int x = userInput.nextInt();
            userInput.nextLine();

            switch(x) {
                case 1 -> {
                    //Choisir le temps de chaque sous -session
                    System.out.println("How many sessions do you want to do ? =^_^= ");
                    int nbSession = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("How many minutes for the Work session ?");
                    int worksession = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("How many minutes for the Short Break session ?");
                    int shortBsession = userInput.nextInt();
                    userInput.nextLine();

                    System.out.println("How many minutes for the Long Break session ?");
                    int longBsession = userInput.nextInt();
                    userInput.nextLine();
                    
                    
                    
                    // Commencement de la Session Pomodoro
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
                        Session session = new Session(Session.SessionType.Work, worksession);
                        Timer timer = new Timer(session, worksession);
                        timer.start();

                        if (i == nbSession) {
                            System.out.println("All sessions are done !!");
                            

                        } else if (i % 3 != 0) {
                            System.out.println("Break time! It's important to clear your head =^.^=");
                            // System.out.println("Type 'p' to pause, 'r' to resume, 's' to skip the session, 'q' to exit.");
                            Session breakSession = new Session(Session.SessionType.ShortBreak, shortBsession);
                            Timer breakTimer = new Timer(breakSession, shortBsession);
                            breakTimer.start();

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

                case 2 -> {
                    System.out.println("You got this! See you soon! <3");
                    System.exit(0);
                }
            }
    }
}


