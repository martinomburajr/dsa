package generic;

import com.sun.istack.internal.NotNull;

public class ShortLinkedList<T> implements IShortLinkedList<T> {
    private Node<T> root;
    private Node<T> tail;
    private short size;
    private boolean isAdulterated = false;

    public ShortLinkedList() {
        root = null;
        tail = null;
        size = 0;
    }

    public short getSize() {
        return size;
    }

    @Override
    public T get(short index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException(ShortLinkedListExceptions.EXP_INDEX_NEGATIVE);
        }
        if(index >= size) {
            throw new IndexOutOfBoundsException(ShortLinkedListExceptions.EXP_INDEX_LARGE);
        }
        else{
            if(index == 0) {
                return root.getValue();
            }else{
                Node<T> base = root;
                for (int i = 0; i <= index; i++) {
                    if(i == index){
                        return base.getValue();
                    }
                    base = base.getNext();
                }
            }
            return null;
        }
    }

    @Override
    public void add(T t) {
        if(root == null) {
            root = new Node<>(t, null);
            tail = root;
        }else {
            Node base = root;
            for (int i = 0; i < size; i++) {
                if (i == (size - 1)) {
                    base.setNext(new Node<T>(t, null));
                    tail = base.getNext();
                    break;
                }
                base = base.getNext();
            }

        }
        size++;
        isAdulterated = true;
    }

    /**
     * Inserts at ahead of the specified index. if array = [1,2,3,4,5] and insertionIndex= 3 with value ,42, finalArray = [1,2,3,4,42,5]
     * @param index
     * @param t
     */
    @Override
    public void add(short index, T t) {
        if(index >= size) {
            throw new IndexOutOfBoundsException(ShortLinkedListExceptions.EXP_INDEX_LARGE);
        }else if(index < 0) {
            throw new IndexOutOfBoundsException(ShortLinkedListExceptions.EXP_INDEX_NEGATIVE);
        }

        Node<T> insertedItem = new Node<>(t, null);
        Node prev;
        Node next;
        //insert at 0;
        if(index == 0) {
            next = root;
            insertedItem.setNext(next);
            root = insertedItem;
        }
        if(index == 1) {
            prev = root.getNext();
            root.setNext(insertedItem);
            insertedItem.setNext(prev);
        }
        else{
            Node iteratorNode = root;
            //insert elsewhere
            for (int i = 0; i < index; i++) {
                iteratorNode = iteratorNode.getNext();
                if(i == (index-2)) {
                    prev = iteratorNode;
                    next = iteratorNode.getNext();
                    prev.setNext(insertedItem);
                    insertedItem.setNext(next);
                    break;
                }
            }
        }
        size++;
    }

    //Root is always the item at index 0. It doesn't point to the item at index 0, it is the item at index 0;

    /**
     * Inserts an item at the specified index. Given an array [1,2,3,4,5,6] an a request to insert item 19 at index 2. The new array
     * will become [1,2,19,3,4,5,6]. This is different than the @add(index, item) as it always adds to the index ahead of what you specified.
     * E.g. Given the same array and an add(2,19) request. The new array will be [1,2,3,19,4,5,6].
     * @param index
     * @param t
     */
    @Override
    public void insert(short index, T t) {
        if(index >= size) {
            throw new IndexOutOfBoundsException(ShortLinkedListExceptions.EXP_INDEX_LARGE);
        }else if(index < 0) {
            throw new IndexOutOfBoundsException(ShortLinkedListExceptions.EXP_INDEX_NEGATIVE);
        }

        Node prev;
        Node next;
        Node iterator;
        Node<T> insertedItem = new Node<>(t, null);

        if(index == 0) {
            Node savedRef = root;
            root = insertedItem;
            root.setNext(savedRef);
        }else if(index == 1) {
            prev = root.getNext();
            root.setNext(insertedItem);
            insertedItem.setNext(prev);
        }
        else {
            iterator = root;
            for (int i = 0; i < index; i++) {
                if(i == (index - 1)) {
                    prev = iterator;
                    next = iterator.getNext();
                    prev.setNext(insertedItem);
                    insertedItem.setNext(next);
                    break;
                }
                iterator = iterator.getNext();
            }
        }
        size++;
    }

    @Override
    public void remove(short index) {

    }

    @Override
    public void remove(T t) {

    }

    public String printn() {
        String s = "";
        Node n = root;
        for (int i = 0; i < size; i++) {
            s = s + n.getValue().toString() + "\n";
            n = n.getNext();
        }
        return s;
    }

    @NotNull
    @Override
    public T first() {
        return root.getValue();
    }

    @NotNull
    @Override
    public T last() {
        return tail.getValue();
    }

    @NotNull
    @Override
    public short size() {
        return this.size;
    }
}
