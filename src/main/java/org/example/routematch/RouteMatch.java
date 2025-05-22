package org.example.routematch;

public class RouteMatch {

    public static void main(String[] args) {

        Router router = new Router();
        router.initialise();


        router.registerRoutes("/users", "listUsers");
        router.registerRoutes("/users/register", "registerUsers");

        router.registerRoutes("/admin/", "listAdmins");

        System.out.println(router.getHandler("/users"));
        System.out.println(router.getHandler("/users/register"));
        System.out.println(router.getHandler("/admin"));

    }
}
