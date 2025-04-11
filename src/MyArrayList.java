public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    @Override
    public void add(int index, T item) {
        checkPositionIndex(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public void remove(int index) {
        checkElementIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void set(int index, T item) {
        checkElementIndex(index);
        elements[index] = item;
    }

    @Override
    public void clear() {
        elements = new Object[10];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = elements[i];
        }
        return result;
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(obj)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object obj) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(obj)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public void sort() {
        // простой пузырьковый алгоритм (bubble sort)
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Comparable<T> a = (Comparable<T>) elements[j];
                T b = (T) elements[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + index);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Invalid index for insert: " + index);
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return (T) elements[cursor++];
            }
        };
    }
}
