package org.prashant.ratelimiter;

public interface RateLimitingStrategy {
    boolean isRequestAllowed(String customerId);
}
