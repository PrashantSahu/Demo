package org.prashant.ratelimiter;

public class FixedWindowStrategy implements RateLimitingStrategy{
    @Override
    public boolean isRequestAllowed(String customerId) {
        return false;
    }
}
