package components.workout;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test cases for Abstract Implementation of Workout.
 */
public class WorkoutTest {

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
     * Test cases for Flip.
     */

    /**
     * Testing Flip with One Exercise.
     */
    @Test
    public final void testFlipOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.flip();

        Workout wRef = new Workout1L();
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(wRef.toString(), w.toString());
    }

    /**
     * Testing Flip with Few Exercise.
     */
    @Test
    public final void testFlipFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);
        w.flip();

        Workout wRef = new Workout1L();
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);

        assertEquals(wRef.toString(), w.toString());
    }

    /**
     * Testing Flip with Multiple Exercise.
     */
    @Test
    public final void testFlipMultiple() {
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
        w.flip();

        Workout wRef = new Workout1L();
        wRef.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        wRef.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        wRef.add("Shrugs", THREE, TWELVE, SIXTY);
        wRef.add("Push Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);

        assertEquals(wRef.toString(), w.toString());
    }

    /*
     * Test cases for Combine.
     */

    /**
     * Testing Combine with One Exercise.
     */
    @Test
    public final void testCombineOne() {
        Workout w1 = new Workout1L();
        w1.add("Pull Ups", THREE, TWELVE, SIXTY);

        Workout w2 = new Workout1L();
        w2.add("Pull Ups", THREE, TWELVE, SIXTY);

        w1.combine(w2);
        assertEquals("()", w2.toString());

        Workout wRef = new Workout1L();
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(wRef.toString(), w1.toString());
    }

    /**
     * Testing Combine with Few Exercise.
     */
    @Test
    public final void testCombineFew() {
        Workout w1 = new Workout1L();
        w1.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w1.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w1.add("Pull Ups", THREE, TWELVE, SIXTY);

        Workout w2 = new Workout1L();
        w2.add("Pull Ups", THREE, TWELVE, SIXTY);
        w2.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w2.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);

        w1.combine(w2);
        assertEquals("()", w2.toString());

        Workout wRef = new Workout1L();
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);

        assertEquals(wRef.toString(), w1.toString());
    }

    /**
     * Testing Combine with Multiple Exercise.
     */
    @Test
    public final void testCombineMultiple() {
        Workout w1 = new Workout1L();
        w1.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w1.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w1.add("Pull Ups", THREE, TWELVE, SIXTY);
        w1.add("Push Ups", THREE, TWELVE, SIXTY);
        w1.add("Shrugs", THREE, TWELVE, SIXTY);
        w1.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        w1.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        w1.add("Pull Ups", THREE, TWELVE, SIXTY);
        w1.add("Pull Ups", THREE, TWELVE, SIXTY);
        w1.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);

        Workout w2 = new Workout1L();
        w2.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);
        w2.add("Pull Ups", THREE, TWELVE, SIXTY);
        w2.add("Pull Ups", THREE, TWELVE, SIXTY);
        w2.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        w2.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        w2.add("Shrugs", THREE, TWELVE, SIXTY);
        w2.add("Push Ups", THREE, TWELVE, SIXTY);
        w2.add("Pull Ups", THREE, TWELVE, SIXTY);
        w2.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w2.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);

        w1.combine(w2);
        assertEquals("()", w2.toString());

        Workout wRef = new Workout1L();
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Push Ups", THREE, TWELVE, SIXTY);
        wRef.add("Shrugs", THREE, TWELVE, SIXTY);
        wRef.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        wRef.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        wRef.add("Shrugs", THREE, TWELVE, SIXTY);
        wRef.add("Push Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);

        assertEquals(wRef.toString(), w1.toString());
    }

    /*
     * Test cases for First.
     */

    /**
     * Testing First with One Exercise.
     */
    @Test
    public final void testFirstOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(1, w.length());

        assertEquals("Pull Ups", w.first().name());
        assertEquals(THREE, w.first().sets());
        assertEquals(TWELVE, w.first().reps());
        assertEquals(SIXTY, w.first().restTime());
    }

    /**
     * Testing First with Few Exercise.
     */
    @Test
    public final void testFirstFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(THREE, w.length());

        assertEquals("Bench Press", w.first().name());
        assertEquals(THREE, w.first().sets());
        assertEquals(SIX, w.first().reps());
        assertEquals(ONEHUNDREDTWENTY, w.first().restTime());
    }

    /**
     * Testing First with Multiple Exercise.
     */
    @Test
    public final void testFirstMultiple() {
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

        assertEquals("Bench Press", w.first().name());
        assertEquals(THREE, w.first().sets());
        assertEquals(SIX, w.first().reps());
        assertEquals(ONEHUNDREDTWENTY, w.first().restTime());
    }

    /*
     * Test cases for Replace.
     */

    /**
     * Testing Replace with One Exercise.
     */
    @Test
    public final void testReplaceOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        Workout w2 = new Workout1L();
        w2.add("Push Ups", THREE, SIX, ONEHUNDREDTWENTY);
        Workout.Exercise removed = w2.remove(0);

        Workout.Exercise replaced = w.replace(0, removed);

        assertEquals("Push Ups", w.get(0).name());
        assertEquals(THREE, w.get(0).sets());
        assertEquals(SIX, w.get(0).reps());
        assertEquals(ONEHUNDREDTWENTY, w.get(0).restTime());

        assertEquals("Pull Ups", replaced.name());
        assertEquals(THREE, replaced.sets());
        assertEquals(TWELVE, replaced.reps());
        assertEquals(SIXTY, replaced.restTime());
    }

    /**
     * Testing Replace with Few Exercise.
     */
    @Test
    public final void testReplaceFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        Workout w2 = new Workout1L();
        w2.add("Push Ups", THREE, SIX, ONEHUNDREDTWENTY);
        Workout.Exercise removed = w2.remove(0);

        Workout.Exercise replaced = w.replace(1, removed);

        assertEquals("Push Ups", w.get(1).name());
        assertEquals(THREE, w.get(1).sets());
        assertEquals(SIX, w.get(1).reps());
        assertEquals(ONEHUNDREDTWENTY, w.get(1).restTime());

        assertEquals("Tricep Push Downs", replaced.name());
        assertEquals(THREE, replaced.sets());
        assertEquals(TEN, replaced.reps());
        assertEquals(SIXTY, replaced.restTime());
    }

    /**
     * Testing Replace with Multiple Exercise.
     */
    @Test
    public final void testReplaceMultiple() {
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

        Workout w2 = new Workout1L();
        w2.add("Push Ups", THREE, SIX, ONEHUNDREDTWENTY);
        Workout.Exercise removed = w2.remove(0);

        Workout.Exercise replaced = w.replace(FIVE, removed);

        assertEquals("Push Ups", w.get(FIVE).name());
        assertEquals(THREE, w.get(FIVE).sets());
        assertEquals(SIX, w.get(FIVE).reps());
        assertEquals(ONEHUNDREDTWENTY, w.get(FIVE).restTime());

        assertEquals("Dumbbell Fly", replaced.name());
        assertEquals(THREE, replaced.sets());
        assertEquals(FIFTEEN, replaced.reps());
        assertEquals(SIXTY, replaced.restTime());
    }

    /*
     * Test cases for Get.
     */

    /**
     * Testing Get with One Exercise.
     */
    @Test
    public final void testGetOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(1, w.length());

        assertEquals("Pull Ups", w.get(0).name());
        assertEquals(THREE, w.get(0).sets());
        assertEquals(TWELVE, w.get(0).reps());
        assertEquals(SIXTY, w.get(0).restTime());
    }

    /**
     * Testing Get with Few Exercise.
     */
    @Test
    public final void testGetFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(THREE, w.length());

        assertEquals("Pull Ups", w.get(2).name());
        assertEquals(THREE, w.get(2).sets());
        assertEquals(TWELVE, w.get(2).reps());
        assertEquals(SIXTY, w.get(2).restTime());
    }

    /**
     * Testing Get with Multiple Exercise.
     */
    @Test
    public final void testGetMultiple() {
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

        assertEquals("Dumbbell Fly", w.get(FIVE).name());
        assertEquals(THREE, w.get(FIVE).sets());
        assertEquals(FIFTEEN, w.get(FIVE).reps());
        assertEquals(SIXTY, w.get(FIVE).restTime());
    }

    /*
     * Test cases for toString.
     */

    /**
     * Testing toString with One Exercise.
     */
    @Test
    public final void testtoStringOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals("([Pull Ups, 3, 12, 60])", w.toString());
    }

    /**
     * Testing toString with Few Exercise.
     */
    @Test
    public final void testtoStringFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals("([Bench Press, 3, 6, 120],"
                + " [Tricep Push Downs, 3, 10, 60], [Pull Ups, 3, 12, 60])",
                w.toString());
    }

    /**
     * Testing toString with Multiple Exercise.
     */
    @Test
    public final void testtoStringMultiple() {
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

        assertEquals("([Bench Press, 3, 6, 120],"
                + " [Tricep Push Downs, 3, 10, 60], [Pull Ups, 3, 12, 60],"
                + " [Push Ups, 3, 12, 60], [Shrugs, 3, 12, 60], [Dumbbell Fly,"
                + " 3, 15, 60], [Pull Ups, 3, 12, 120], [Pull Ups, 3, 12, 60],"
                + " [Pull Ups, 3, 12, 60], [Bicep Curls, 3, 6, 120])",
                w.toString());
    }

    /*
     * Test cases for hashCode.
     */

    /**
     * Testing hashCode with One Exercise.
     */
    @Test
    public final void testhashCodeOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        Workout wRef = new Workout1L();
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(wRef.hashCode(), w.hashCode());
    }

    /**
     * Testing hashCode with Few Exercise.
     */
    @Test
    public final void testhashCodeFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        Workout wRef = new Workout1L();
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(wRef.hashCode(), w.hashCode());
    }

    /**
     * Testing hashCode with Multiple Exercise.
     */
    @Test
    public final void testhashCodeMultiple() {
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

        Workout wRef = new Workout1L();
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Push Ups", THREE, TWELVE, SIXTY);
        wRef.add("Shrugs", THREE, TWELVE, SIXTY);
        wRef.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);

        assertEquals(wRef.hashCode(), w.hashCode());
    }

    /*
     * Test cases for Equals.
     */

    /**
     * Testing Equals with One Exercise.
     */
    @Test
    public final void testEqualsOne() {
        Workout w = new Workout1L();
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        Workout wRef = new Workout1L();
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(wRef.toString(), w.toString());
        assertEquals(true, w.equals(wRef));
    }

    /**
     * Testing Equals with Few Exercise.
     */
    @Test
    public final void testEqualsFew() {
        Workout w = new Workout1L();
        w.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        w.add("Tricep Push Downs", THREE, TEN, SIXTY);
        w.add("Pull Ups", THREE, TWELVE, SIXTY);

        Workout wRef = new Workout1L();
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);

        assertEquals(wRef.toString(), w.toString());
        assertEquals(true, w.equals(wRef));
    }

    /**
     * Testing Equals with Multiple Exercise.
     */
    @Test
    public final void testEqualsMultiple() {
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

        Workout wRef = new Workout1L();
        wRef.add("Bench Press", THREE, SIX, ONEHUNDREDTWENTY);
        wRef.add("Tricep Push Downs", THREE, TEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Push Ups", THREE, TWELVE, SIXTY);
        wRef.add("Shrugs", THREE, TWELVE, SIXTY);
        wRef.add("Dumbbell Fly", THREE, FIFTEEN, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, ONEHUNDREDTWENTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Pull Ups", THREE, TWELVE, SIXTY);
        wRef.add("Bicep Curls", THREE, SIX, ONEHUNDREDTWENTY);

        assertEquals(wRef.toString(), w.toString());
        assertEquals(true, w.equals(wRef));
    }

}
