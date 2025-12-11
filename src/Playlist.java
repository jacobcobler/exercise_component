import components.workout.Workout;
import components.workout.Workout1L;

/**
 * A Playlist object implemented on top of the Workout component.
 * (Proof-Of-Concept Component).
 */
public class Playlist {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this}.
     */
    private Workout rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new Workout1L();
    }

    /*
     * Public members --------------------------------------------------------
     */

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    public Playlist() {
        this.createNewRep();
    }

    /**
     * Adds the song to the queue and stores the {@Code name}, {@Code genre}
     * number, and the {@Code runTime} of the song.
     *
     * @param name
     *            Name of song
     * @param genre
     *            Genre of song
     * @param runTime
     *            Run time of song
     *
     */
    public void enqueue(String name, int genre, int runTime) {
        this.rep.add(name, genre, 0, runTime);
    }

    /**
     * Removes the first song from the queue and returns the SimpleSong
     * representation of it.
     *
     * @return The First Song
     *
     */
    public Playlist.SimpleSong dequeue() {
        Workout.Exercise removed = this.rep.remove(0);
        return new SimpleSong(removed.name(), removed.sets(),
                removed.restTime());
    }

    /**
     * Returns the length of the playlist.
     *
     * @return length of the playlist
     *
     */
    public int length() {
        return this.rep.length();
    }

    /**
     * {@Code Playlist.SimpleSong} implementation.
     */
    protected static final class SimpleSong extends Object {

        /**
         * A variable to hold the name of {@code this}.
         */
        private String name;
        /**
         * A variable to hold the genre of {@code this}.
         */
        private int genre;
        /**
         * A variable to hold the run Time of {@code this}.
         */
        private int runTime;

        /**
         * Constructor.
         *
         * @param name
         *            the name to be set
         * @param genre
         *            the associated genre to be set
         * @param runTime
         *            the associated run Time to be set
         */
        public SimpleSong(String name, int genre, int runTime) {
            this.name = name;
            this.genre = genre;
            this.runTime = runTime;
        }

        /**
         * Song name getter.
         *
         * @return Song name
         */
        public String name() {
            return this.name;
        }

        /**
         * Song genre getter.
         *
         * @return Song genre
         */
        public int genre() {
            return this.genre;
        }

        /**
         * Song run time getter.
         *
         * @return Song run time
         */
        public int runTime() {
            return this.runTime;
        }
        /*
         * Common methods (from Object)
         * -------------------------------------------
         */

        // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
        @Override
        public String toString() {
            return "[" + this.name + ", " + this.genre + ", " + this.runTime
                    + "]";
        }
    }
}
