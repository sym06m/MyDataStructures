public class MyLinkedList<T> implements MyList<T> {
    private static class MyNode<T> {
        T element;
        MyNode<T> next;
        MyNode<T> prev;

        public MyNode(T element) {
            this.element = element;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        current.element = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }
        MyNode<T> current = head;
        for (int i = 0; i < index - 1; i++) current = current.next;
        MyNode<T> newNode = new MyNode<>(item);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.element;
    }

    @Override
    public T getFirst() {
        if (size == 0) throw new IllegalStateException("List is empty");
        return head.element;
    }

    @Override
    public T getLast() {
        if (size == 0) throw new IllegalStateException("List is empty");
        return tail.element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        MyNode<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    @Override
    public void removeFirst() {
        if (size == 0) throw new IllegalStateException("List is empty");
        head = head.next;
        if (head != null) head.prev = null;
        else tail = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (size == 0) throw new IllegalStateException("List is empty");
        tail = tail.prev;
        if (tail != null) tail.next = null;
        else head = null;
        size--;
    }

    @Override
    public void sort() {
        Object[] arr = toArray();
        Arrays.sort(arr);
        clear();
        for (Object obj : arr) addLast((T) obj);
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.element.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = tail;
        int lastIndex = size - 1;
        while (current != null) {
            if (current.element.equals(object)) return lastIndex;
            current = current.prev;
            lastIndex--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        MyNode<T> current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.element;
            current = current.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private MyNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}
