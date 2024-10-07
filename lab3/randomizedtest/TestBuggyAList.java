package randomizedtest;

import edu.princeton.cs.algs4.LazyPrimMST;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> ANoBug = new AListNoResizing<>();
        BuggyAList<Integer> BhasBug = new BuggyAList<>();
        ANoBug.addLast(4);
        BhasBug.addLast(4);
        ANoBug.addLast(5);
        BhasBug.addLast(5);
        ANoBug.addLast(6);
        BhasBug.addLast(6);

        Assert.assertEquals(ANoBug.size(), BhasBug.size());
        Assert.assertEquals(ANoBug.removeLast(), BhasBug.removeLast());
        Assert.assertEquals(ANoBug.removeLast(), BhasBug.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                Assert.assertEquals(L.size(), B.size());
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                if(size == 0){
                    continue;
                }
                int removeLastL = L.removeLast();
                int removeLastB = B.removeLast();
                Assert.assertEquals(removeLastB, removeLastL);
            } else if (operationNumber == 2) {
                if(L.size() == 0){
                    continue;
                }
                int lastL = L.getLast();
                int lastB = B.getLast();
                Assert.assertEquals(lastL, lastB);

            }
        }
    }
  // YOUR TESTS HERE
}
