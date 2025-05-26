package org.prashant.ratelimiter;

public class SlidingWindowStrategy implements RateLimitingStrategy{
    @Override
    public boolean isRequestAllowed(String customerId) {
        return false;
    }
}
