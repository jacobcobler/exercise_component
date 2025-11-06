import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This is an example class for the Exercise component.
 */
public final class Workout {

    /**
     * A Constant for testing inputs.
     */
    private static final int REP_NUMBER = 15;

    /**
     * A Workout built on Queue but that should contain the Exercise internal
     * class instead of Map. It also wouldn't be static in the implementation.
     */
    private static Queue<Map<String, Integer>> exercises;

    /**
     * No-argument Constructor.
     */
    private Workout() {

    }

    /**
     * Adds the exercise to the workoout. Rest time and Sets have been left off
     * since map just stores a pair, will need to create an "Exercise" field
     * that stores four values.
     *
     * @param q
     *            the workout.
     * @param exercise
     *            The exercise name
     * @param reps
     *            The amount of reps to perform
     */
    public static void add(Queue<Map<String, Integer>> q, String exercise,
            int reps) {
        Map<String, Integer> m = new Map1L<>();
        m.add(exercise, reps);
        q.enqueue(m);
    }

    /**
     * Removes the exercise at the specified position.
     *
     * @param q
     *            The workout
     * @param pos
     *            Position to remove
     * @return map of exercise and reps (Will be Exercise when that is created).
     */
    public static Map<String, Integer> remove(Queue<Map<String, Integer>> q,
            int pos) {
        Queue<Map<String, Integer>> tempQ = new Queue1L<>();
        Map<String, Integer> tempM = new Map1L<>();
        for (int i = 0; i <= q.length() - 1; i++) {
            Map<String, Integer> m = q.dequeue();
            if (i == pos) {
                tempM = m;
            } else {
                tempQ.enqueue(m);
            }
        }
        flip(q);
        for (int i = 0; i < q.length() - 1; i++) {
            q.enqueue(tempQ.dequeue());
        }
        flip(q);
        return tempM;
    }

    /**
     * Returns how many exercises are in the workout.
     *
     * @param q
     *            the workout
     * @return returns the length of the workout
     */
    public static int length(Queue<Map<String, Integer>> q) {
        return q.length();
    }

    /**
     * Returns the first exercise up next in the workout.
     *
     * @param q
     *            The workout
     * @return The first exercise up next
     */
    public static Map<String, Integer> first(Queue<Map<String, Integer>> q) {
        return q.front();
    }

    /**
     * Reverses the order of the exercises in the workout.
     *
     * @param q
     *            The workout
     */
    public static void flip(Queue<Map<String, Integer>> q) {
        if (q.length() > 0) {
            Map<String, Integer> m = q.dequeue();
            flip(q);
            q.enqueue(m);
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter writer = new SimpleWriter1L();
        /*
         * Closest field to what I plan to create to order the workout.
         */
        exercises = new Queue1L<>();

        add(exercises, "Pull Ups", REP_NUMBER);
        add(exercises, "Push Ups", REP_NUMBER);
        writer.println("The Workout is currently " + length(exercises)
                + " exercises long");
        writer.println("The Workout currently is " + exercises);
        flip(exercises);
        writer.println("The Workout after being flipped is " + exercises);
        writer.println("The First Exercise to do is " + remove(exercises, 0));
        writer.println(
                "The Upcoming Exercise Is After finishing the current one is "
                        + first(exercises));
        writer.println(
                "The Workout has " + length(exercises) + " exercise left");
        writer.println("Now the exercise to do is " + remove(exercises, 0));
        writer.println(
                "The Workout has " + length(exercises) + " exercises left");

        writer.close();
    }
}
