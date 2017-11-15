package generic;

import com.sun.istack.internal.NotNull;

public class ShortLinkedList<T> implements IShortLinkedList<T> {
    private Node<T> root;
    private Node<T> tail;
    private short size;
    private boolean isAdulterated = false;

    public ShortLinkedList() {
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }


    @Override
    public T root() {
        return root.getValue();
    }

    @Override
    public T get(short index) {
        if(index > (size-1)) {
            throw new IndexOutOfBoundsException();
        }else{
            Node<T> base;
            for (int i = 0; i < index; i++) {
                base = root.getNext();
                if(i == index){
                    return base.getValue();
                }
            }
            return null;
        }
    }

    @Override
    public T tail() {
        return tail.getValue();
    }

    @Override
    public void add(T t) {
        if(tail == null) {
            Node base;
            for (int i = 0; i < size; i++) {
                base = root.getNext();
                if(i == (size-1)) {
                    base.setNext(new Node<T>(t, null));
                    tail = base.getNext();
                }
            }
            root.setNext(new Node<T>(t, null));
            tail = root.getNext();
        }else{
            tail.setNext(new Node<T>(t, null));
        }
        size++;
        isAdulterated = true;
    }

    @Override
    public void add(short index, T t) {
        if(index > (size-1)) {
            throw new IndexOutOfBoundsException();
        }else{
            Node base;
            for (int i = 0; i < index; i++) {
                base = root.getNext();
                if(i == (index-1)) {
                    base.setNext(new Node<T>(t, null));
                }
            }
        }
        size++;
        isAdulterated = true;
    }

    @Override
    public void insert(short index, T t) {

    }

    @Override
    public void remove(short index) {

    }

    @Override
    public void remove(T t) {

    }

    @NotNull
    @Override
    public T first() {
        return null;
    }

    @NotNull
    @Override
    public T last() {
        return null;
    }

    @NotNull
    @Override
    public T size() {
        return null;
    }
}
