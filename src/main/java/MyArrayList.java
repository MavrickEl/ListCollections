import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Custom implementation of a dynamic array list.
 * Supports adding, removing, sorting, and other operations.
 *
 * @param <T> the type of elements in the list
 **/
public class MyArrayList<T> implements List<T> {
    private static final int CAPACITY = 10;
    private Object[] array;
    private int size = 0;

    /**
     * Constructs an empty array list with the default capacity.
     */
    public MyArrayList() {
        this.array = new Object[CAPACITY];
    }

    /**
     * Constructs an empty array list with a specified initial capacity.
     *
     * @param size the initial capacity of the array list
     */
    public MyArrayList(int size) {
        this.array = new Object[size];
    }

    /**
     * Adds an element to the end of the array list.
     *
     * @param object the element to be added
     * @return true if the element was added successfully
     */
    @Override
    public boolean add(T object) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = object;
        size++;
        return true;
    }

    /**
     * Adds an element at a specified index in the array list.
     *
     * @param object the element to be added
     * @param index  the index at which the element is to be added
     * @return true if the element was added successfully
     */
    @Override
    public boolean add(T object, int index) {
        if (size == array.length - 1) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = object;
        size++;
        return true;
    }

    /**
     * Retrieves the element at the specified index in the array list.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    /**
     * Returns the current size of the array list.
     *
     * @return the size of the array list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes the element at the specified index from the array list.
     *
     * @param index the index of the element to be removed
     * @return true if the element was removed successfully
     */
    @Override
    public boolean removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index);
        size--;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from the array list.
     *
     * @param object the element to be removed
     * @return true if the element was found and removed successfully
     */
    @Override
    public boolean remove(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return this.removeAt(i);
            }
        }
        return false;
    }

    /**
     * Checks if the array list contains the specified element.
     *
     * @param object the element to be checked
     * @return true if the array list contains the element, false otherwise
     */
    @Override
    public boolean contains(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sorts the elements in the array list in natural order.
     */
    @Override
    public void sort() {
        Arrays.sort(array, 0, size);
    }

    /**
     * Removes all elements from the array list, leaving it empty.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        array = (T[]) Array.newInstance(array.getClass(), CAPACITY);
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    /**
     * Custom iterator implementation for MyArrayList.
     */
    private class MyArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(currentIndex++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove operation is not supported");
        }
    }
}
