public interface List<T> {
    boolean add(T object);

    boolean add(T object, int index);

    T get(int index);

    int size();

    boolean removeAt(int index);

    boolean remove(T object);

    boolean contains(T object);

    void sort();

    void clear();


}
