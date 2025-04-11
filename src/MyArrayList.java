public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int length;

    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    public void add(T element) {
        if (length == elements.length) {
            increaseCapacity();
        }
        elements[length++] = element;
    }

    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i]; // upcasting
        }
        elements = newElements;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) elements[index]; // downcasting
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--length] = null; // Clear the last element
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }

    public int size() {
        return length;
    }

    public void add(int index, T element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Index: " + index + " out of bounds");
        }
        if (length == elements.length) {
            increaseCapacity();
        }
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        length++;
    }

    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    public void addFirst(T element) {
        add(0, element);
    }

    public void addLast(T element) {
        add(element);
    }

    public T getFirst() {
        if (length == 0) {
            return null;
        }
        return (T) elements[0];
    }

    public T getLast() {
        if (length == 0) {
            return null;
        }
        return (T) elements[length - 1];
    }

    public void removeFirst() {
        if (length == 0) {
            throw new NoSuchElementException("The list is empty");
        }
        remove(0);
    }

    public void removeLast() {
        if (length == 0) {
            throw new NoSuchElementException("The list is empty");
        }
        remove(length - 1);
    }

    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                Comparable<T> current = (Comparable<T>) elements[j];
                T next = (T) elements[j + 1];
                if (current.compareTo(next) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    public Object[] toArray() {
        Object[] newArray = new Object[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = elements[i];
        }
        return newArray;
    }

    public void clear() {
        for (int i = 0; i < length; i++) {
            elements[i] = null;
        }
        length = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) elements[index++];
            }
        };
    }
}
