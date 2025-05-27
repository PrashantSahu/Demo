package org.prashant.ratelimiter;

public class RateLimiterDemo {

    public static void main(String[] args) {
        RateLimiterRegistry registry = new RateLimiterRegistry();

        String ALICE = "alice";
        String BOB = "bob";

        registry.registerCustomer(ALICE, StrategyType.FIXED_WINDOW, 5, 10);
        registry.registerCustomer(BOB, StrategyType.SLIDING_WINDOW, 4, 10);

        RateLimiter rateLimiter = new RateLimiter(registry);

        rateLimiter.isAllowed(ALICE);
        rateLimiter.isAllowed(ALICE);
        rateLimiter.isAllowed(ALICE);
        rateLimiter.isAllowed(ALICE);
        rateLimiter.isAllowed(ALICE);

        rateLimiter.isAllowed(BOB);
        rateLimiter.isAllowed(BOB);
        rateLimiter.isAllowed(BOB);
        rateLimiter.isAllowed(BOB);
        rateLimiter.isAllowed(BOB);
    }
}
