public class MyMinHeap<T extends Comparable<T>> {
    private final MyList<T> data;

    public MyMinHeap() {
        this.data = new MyArrayList<>();
    }

    public void insert(T item) {
        data.addLast(item);
        heapifyUp(data.size() - 1);
    }

    public T getMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");
        return data.get(0);
    }

    public T extractMin() {
        if (isEmpty()) throw new RuntimeException("Heap is empty");

        T min = data.get(0);
        T last = data.get(data.size() - 1);
        data.set(0, last);
        data.removeLast();

        heapifyDown(0);

        return min;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T current = data.get(index);
            T parent = data.get(parentIndex);

            if (current.compareTo(parent) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int size = data.size();
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && data.get(left).compareTo(data.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < size && data.get(right).compareTo(data.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public int size() {
        return data.size();
    }

    public void printHeap() {
        for (T item : data) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
