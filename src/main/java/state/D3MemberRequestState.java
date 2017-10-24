package state;

public class D3MemberRequestState {
    // track the latency of a transaction.  Use 0 if transaction is not completed
    private int _latency;

    // track the state of the request started or completed
    private boolean _completed;

    // track error of the request, only valid if _completed is true
    private int _error;

    // constructor builds an open request which will need to be closed out
    public D3MemberRequestState() {
        _latency = 0;
        _completed = false;
        _error = -1;
    }

    // updates request by closing it out and tracking final latency and error result
    public void updateRequest(int latency, int error) {
        _latency = latency;
        _error = error;
        _completed = true;
    }
}
