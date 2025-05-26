package org.prashant.routematch;

public class RouteMatch {

    public static void main(String[] args) {

        Router router = new Router();
        router.initialise();


        router.registerRoutes("/users", "listUsers");
        router.registerRoutes("/users/*/type", "listUsersAddressType");
        router.registerRoutes("/users/*/details", "listUsersAddressDetails");
        router.registerRoutes("/users/register", "registerUsers");
        router.registerRoutes("/users/card/details", "listUsersCardDetails");

        router.registerRoutes("/admin/", "listAdmins");

        System.out.println(router.getHandler("/users"));
        System.out.println(router.getHandler("/users/register"));
        System.out.println(router.getHandler("/admin"));
        System.out.println(router.getHandler("/users/address/type"));
        System.out.println(router.getHandler("/users/address/details"));
        System.out.println(router.getHandler("/users/card/details"));

    }
}
