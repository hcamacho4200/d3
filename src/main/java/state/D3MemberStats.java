package state;

public class D3MemberStats {

    private long _requests;
    private double _avgLatency;
    private double _maxLatency;
    private double _minLatency;
    private double _lastLatency;

    public D3MemberStats() {
        this.resetStats();
    }

    public synchronized void updateStats(double latency) {
        _requests++;
        _lastLatency = latency;
        _avgLatency = ((_avgLatency * (_requests-1)) + latency) / _requests;

        if (latency > _maxLatency) {
            _maxLatency = latency;
        }

        if (latency < _minLatency) {
            _minLatency = latency;
        }
    }

    public synchronized void resetStats() {
        _requests = 0;
        _avgLatency = -1;
        _maxLatency = -1;
        _minLatency = 999999999;
        _lastLatency = 0;
    }

    public String toString() {
        return String.format("%d %f %f %f", _requests, _minLatency, _avgLatency, _maxLatency);
    }
}
