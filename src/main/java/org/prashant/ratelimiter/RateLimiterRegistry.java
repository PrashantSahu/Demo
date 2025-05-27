package org.prashant.ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterRegistry {
    Map<String, RateLimitingStrategy> customerStrategies = new HashMap<>();

    public void registerCustomer(String name, StrategyType type, int maxRequests, int windowSizeInSeconds) {

        customerStrategies.put(name, RateLimiterFactory.createStrategy(type, maxRequests, windowSizeInSeconds));

    }

    public boolean isRegistered(String customerId) {
        return customerStrategies.containsKey(customerId);
    }
}
