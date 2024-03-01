public class MyLinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public MyLinkedList() {
    }

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

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public int size() {
        return size;
    }

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

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

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
