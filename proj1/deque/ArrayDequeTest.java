package deque;

import org.junit.Test;



import static org.junit.Assert.*;


public class ArrayDequeTest {

    @Test
    /** Adds a few things to the deque, checking isEmpty() and size() are correct,
     * finally printing the results. */
    public void addIsEmptySizeTest() {

        ArrayDeque<String> ad1 = new ArrayDeque<>();

        assertTrue("A newly initialized ArrayDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        assertEquals(1, ad1.size());
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque:");
        ad1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that ArrayDeque is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        assertTrue("ad1 should be empty upon initialization", ad1.isEmpty());

        ad1.addFirst(1);
        assertFalse("ad1 should contain 1 item", ad1.isEmpty());

        ad1.removeFirst();
        assertTrue("ad1 should be empty after removal", ad1.isEmpty());

    }

    @Test
    public void removeEmptyTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(3);
        ad1.addLast(10);

        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();

        int size = ad1.size();
        String errorMsg = "  Bad size return when removing from empty deque.\n";
        errorMsg += "  student size() return " + size + "\n";
        errorMsg += " actual size() return 1\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    public void mutipleParamTest() {

        ArrayDeque<String>  ad1 = new ArrayDeque<String>();
        ArrayDeque<Double>  ad2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<Boolean>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();

        assertEquals("string", s);
        assertEquals(3.14159, d, 0.001);
        assertEquals(true, b);


    }

    @Test
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        assertEquals("Should return null when removeFirst is called on an empty Deque", null, ad1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque", null, ad1.removeLast());
    }

    @Test
    public void bigArrayDequeTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for(int i = 0; i < 1000000; i++) {
            ad1.addFirst(i);
        }

        for(int i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (int) ad1.removeFirst(),0.0);
        }

        for(int i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (int) ad1.removeLast(), 0.0);
        }
    }

}