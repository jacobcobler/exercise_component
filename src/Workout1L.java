import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * {@code Workout} represented as a {@link java.util.List java.util.List} with
 * implementations of primary methods.
 *
 * @convention $this.rep.entries /= null
 * @correspondence <pre>
 * this = [value of $this.rep based on List's "proper sequence"]
 * </pre>
 */
public class Workout1L extends WorkoutSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private List<Workout.Exercise> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new LinkedList<Workout.Exercise>();
    }

    /**
     * No-argument constructor.
     */
    public Workout1L() {
        this.createNewRep();
    }

    /*
     * Standard methods -------------------------------------------------------
     */

    @Override
    public final Workout newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Workout source) {
        assert source != null : "Violation of: source is not null";
        assert source != null : "Violation of: source is not this";
        assert source instanceof Workout1L : ""
                + "Violation of: source is of dynamic type Workout1L";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case: source must be of dynamic type Queue1L<?>,
         * and the ? must be T or the call would not have compiled.
         */
        Workout1L localSource = (Workout1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void add(String name, int sets, int reps, int restTime) {
        assert name != null : "Violation of: name is not null";
        assert sets >= 1 : "Violation of: sets is >= 1";
        assert reps >= 1 : "Violation of: reps is >= 1";
        this.rep.add(new SimpleExercise(name, sets, reps, restTime));
    }

    @Override
    public final Workout.Exercise remove(int pos) {
        assert this.length() > 0 : "Violation of: this /= <>";
        return this.rep.remove(pos);
    }

    @Override
    public final int length() {
        return this.rep.size();
    }

    @Override
    public final Iterator<Workout.Exercise> iterator() {
        return new Workout1LIterator();
    }

    /**
     * Implementation of {@code Iterator} interface for {@code Queue1L}.
     */
    private final class Workout1LIterator
            implements Iterator<Workout.Exercise> {

        /**
         * Representation iterator.
         */
        private final Iterator<Workout.Exercise> iterator;

        /**
         * No-argument constructor.
         */
        private Workout1LIterator() {
            this.iterator = Workout1L.this.rep.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override
        public Workout.Exercise next() {
            assert this.hasNext() : "Violation of: ~this.unseen /= <>";
            if (!this.hasNext()) {
                /*
                 * Exception is supposed to be thrown in this case, but with
                 * assertion-checking enabled it cannot happen because of assert
                 * above.
                 */
                throw new NoSuchElementException();
            }
            return this.iterator.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException(
                    "remove operation not supported");
        }
    }

}
