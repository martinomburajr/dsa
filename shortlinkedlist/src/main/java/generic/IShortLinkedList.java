package generic;

public interface IShortLinkedList<T> {
    T get(short index);
    void add(T t);
    void add(short index, T t);
    void insert(short index, T t);
    void remove(short index);
    void remove(T t);
    T first();
    T last();
    short size();
}
