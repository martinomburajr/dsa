package composable;

import composable.functions.IMappable;
import generic.IShortLinkedList;

public interface IComposableShortLinkedList<T> extends IShortLinkedList<T> {
    IShortLinkedList<T> map(IMappable<T> map);
}
