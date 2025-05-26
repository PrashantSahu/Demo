package org.prashant.ratelimiter;

public class RateLimiterDemo {

    public static void main(String[] args) {
        RateLimiterRegistry registry = new RateLimiterRegistry();

        registry.registerCustomer("a", StrategyType.FIXED_WINDOW, 5, 10);
        registry.registerCustomer("b", StrategyType.SLIDING_WINDOW, 4, 10);

        RateLimiter rateLimiter = new RateLimiter(registry);

    }
}
