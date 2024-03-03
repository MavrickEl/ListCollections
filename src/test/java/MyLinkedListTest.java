import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {
    private MyLinkedList<String> myLinkedList;

    @BeforeEach
    void setUp() {
        myLinkedList = new MyLinkedList<>();
    }

    @Test
    void add() {
        assertTrue(myLinkedList.add("Element 1"));
        assertEquals(1, myLinkedList.size());
        assertEquals("Element 1", myLinkedList.get(0));
    }

    @Test
    void testAdd() {
        assertTrue(myLinkedList.add("Element 1"));
        assertTrue(myLinkedList.add("Element 3"));
        assertTrue(myLinkedList.add("Element 4"));

        assertTrue(myLinkedList.add("Element 2", 1));

        assertEquals(4, myLinkedList.size());
        assertEquals("Element 1", myLinkedList.get(0));
        assertEquals("Element 2", myLinkedList.get(1));
        assertEquals("Element 3", myLinkedList.get(2));
        assertEquals("Element 4", myLinkedList.get(3));
    }

    @Test
    void removeAt() {
        assertTrue(myLinkedList.add("Element 1"));
        assertTrue(myLinkedList.add("Element 2"));
        assertTrue(myLinkedList.add("Element 3"));

        assertTrue(myLinkedList.removeAt(1));

        assertEquals(2, myLinkedList.size());
        assertEquals("Element 1", myLinkedList.get(0));
        assertEquals("Element 3", myLinkedList.get(1));
    }

    @Test
    void remove() {
        assertTrue(myLinkedList.add("Element 1"));
        assertTrue(myLinkedList.add("Element 2"));
        assertTrue(myLinkedList.add("Element 3"));

        assertTrue(myLinkedList.remove("Element 2"));

        assertEquals(2, myLinkedList.size());
        assertEquals("Element 1", myLinkedList.get(0));
        assertEquals("Element 3", myLinkedList.get(1));
    }

    @Test
    void contains() {
        assertTrue(myLinkedList.add("Element 1"));
        assertTrue(myLinkedList.add("Element 2"));

        assertTrue(myLinkedList.contains("Element 1"));
        assertFalse(myLinkedList.contains("Element 3"));
    }

    @Test
    void sort() {
        assertTrue(myLinkedList.add("Banana"));
        assertTrue(myLinkedList.add("Apple"));
        assertTrue(myLinkedList.add("Orange"));

        myLinkedList.sort();

        assertEquals("Apple", myLinkedList.get(0));
        assertEquals("Banana", myLinkedList.get(1));
        assertEquals("Orange", myLinkedList.get(2));
    }

    @Test
    void clear() {
        assertTrue(myLinkedList.add("Element 1"));
        assertTrue(myLinkedList.add("Element 2"));

        myLinkedList.clear();

        assertEquals(0, myLinkedList.size());
        assertTrue(myLinkedList.toString().contains("empty list"));
    }
}