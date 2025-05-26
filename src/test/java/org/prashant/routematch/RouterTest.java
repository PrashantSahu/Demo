package org.prashant.routematch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RouterTest {

    private Router router;

    @BeforeEach
    public void setUp() {
        router = new Router();
        router.initialise();

        router.registerRoutes("/users", "listUsers");
        router.registerRoutes("/users/*/type", "listUsersAddressType");
        router.registerRoutes("/users/*/details", "listUsersAddressDetails");
        router.registerRoutes("/users/register", "registerUsers");
        router.registerRoutes("/users/card/details", "listUsersCardDetails");
        router.registerRoutes("/admin/", "listAdmins");
    }

    @Test
    public void testExactMatchRoutes() {
        assertEquals("listUsers", router.getHandler("/users"));
        assertEquals("registerUsers", router.getHandler("/users/register"));
        assertEquals("listUsersCardDetails", router.getHandler("/users/card/details"));
    }

    @Test
    public void testWildcardMatchRoutes() {
        assertEquals("listUsersAddressType", router.getHandler("/users/address/type"));
        assertEquals("listUsersAddressDetails", router.getHandler("/users/address/details"));
    }

    @Test
    public void testTrailingSlashAdmin() {
        assertEquals("listAdmins", router.getHandler("/admin"));
    }

    @Test
    public void testNotFoundRoutes() {
        assertEquals("not found", router.getHandler("/users/address/zipcode"));
        assertEquals("not found", router.getHandler("/admins"));
        assertEquals("not found", router.getHandler("/user"));
        assertEquals("not found", router.getHandler("/users/card"));
    }
}
