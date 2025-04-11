public class MyQueue<T> {
    private final MyList<T> data;

    public MyQueue(MyList<T> listImpl) {
        this.data = listImpl;
    }

    public void enqueue(T item) {
        data.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T value = data.getFirst();
        data.removeFirst();
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return data.getFirst();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public int size() {
        return data.size();
    }
}
