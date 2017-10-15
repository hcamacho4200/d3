package state;

public class D3MemberBucket {

    private int _bucketSize;
    private long _currentBucket;
    private long _bucketSecs = -1;
    private D3MemberStats _stats;

    public D3MemberBucket(int bucketSize) {
        _bucketSize = bucketSize;
        _currentBucket = -1;
        _stats = new D3MemberStats();
    }

    public synchronized void updateBucketRequests(long secs, long latency) {
        // check bucket to make sure we are in the right bucket
        this.checkBucket(secs);

        // update the stats, last latency
        _stats.updateStats(latency);

    }

    private void checkBucket(long secs) {
        //System.out.println(secs + " " + secs / _bucketSize);
        if (secs / _bucketSize != _currentBucket) {
            _currentBucket = secs / _bucketSize;
            resetStats();
            System.out.printf("bucket %d restet\n", _bucketSize);
        }
    }

    private void resetStats() {
        this._stats.resetStats();
    }

    public String toString() {
        return String.format("%d %s", _bucketSize, _stats);
    }
}
