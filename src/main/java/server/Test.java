package server;

import state.D3MemberState;
import java.util.Date;
import java.util.Random;

public class Test {
    public Test() {
        int buckets[] = {60, 120, 300};
        D3MemberState test = new D3MemberState(buckets);

        Random rand = new Random();

        int  n;
        try {

            for (int x=0; x<10000; x++) {
                Thread.sleep(rand.nextInt(100) + 1);
                test.updateStats(new Date().getTime() / 1000, rand.nextInt(5000) + 1);

                if (x % 100 == 0) {
                    System.out.println(x);
                    test.outputStats();
                }
            }
        }
        catch (Exception e) {

        }



    }
}
