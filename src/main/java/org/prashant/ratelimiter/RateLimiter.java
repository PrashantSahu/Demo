package org.prashant.ratelimiter;

public class RateLimiter {
    RateLimiterRegistry registry;

    RateLimiter( RateLimiterRegistry registry) {
        this.registry = registry;
    }

    boolean isAllowed(String customerId) {
        if(!registry.isRegistered(customerId)) {
            throw new IllegalArgumentException("customer not registered: "+customerId);
        }

        RateLimitingStrategy strategy = registry.customerStrategies.get(customerId);
        return strategy.isRequestAllowed();
    }
}
