package state;

public class D3MemberState {
    private long _id = 0;
    private boolean _state;
    private D3MemberBucket[] _buckets;

    public D3MemberState(int[] buckets) {
        _state = false;
        _buckets = new D3MemberBucket[buckets.length];

        for (int x=0; x<buckets.length; x++) {
            _buckets[x] = new D3MemberBucket(buckets[x]);
        }
    }

    public void setState(boolean state) {
        _state = state;
    }

    public void incrementId() {
        _id++;
    }

    public void updateStats(long secs, long latency) {
        for (int x=0; x<_buckets.length; x++) {
            _buckets[x].updateBucketRequests(secs, latency);
        }
    }

    public void outputStats() {
        for (int x=0; x<_buckets.length; x++) {
            System.out.printf("%s\n", _buckets[x]);
        }
    }
}
