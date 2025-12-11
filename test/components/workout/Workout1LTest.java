package components.workout;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test cases for Kernel Implementation of Workout.
 */
public class Workout1LTest {

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
     * Public members --------------------------------------------------------
     */

    /*
     * Test cases for Add.
     */

    /**
     * Testing Add with One Exercise.
     */
    @Test
    public final void testAddOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(1, w.length());

        assertEquals("Pull Ups", w.get(0).name());
        assertEquals(THREE, w.get(0).sets());
        assertEquals(TWELVE, w.get(0).reps());
        assertEquals(SIXTY, w.get(0).restTime());
    }

    /**
     * Testing Add with Few Exercise.
     */
    @Test
    public final void testAddFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(THREE, w.length());

        assertEquals("Bench Press", w.get(0).name());
        assertEquals(THREE, w.get(0).sets());
        assertEquals(SIX, w.get(0).reps());
        assertEquals(ONEHUNDREDTWENTY, w.get(0).restTime());

        assertEquals("Tricep Push Downs", w.get(1).name());
        assertEquals(THREE, w.get(1).sets());
        assertEquals(TEN, w.get(1).reps());
        assertEquals(SIXTY, w.get(1).restTime());

        assertEquals("Pull Ups", w.get(2).name());
        assertEquals(THREE, w.get(2).sets());
        assertEquals(TWELVE, w.get(2).reps());
        assertEquals(SIXTY, w.get(2).restTime());
    }

    /**
     * Testing Add with Multiple Exercise.
     */
    @Test
    public final void testAddMultiple() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.add("Push Ups", THREE, TWELVE, SIXTY);
        w.add("Shrugs", THREE, TWELVE, SIXTY);
        w.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);

        assertEquals(TEN, w.length());

        assertEquals("Bench Press", w.get(0).name());
        assertEquals("Tricep Push Downs", w.get(1).name());
        assertEquals("Pull Ups", w.get(2).name());
        assertEquals("Push Ups", w.get(THREE).name());
        assertEquals("Shrugs", w.get(THREE + 1).name());
        assertEquals("Dumbbell Fly", w.get(FIVE).name());
        assertEquals("Pull Ups", w.get(SIX).name());
        assertEquals("Pull Ups", w.get(w.length() - THREE).name());
        assertEquals("Pull Ups", w.get(w.length() - 2).name());
        assertEquals("Bicep Curls", w.get(w.length() - 1).name());
    }

    /*
     * Test cases for Remove.
     */

    /**
     * Testing Remove with One Exercise.
     */
    @Test
    public final void testRemoveOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        assertEquals(1, w.length());
        Workout.Exercise exerciseFirst = w.remove(w.length() - 1);
        assertEquals(0, w.length());
        Workout wRef = new Workout1L();

        assertEquals(wRef.length(), w.length());
        assertEquals(wRef.toString(), w.toString());

        assertEquals("Pull Ups", exerciseFirst.name());
        assertEquals(THREE, exerciseFirst.sets());
        assertEquals(TWELVE, exerciseFirst.reps());
        assertEquals(SIXTY, exerciseFirst.restTime());
    }

    /**
     * Testing Remove with Few Exercise.
     */
    @Test
    public final void testRemoveFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        assertEquals(THREE, w.length());
        Workout.Exercise exerciseFirst = w.remove(w.length() - 1);
        Workout.Exercise exerciseSecond = w.remove(w.length() - 1);
        assertEquals(1, w.length());
        Workout wRef = new Workout1L();
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);

        assertEquals(wRef.length(), w.length());
        assertEquals(wRef.toString(), w.toString());

        assertEquals("Pull Ups", exerciseFirst.name());
        assertEquals(THREE, exerciseFirst.sets());
        assertEquals(TWELVE, exerciseFirst.reps());
        assertEquals(SIXTY, exerciseFirst.restTime());

        assertEquals("Tricep Push Downs", exerciseSecond.name());
        assertEquals(THREE, exerciseSecond.sets());
        assertEquals(TEN, exerciseSecond.reps());
        assertEquals(SIXTY, exerciseSecond.restTime());
    }

    /**
     * Testing Remove with Multiple Exercise.
     */
    @Test
    public final void testRemoveMultiple() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.add("Push Ups", THREE, TWELVE, SIXTY);
        w.add("Shrugs", THREE, TWELVE, SIXTY);
        w.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);
        Workout.Exercise exerciseFirst = w.remove(w.length() - 1);
        Workout.Exercise exerciseSecond = w.remove(w.length() - 1);
        Workout.Exercise exerciseThird = w.remove(w.length() - 1);
        Workout.Exercise exerciseFourth = w.remove(w.length() - 1);
        Workout.Exercise exerciseFive = w.remove(w.length() - 1);
        assertEquals(FIVE, w.length());
        Workout wRef = new Workout1L();
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Push Ups", THREE, TWELVE, SIXTY);
        wRef.add("Shrugs", THREE, TWELVE, SIXTY);
        assertEquals(wRef.length(), w.length());
        assertEquals(wRef.toString(), w.toString());

        assertEquals("Bicep Curls", exerciseFirst.name());
        assertEquals("Pull Ups", exerciseSecond.name());
        assertEquals("Pull Ups", exerciseThird.name());
        assertEquals("Pull Ups", exerciseFourth.name());
        assertEquals("Dumbbell Fly", exerciseFive.name());
    }

    /*
     * Test cases for Length.
     */

    /**
     * Testing Length with One Exercise.
     */
    @Test
    public final void testLengthOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        int wLength = w.length();
        assertEquals(1, wLength);
    }

    /**
     * Testing Length with Few Exercise.
     */
    @Test
    public final void testLengthFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        int wLength = w.length();
        assertEquals(THREE, wLength);
    }

    /**
     * Testing Length with Multiple Exercise.
     */
    @Test
    public final void testLengthMultiple() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.add("Push Ups", THREE, TWELVE, SIXTY);
        w.add("Shrugs", THREE, TWELVE, SIXTY);
        w.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);

        int wLength = w.length();
        assertEquals(TEN, wLength);
    }

}
