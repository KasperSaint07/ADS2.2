public class MyStack<T> {
    private final MyList<T> data;

    public MyStack(MyList<T> listImpl) {
        this.data = listImpl;
    }

    public void push(T item) {
        data.addLast(item);
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        T value = data.getLast();
        data.removeLast();
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return data.getLast();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public int size() {
        return data.size();
    }
}
