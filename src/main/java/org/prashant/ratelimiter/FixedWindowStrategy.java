package org.prashant.ratelimiter;

public class FixedWindowStrategy implements RateLimitingStrategy{

    public FixedWindowStrategy(int maximumRequests, int windowSizeinSeconds) {

    }

    @Override
    public boolean isRequestAllowed(String customerId) {
        return false;
    }
}
