package timedbuffer;

public class TimedDoubleListNode<T> {
    long get_time() {
        return _time;
    }
    T get_data() {
        return _data;
    }

    // linkage pointers, can be altered.
    TimedDoubleListNode<T> _prev;
    TimedDoubleListNode<T> _next;

    // imutable data, once set can never be changed.
    private long _time;
    private T _data;

    public TimedDoubleListNode(long secs, T data, TimedDoubleListNode<T> prev, TimedDoubleListNode<T> next) {
        _prev = prev;
        _next = next;
        _time = secs;
        _data = data;
    }
}
