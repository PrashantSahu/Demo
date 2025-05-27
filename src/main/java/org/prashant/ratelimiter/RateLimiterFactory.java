package org.prashant.ratelimiter;

public class RateLimiterFactory {
    public static RateLimitingStrategy createStrategy(StrategyType type, int maxRequests, int windowSizeInSeconds) {
       return switch(type) {
            case FIXED_WINDOW -> new FixedWindowStrategy(maxRequests, windowSizeInSeconds);
           case SLIDING_WINDOW -> new SlidingWindowStrategy(maxRequests, windowSizeInSeconds);
        };
    }
}
