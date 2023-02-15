package module_9.MyCollection;

public interface MyList<E> extends MyCollection<E> {
    E get(int index);
    E remove(int index);
    void add(E e);
}