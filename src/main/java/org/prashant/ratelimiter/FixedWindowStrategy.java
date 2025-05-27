package org.prashant.ratelimiter;

public class FixedWindowStrategy implements RateLimitingStrategy{
    int maximumRequests;
    int windowSizeInSeconds;
    private long currentWindowKey;
    private int count;

    public FixedWindowStrategy(int maximumRequests, int windowSizeInSeconds) {
        this.maximumRequests = maximumRequests;
        this.windowSizeInSeconds = windowSizeInSeconds;
        this.currentWindowKey = -1;
        this.count = 0;
    }

    @Override
    public synchronized boolean isRequestAllowed() {
        long now = System.currentTimeMillis();
        long windowKey = now/1000;

        if(currentWindowKey != windowKey) {
            currentWindowKey = windowKey;
            count=0;
        }

        if(count>=maximumRequests) {
            return false;
        }
        count++;
        return true;
    }
}
