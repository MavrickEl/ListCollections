/**
 * Custom implementation of a doubly linked list.
 * Supports adding, removing, sorting, and other operations.
 *
 * @param <T> the type of elements in the list
 */
public class MyLinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public MyLinkedList() {
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param object the element to be added
     * @return true if the element was added successfully
     */
    @Override
    public boolean add(T object) {
        if (size == 0) {
            first = new Node<>(null, object, null);
            last = first;
        } else {
            Node<T> secondLast = last;
            last = new Node<>(secondLast, object, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    /**
     * Adds an element at a specified index in the linked list.
     *
     * @param object the element to be added
     * @param index  the index at which the element is to be added
     * @return true if the element was added successfully
     */
    @Override
    public boolean add(T object, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return add(object);

        }
        Node<T> nodeNext = getNode(index);
        Node<T> nodePrevious = nodeNext.previous;
        Node<T> nodeNew = new Node<>(nodePrevious, object, nodeNext);
        nodeNext.previous = nodeNew;
        if (nodePrevious != null) {
            nodePrevious.next = nodeNew;
        } else {
            first = nodeNew;
        }
        size++;
        return true;
    }

    /**
     * Retrieves the element at the specified index in the linked list.
     * Calls getNode() method to get the value.
     *
     * @param index the index of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    /**
     * Returns the current size of the linked list.
     *
     * @return the size of the linked list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes the element at the specified index from the linked list.
     *
     * @param index the index of the element to be removed
     * @return true if the element was removed successfully
     */
    @Override
    public boolean removeAt(int index) {
        Node<T> node = getNode(index);
        Node<T> nodeNext = node.next;
        Node<T> nodePrevious = node.previous;
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        size--;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from the linked list.
     *
     * @param object the element to be removed
     * @return true if the element was found and removed successfully
     */
    @Override
    public boolean remove(T object) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(object)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    /**
     * Checks if the linked list contains the specified element.
     *
     * @param object the element to be checked
     * @return true if the linked list contains the element, false otherwise
     */
    @Override
    public boolean contains(T object) {
        Node<T> second = first;
        Node<T> last = second.next;
        if (second.value.equals(object)) {
            return true;
        }
        while (last != null) {
            if (last.value.equals(object)) {
                return true;
            } else {
                last = last.next;
            }
        }
        return false;
    }

    /**
     * Sorts the elements in the linked list in natural order.
     * Uses an auxiliary MyArrayList for sorting.
     */
    @Override
    public void sort() {
        MyArrayList<T> arrayList = new MyArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(get(i));
        }
        arrayList.sort();
        clear();
        for (int i = 0; i < arrayList.size(); i++) {
            add(arrayList.get(i));
        }

    }

    /**
     * Removes all elements from the linked list, leaving it empty.
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Retrieves the node at the specified index in the linked list.
     *
     * @param index the index of the node to retrieve
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Node<T> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     * Node class representing elements in the linked list.
     *
     * @param <T> the type of value in the node
     */
    private static class Node<T> {
        private Node<T> previous;
        T value;
        private Node<T> next;

        public Node(Node<T> previous, T value, Node<T> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "empty list";
        }
        StringBuilder sb = new StringBuilder("MyLinkedList{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(getNode(i).value).append(", ");
        }
        sb.append(getNode(size - 1).value);
        sb.append("}");
        return String.valueOf(sb);
    }
}
