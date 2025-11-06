import components.standard.Standard;

/**
 * Workout kernel component with primary methods. (Note: by package-wide
 * convention, all references are non-null.)
 *
 * @mathsubtypes PARTIAL_FUNCTION is finite set of (name: String, sets: int,
 *               reps: int, restTime: int)
 * @mathmodel type WorkoutKernel is modeled by PARTIAL_FUNCTION
 * @initially <pre>
 * ():
 *  ensures
 *   this = {}
 * </pre>
 * @iterator <pre>
 * entires(~this.seen * ~this.unseen) = this and
 * |~this.seen * ~this.unseen| = |this|
 * </pre>
 */
public interface WorkoutKernel
        extends Standard<Workout>, Iterable<Workout.Exercise> {
    /**
     * Adds the exercise ({@code name}, {@code sets}, {@code reps},
     * {@code restTime}) to the end of this.
     *
     * @param name
     *            the name to be added
     * @param sets
     *            the associated sets to be added
     * @param reps
     *            the associated reps to be added
     * @param restTime
     *            the associated rest time to be added
     * @aliases references {@code name, sets, reps, restTime}
     * @updates this
     * @ensures this = #this union {(name, sets, reps, restTime)}
     */
    void add(String name, int sets, int reps, int restTime);

    /**
     * Removes the exercise at {@code pos} in {@code this} and returns it.
     *
     * @param pos
     *            the position of the exercise to be removed
     * @return the removed exercise
     * @updates this
     * @requires {@code 0 <= pos and pos < |this|}
     * @ensures {@code
     * this = #this[0, pos) * #this[pos+1, |this|) and
     * <remove> = #this[pos, pos+1)
     * }
     */
    Workout.Exercise remove(int pos);

    /**
     * Reports length of {@code this}.
     *
     * @return the number of exercises in {@code this}
     * @ensures length = |this|
     */
    int length();
}
