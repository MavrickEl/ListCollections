import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {
    private MyArrayList<String> myArrayList;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
    }

    @Test
    void add() {
        myArrayList.add("Element 1");
        assertEquals(1, myArrayList.size());
        assertEquals("Element 1", myArrayList.get(0));
    }

    @Test
    void testAdd() {
        myArrayList.add("Element 1");
        myArrayList.add("Element 3");
        myArrayList.add("Element 4");

        myArrayList.add("Element 2", 1);

        assertEquals(4, myArrayList.size());
        assertEquals("Element 1", myArrayList.get(0));
        assertEquals("Element 2", myArrayList.get(1));
        assertEquals("Element 3", myArrayList.get(2));
        assertEquals("Element 4", myArrayList.get(3));
    }

    @Test
    void removeAt() {
        myArrayList.add("Element 1");
        myArrayList.add("Element 2");
        myArrayList.add("Element 3");

        assertTrue(myArrayList.removeAt(1));

        assertEquals(2, myArrayList.size());
        assertEquals("Element 1", myArrayList.get(0));
        assertEquals("Element 3", myArrayList.get(1));
    }

    @Test
    void contains() {
        myArrayList.add("Element 1");
        myArrayList.add("Element 2");

        assertTrue(myArrayList.contains("Element 1"));
        assertFalse(myArrayList.contains("Element 3"));
    }

    @Test
    void remove() {
        myArrayList.add("Element 1");
        myArrayList.add("Element 2");
        myArrayList.add("Element 3");

        assertTrue(myArrayList.remove("Element 2"));

        assertEquals(2, myArrayList.size());
        assertEquals("Element 1", myArrayList.get(0));
        assertEquals("Element 3", myArrayList.get(1));
    }

    @Test
    void sort() {
        myArrayList.add("Banana");
        myArrayList.add("Apple");
        myArrayList.add("Orange");

        myArrayList.sort();

        assertEquals("Apple", myArrayList.get(0));
        assertEquals("Banana", myArrayList.get(1));
        assertEquals("Orange", myArrayList.get(2));
    }

    @Test
    void clear() {
        myArrayList.add("Element 1");
        myArrayList.add("Element 2");

        myArrayList.clear();

        assertEquals(0, myArrayList.size());
    }
}
