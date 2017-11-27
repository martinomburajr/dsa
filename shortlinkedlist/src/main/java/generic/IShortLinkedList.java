package generic;

public interface IShortLinkedList<T> {
    T root();
    T get(short index);
    T tail();
    void add(T t);
    void add(short index, T t);
    void insert(short index, T t);
    void remove(short index);
    void remove(T t);
    T first();
    T last();
    short size();
}
