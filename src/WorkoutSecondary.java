import java.util.Objects;

/**
 * Layered implementation of secondary methods for {@code Workout}.
 */
public abstract class WorkoutSecondary implements Workout {

    /*
     * Public members ---------------------------------------------------------
     */

    /*
     * Common methods (from Object) -------------------------------------------
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("(");
        Workout.Exercise exercise = this.remove(0);
        result.append(exercise.toString());
        if (this.length() > 0) {
            result.append(",");
            result.append(this.toString());
        } else {
            result.append(")");
        }
        this.add(exercise.name(), exercise.sets(), exercise.reps(),
                exercise.restTime());
        return result.toString();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public boolean equals(Object obj) {
        boolean equality = false;
        if (this == obj) {
            equality = true;
        }
        if (!(obj instanceof Workout)) {
            equality = false;
        }
        Workout workout = (Workout) obj;
        if (!Objects.equals(this.toString(), workout.toString())) {
            equality = false;
        }
        return equality;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int hashCode() {
        int hash = 0;
        Workout.Exercise exercise = this.remove(0);
        for (int i = 0; i < exercise.name().length(); i++) {
            hash += Character.digit(exercise.name().charAt(i), 10);
        }
        hash += exercise.sets();
        hash += exercise.reps();
        hash += exercise.restTime();
        if (this.length() > 0) {
            hash += this.hashCode();
        }
        this.add(exercise.name(), exercise.sets(), exercise.reps(),
                exercise.restTime());
        return hash;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Workout.Exercise first() {
        Workout.Exercise exercise = this.remove(this.length() - 1);
        Workout.Exercise firstExercise = exercise;
        if (this.length() > 0) {
            firstExercise = this.first();
        }
        this.add(exercise.name(), exercise.sets(), exercise.reps(),
                exercise.restTime());
        return firstExercise;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Workout.Exercise replace(int pos, Workout.Exercise exercise) {
        Workout.Exercise currentExercise = this.remove(this.length() - 1);
        Workout.Exercise posExercise = currentExercise;
        if (this.length() - 1 > pos) {
            posExercise = this.replace(pos, exercise);
        }
        if (this.length() - 1 == pos) {
            this.add(exercise.name(), exercise.sets(), exercise.reps(),
                    exercise.restTime());
        } else {
            this.add(currentExercise.name(), currentExercise.sets(),
                    currentExercise.reps(), currentExercise.restTime());
        }
        return posExercise;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Workout.Exercise get(int pos) {
        Workout.Exercise exercise = this.remove(this.length() - 1);
        Workout.Exercise posExercise = exercise;
        if (this.length() - 1 > pos) {
            posExercise = this.get(pos);
        }
        this.add(exercise.name(), exercise.sets(), exercise.reps(),
                exercise.restTime());
        return posExercise;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void combine(Workout w) {
        if (w.length() > 0) {
            Workout.Exercise exercise = w.remove(0);
            this.add(exercise.name(), exercise.sets(), exercise.reps(),
                    exercise.restTime());
            this.combine(w);
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void flip() {
        if (this.length() > 0) {
            Workout.Exercise exercise = this.remove(0);
            this.flip();
            this.add(exercise.name(), exercise.sets(), exercise.reps(),
                    exercise.restTime());
        }
    }

    /**
     * Implementation of {@code Workout.Exercise} interface.
     */
    protected static final class SimpleExercise extends Object
            implements Workout.Exercise {

        /**
         * A variable to hold the name of {@code this}.
         */
        private String name;
        /**
         * A variable to hold the sets of {@code this}.
         */
        private int sets;
        /**
         * A variable to hold the reps of {@code this}.
         */
        private int reps;
        /**
         * A variable to hold the restTime of {@code this}.
         */
        private int restTime;

        /**
         * Constructor.
         *
         * @param name
         *            the name to be set
         * @param sets
         *            the associated sets to be set
         * @param reps
         *            the associated reps to be set
         * @param restTime
         *            the associated rest time to be set
         */
        public SimpleExercise(String name, int sets, int reps, int restTime) {
            this.name = name;
            this.sets = sets;
            this.reps = reps;
            this.restTime = restTime;
        }

        @Override
        public String name() {
            return this.name;
        }

        @Override
        public int sets() {
            return this.sets;
        }

        @Override
        public int reps() {
            return this.reps;
        }

        @Override
        public int restTime() {
            return this.restTime;
        }
    }

}
