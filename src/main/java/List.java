/**
 * An interface representing a generic list of elements.
 * Lists maintain an ordered collection of elements.
 *
 * @param <T> the type of elements in the list
 */
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
