package org.howard.edu.lsp.assignment6;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @Before
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    public void testAddAndToString() {
        set1.add(5);
        set1.add(10);
        set1.add(5);  // duplicate
        assertEquals("[5, 10]", set1.toString());
    }

    @Test
    public void testClearAndIsEmpty() {
        set1.add(1);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    public void testLength() {
        set1.add(1);
        set1.add(2);
        assertEquals(2, set1.length());
    }

    @Test
    public void testEquals() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(1);
        assertTrue(set1.equals(set2));
        set2.add(3);
        assertFalse(set1.equals(set2));
    }

    @Test
    public void testContains() {
        set1.add(42);
        assertTrue(set1.contains(42));
        assertFalse(set1.contains(99));
    }

    @Test
    public void testLargest() {
        set1.add(10);
        set1.add(5);
        set1.add(20);
        assertEquals(20, set1.largest());

        set1.clear();
        try {
            set1.largest();
            fail("Expected RuntimeException when set is empty");
        } catch (RuntimeException e) {
            assertEquals("Cannot find largest - set is empty", e.getMessage());
        }
    }

    @Test
    public void testSmallest() {
        set1.add(10);
        set1.add(5);
        set1.add(20);
        assertEquals(5, set1.smallest());

        set1.clear();
        try {
            set1.smallest();
            fail("Expected RuntimeException when set is empty");
        } catch (RuntimeException e) {
            assertEquals("Cannot find smallest - set is empty", e.getMessage());
        }
    }

    @Test
    public void testRemove() {
        set1.add(1); set1.add(2); set1.add(3);
        set1.remove(2);
        assertFalse(set1.contains(2));
        set1.remove(99);  // not in set
        assertEquals(2, set1.length());
    }

    @Test
    public void testUnion() {
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(3);
        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertEquals(3, set1.length());
    }

    @Test
    public void testIntersect() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        set1.intersect(set2);
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertEquals(2, set1.length());
    }

    @Test
    public void testDiff() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(4);
        set1.diff(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(2));
        assertEquals(2, set1.length());
    }

    @Test
    public void testComplement() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(2); set2.add(3); set2.add(4);
        set1.complement(set2);
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
        assertEquals(2, set1.length());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(set1.isEmpty());
        set1.add(100);
        assertFalse(set1.isEmpty());
    }

    @Test
    public void testToString() {
        set1.add(5);
        set1.add(6);
        assertEquals("[5, 6]", set1.toString());
    }

    @Test
    public void testConstructorWithArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(2);
        IntegerSet newSet = new IntegerSet(list);
        assertTrue(newSet.contains(1));
        assertTrue(newSet.contains(2));
        assertEquals(2, newSet.length());
    }

    // 🔽 Additional Robust Tests

    @Test
    public void testAddNegativeAndDuplicates() {
        set1.add(-10);
        set1.add(-5);
        set1.add(-10);  // duplicate
        assertTrue(set1.contains(-10));
        assertTrue(set1.contains(-5));
        assertEquals(2, set1.length());
    }

    @Test
    public void testRemoveFromEmptySet() {
        assertTrue(set1.isEmpty());
        set1.remove(10);  // should do nothing
        assertTrue(set1.isEmpty());
    }

    @Test
    public void testIntersectWithNoOverlap() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.intersect(set2);
        assertTrue(set1.isEmpty());
    }

    @Test
    public void testDiffNoOverlap() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.diff(set2);
        assertEquals(2, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
    }

    @Test
    public void testUnionWithEmptySet() {
        set1.add(1); set1.add(2);
        // set2 remains empty
        set1.union(set2);
        assertEquals(2, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
    }

    @Test
    public void testComplementEmptyBase() {
        set2.add(1); set2.add(2); set2.add(3);
        set1.complement(set2);  // set1 is empty
        assertEquals(3, set1.length());
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
    }

    @Test
    public void testEqualsWithSelf() {
        set1.add(1); set1.add(2);
        assertTrue(set1.equals(set1));
    }

    @Test
    public void testEqualsWithDifferentObject() {
        set1.add(1); set1.add(2);
        assertFalse(set1.equals("not a set"));
    }

    @Test
    public void testChainedOperations() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);

        set1.diff(set2);          // [1]
        set1.union(set2);         // [1, 2, 3, 4]
        set1.remove(3);           // [1, 2, 4]

        assertEquals(3, set1.length());
        assertFalse(set1.contains(3));
        assertTrue(set1.contains(4));
    }
}
