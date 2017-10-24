package timedbuffer;


public class TimedDoubleLinkedList<T> {

    private TimedDoubleListNode<T> _top;
    private TimedDoubleListNode<T> _bot;
    private long _sizeSecs;

    public TimedDoubleLinkedList(long secs) {
        _top = null;
        _bot = null;
        _sizeSecs = secs;
    }

    public void insert(TimedDoubleListNode<T> node) {
        // Handle Empty List
        if (_top == null && _bot == null) {
            _top = node;
            _bot = node;
            node.set_prev(null);
            node.set_next(null);
        }
        // handle normal insert
        else {
            node.set_prev(_bot);
            node.set_next(null);
            _bot = node;
        }
    }

    public TimedDoubleListNode<T> getItems(long cursecs) {
        // check the top to make sure we are in the max secs
        long minsecs = cursecs - _sizeSecs;
        while (true) {
            // handled empty list case
            if (_top == null && _bot == null) {
                return null;
            }

            // check if top is less than minsecs
            if (_top.get_time() < minsecs) {
                // remove node
                _top.set_prev(null);
                _top.get_next().set_prev(null);
                _top = _top.get_next();
            }
            // handle if we catch up to the present
            else {
                return _top;

            }
        }
    }
}
