package org.prashant.ratelimiter;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowStrategy implements RateLimitingStrategy{

    int maximumRequests;
    int windowSizeInSeconds;
    Deque<Long> timestamps;

    public SlidingWindowStrategy(int maximumRequests, int windowSizeInSeconds) {
        this.maximumRequests = maximumRequests;
        this.windowSizeInSeconds = windowSizeInSeconds;
        timestamps = new ArrayDeque<>();
    }

    @Override
    public boolean isRequestAllowed(String customerId) {
        Long now = System.currentTimeMillis();
        Long windowStart = now - windowSizeInSeconds*1000L;

        while(!timestamps.isEmpty() && timestamps.peekFirst()<windowStart) {
            timestamps.pollFirst();
        }
        if(timestamps.size() < maximumRequests) {
            timestamps.addLast(now);
            return true;
        }
        return false;
    }
}
