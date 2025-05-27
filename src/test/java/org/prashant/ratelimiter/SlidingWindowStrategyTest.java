package org.prashant.ratelimiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowStrategyTest {

    FixedWindowStrategy limiter;

    @BeforeEach
    void setup() {
        limiter = new FixedWindowStrategy(4,2);
    }

    @Test
    void totalRequestsUnderLimit_AreAllowed() {
        for (int i = 0; i < 4; i++) {
            assertTrue(limiter.isRequestAllowed(), "Request #" + (i + 1) + " should be allowed");
        }
    }

    @Test
    void totalRequestsAboveLimit_beBlocked() {
        for (int i = 0; i < 4; i++) {
            assertTrue(limiter.isRequestAllowed(), "Request #" + (i + 1) + " should be allowed");
        }

        assertFalse(limiter.isRequestAllowed());
    }

    @Test
    void testWindowReset_allowAfterWait() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            assertTrue(limiter.isRequestAllowed(), "Request #" + (i + 1) + " should be allowed");
        }

        Thread.sleep(2000);

        assertTrue(limiter.isRequestAllowed());
    }

}