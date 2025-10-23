/**
 * {@code WorkoutKernel} enhanced with secondary methods.
 *
 *
 */
public interface Workout extends WorkoutKernel {

    /**
     * A workout entry (name-sets-reps-restTime exercise). The only ways to
     * obtain a reference to a workout entry are from the iterator and
     * {@code Workout}'s {@code remove}, {@code get}, {@code replace}, and
     * {@code first} methods.
     *
     * @mathmodel type Exercise is modeled by (name: String, sets: int, reps:
     *            int, restTime: int)
     * @initially <pre>
     * (String name, int sets, int reps, int restTime)
     *  ensures
     *   this = (name, sets, reps, restTime)
     * </pre>
     */
    interface Exercise {
        /**
         * Returns this {@code Exercise}'s name.
         *
         * @return the name
         * @aliases reference returned by {@code name}
         */
        String name();

        /**
         * Returns this {@code Exercise}'s number of sets.
         *
         * @return the sets
         * @aliases reference returned by {@code sets}
         */
        int sets();

        /**
         * Returns this {@code Exercise}'s number of reps.
         *
         * @return the reps
         * @aliases reference returned by {@code reps}
         */
        int reps();

        /**
         * Returns this {@code Exercise}'s rest time in seconds.
         *
         * @return the rest time
         * @aliases reference returned by {@code restTime}
         */
        int restTime();
    }

    /**
     * Reports the front of {@code this}.
     *
     * @return the front entry of {@code this}
     * @aliases reference returned by {@code front}
     * @requires {@code this /= <>}
     * @ensures {@code <front> is prefix of this}
     */
    Workout.Exercise first();

    /**
     * Replaces the entry at position {@code pos} of {@code this} with the entry
     * {@code exercise} and returns the old entry at that position.
     *
     * @param pos
     *            the position at which to replace an entry
     * @param exercise
     *            the entry replacing the old one
     * @return the old entry at that position
     * @aliases reference {@code exercise}
     * @updates this
     * @requires {@code 0 <= pos and pos < |this|}
     * @ensures {@code
     * <replace> = #this[pos, pos+1) and
     * this = #this[0, pos) * <exercise> * #this[pos+1, |#this|)
     * }
     */
    Exercise replace(int pos, Exercise exercise);

    /**
     * Reports the entry at position {@code pos} of {@code this}.
     *
     * @param pos
     *            the position of the entry
     * @return the entry at that position
     * @aliases reference returned by {@code get}
     * @requires {@code 0 <= pos and pos < |this|}
     * @ensures {@code <get> = this[pos, pos+1)}
     */
    Exercise get(int pos);

    /**
     * Concatenates ("combines") {@code w} to the end of {@code this}.
     *
     * @param w
     *            the {@code Workout} to be appended on the end of {@code this}
     * @updates this
     * @clears w
     * @ensures this = #this * #w
     */
    void combine(Workout w);

    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    void flip();
}
