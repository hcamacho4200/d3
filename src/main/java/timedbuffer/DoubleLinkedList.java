package timedbuffer;

public class DoubleLinkedList<T> {

    class Node<T> {
        Node<T> _prev;
        Node<T> _next;
        long _time;
        T _data;
    }

    private Node<T> _top;
    private Node<T> _bot;

    public DoubleLinkedList() {
        _top = null;
        _bot = null;
    }
    
    public void insert(Node<T> node) {
        // Handle Empty List
        if (_top == null && _bot == null) {
            _top = node;
            _bot = node;
            node._prev = null;
            node._next = null;
        }
        // handle normal insert
        else {
            node._prev = _bot;
            node._next = null;
            _bot = node;
        }
    }
}
