package state;

import timedbuffer.TimedDoubleLinkedList;

public class D3MemberState {
    // service defines itself as totally healthy
    public static int D3_STATE_HEALTHY          = 0;

    // service marks itself degraded, however the client may attempt a transaction
    public static int D3_STATE_DEGRADE          = 1;

    // services marks draining, it is closing out existing connections and will refuse new connections
    public static int D3_STATE_DRAINING         = 2;

    // service is marked administratively disabled, and will refuse connections, but will process existing requests/connections
    public static int D3_STATE_ADMIN_DISABLE    = 3;

    // used to track a unique value for synchronization at the client
    // a client can ignore a lessor value than already processed to avoid the out of order datagram delivery
    private long _id = 0;

    // state defining the servers perspective regarding health.
    private int _state;

    // calculated field based on the tracking buckets, the max size needed to track
    private int _max_bucket_size;

    // the last latench measured at the service
    private int _last_latency;

    // a strcuture to hold ALL the samples with window adjusting to the max secs
    private TimedDoubleLinkedList<D3MemberRequestState> _tdll;

    public D3MemberState(int[] buckets) {
        _state = D3MemberState.D3_STATE_HEALTHY;

        // find the largest bucket size, that will be the size of the Timed Linked List
        _max_bucket_size = -1;
        for (int x=0; x<buckets.length; x++) {
            if (buckets[x] > _max_bucket_size) {
                _max_bucket_size = buckets[x];
            }
        }

        // allocate tdll that will hold all windows in one structure
        _tdll = new TimedDoubleLinkedList<D3MemberRequestState>(_max_bucket_size);

        // allocate the various buckets

    }

    public void setState(boolean state) {
        _state = state;
    }
    public void incrementId() {
        _id++;
    }

    // start a transaction

    // end transaction



}
