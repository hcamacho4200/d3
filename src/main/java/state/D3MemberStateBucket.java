package state;

public class D3MemberStateBucket {
    // the number of secs we are tracking this bucket.
    private int _sec;

    public D3MemberStateBucket(int bucketSize) {
        _sec = bucketSize;
    }

    public void update(long currentSecond, D3MemberRequestState data) {


    }
}
