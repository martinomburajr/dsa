package composable;

import composable.functions.IMappable;
import generic.IShortLinkedList;

public class ComposableShortLinkedList<T> implements IComposableShortLinkedList<T> {

    @Override
    public IShortLinkedList<T> map(IMappable<T> map ) {
        return null;
    }

    @Override
    public T root() {
        return null;
    }

    @Override
    public T get(short index) {
        return null;
    }

    @Override
    public T tail() {
          return null;
    }

    @Override
    public void add(T t) {
         map(() -> {return null;});
    }

    @Override
    public void add(short index, T t) {

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

    @Override
    public T first() {
        return null;
    }

    @Override
    public T last() {
        return null;
    }

    @Override
    public T size() {
        return null;
    }
}
