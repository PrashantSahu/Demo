package org.prashant.ratelimiter;

public class RateLimiterDemo {

    public static void main(String[] args) {
        RateLimiterRegistry registry = new RateLimiterRegistry();

        String ALICE = "alice";
        String BOB = "bob";

        registry.registerCustomer(ALICE, StrategyType.FIXED_WINDOW, 5, 10);
        registry.registerCustomer(BOB, StrategyType.SLIDING_WINDOW, 4, 10);

        RateLimiter rateLimiter = new RateLimiter(registry);

        System.out.println(rateLimiter.isAllowed(ALICE));
        System.out.println(rateLimiter.isAllowed(ALICE));
        System.out.println(rateLimiter.isAllowed(ALICE));
        System.out.println(rateLimiter.isAllowed(ALICE));
        System.out.println(rateLimiter.isAllowed(ALICE));


        System.out.println(rateLimiter.isAllowed(BOB));
        System.out.println(rateLimiter.isAllowed(BOB));
        System.out.println(rateLimiter.isAllowed(BOB));
        System.out.println(rateLimiter.isAllowed(BOB));
        System.out.println(rateLimiter.isAllowed(BOB));
    }
}
