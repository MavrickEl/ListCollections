import java.lang.reflect.Array;
import java.util.Arrays;

public class MyArrayList<T> implements List<T> {
    private static final int CAPACITY = 10;

    private T[] array;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyArrayList(int size) {
        array = (T[]) Array.newInstance(this.getClass(), size);
    }

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) Array.newInstance(this.getClass(), CAPACITY);
    }

    @Override
    public boolean add(T object) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = object;
        size++;
        return true;
    }

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

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - index);
        size--;
        return true;
    }

    @Override
    public boolean contains(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return this.removeAt(i);
            }
        }
        return false;
    }

    @Override
    public void sort() {
        Arrays.sort(array, 0, size);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        array = (T[]) Array.newInstance(array.getClass(), CAPACITY);
        size = 0;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
