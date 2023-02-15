package module_9.MyCollection;

public interface MyQueue<E> extends MyCollection<E> {
    E poll();
    E peek();
    void add(E e);
}
