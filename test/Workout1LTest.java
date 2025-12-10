public abstract class Workout1LTest {

    /*
     * Test cases for Add.
     */
    @Test
    public final void testAdd() {
        Workout w = new Workout1L();
        w.add("Pull Ups", 3, 12, 60);
        assertEquals(1, w.length());
    }

}
