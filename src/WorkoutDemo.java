import java.util.Scanner;

import components.workout.Workout;
import components.workout.Workout1L;

/**
 * Demo of the Workout Component.
 */
public final class WorkoutDemo {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Three (Typical Number for Sets).
     */
    private static final int THREE = 3;

    /**
     * Five (Typical Number for Reps).
     */
    private static final int FIVE = 5;

    /**
     * Six (Typical Number for Reps).
     */
    private static final int SIX = 6;

    /**
     * Ten (Typical Number for Reps).
     */
    private static final int TEN = 10;

    /**
     * Twelve (Typical Number for Reps).
     */
    private static final int TWELVE = 12;

    /**
     * Fifteen (Typical Number for Reps).
     */
    private static final int FIFTEEN = 15;

    /**
     * Ten (Typical Number for Rest Time).
     */
    private static final int SIXTY = 60;

    /**
     * One Hundred Twenty (Typical Number for Rest Time).
     */
    private static final int ONEHUNDREDTWENTY = 120;

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    private WorkoutDemo() {

    }

    /**
     * Monday Method.
     */
    private static void monday() {
        Workout w = new Workout1L();

        w.add("Push Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        w.add("Pull Ups", FIVE, SIX, SIXTY);
        w.add("Sit Ups", THREE, FIFTEEN, SIXTY);

        System.out.println(w.toString());
    }

    /**
     * Tuesday Method.
     */
    private static void tuesday() {
        Workout w = new Workout1L();

        w.add("Bench Press", THREE, TEN, ONEHUNDREDTWENTY);
        w.add("DB Pull Over", THREE, TWELVE, SIXTY);
        w.add("Crunches", THREE, SIX, SIXTY);

        System.out.println(w.toString());
    }

    /**
     * Wednesday Method.
     */
    private static void wednesday() {
        Workout w = new Workout1L();

        w.add("Shrugs", THREE, TEN, ONEHUNDREDTWENTY);
        w.add("Wrist Curls", THREE, TEN, SIXTY);
        w.add("DB Flies", THREE, TEN, SIXTY);

        System.out.println(w.toString());
    }

    /**
     * Thursday Method.
     */
    private static void thursday() {
        Workout w = new Workout1L();

        w.add("DB Raises", FIVE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Extensions", THREE, TWELVE, SIXTY);
        w.add("Sit Ups", THREE, TWELVE, SIXTY);

        System.out.println(w.toString());
    }

    /**
     * Friday Method.
     */
    private static void friday() {
        Workout w = new Workout1L();

        w.add("Tricep Pull Downs", THREE, TEN, ONEHUNDREDTWENTY);
        w.add("Bicep Curls", THREE, TEN, SIXTY);
        w.add("Ab Roller", THREE, TWELVE, SIXTY);

        System.out.println(w.toString());
    }

    /**
     * Saturday Method.
     */
    private static void saturday() {
        Workout w = new Workout1L();

        w.add("Tricep Push Downs", THREE, TWELVE, ONEHUNDREDTWENTY);
        w.add("Hammer Curls", THREE, TWELVE, SIXTY);
        w.add("Leg Raises", THREE, TEN, SIXTY);

        System.out.println(w.toString());
    }

    /**
     * Sunday Method.
     */
    private static void sunday() {
        Workout w = new Workout1L();

        w.add("Squats", THREE, TWELVE, ONEHUNDREDTWENTY);
        w.add("Split Squats", THREE, TEN, SIXTY);
        w.add("DB Lunges", THREE, TWELVE, SIXTY);

        System.out.println(w.toString());
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        System.out.println("What Day Is It (0-6)?");
        Scanner input = new Scanner(System.in);
        String dayString = input.nextLine();

        try {
            int day = Integer.parseInt(dayString);
            if (day == 0) {
                monday();
            } else if (day == 1) {
                tuesday();
            } else if (day == 2) {
                wednesday();
            } else if (day == THREE) {
                thursday();
            } else if (day == THREE + 1) {
                friday();
            } else if (day == FIVE) {
                saturday();
            } else {
                sunday();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        input.close();
    }
}
