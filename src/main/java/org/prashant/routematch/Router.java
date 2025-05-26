package org.prashant.routematch;

public class Router {

    static String NOT_FOUND = "not found";

    TrieNode root;

    public void initialise() {
        root = new TrieNode();
    }

    public void registerRoutes(String route, String handler) {
        String[] parts = route.split("/");
        TrieNode node = root;
        for(int i=0; i<parts.length; i++) {
            node.children.putIfAbsent(parts[i], new TrieNode());
            node = node.children.get(parts[i]);
        }
        node.handler = handler;
    }


    public String getHandler(String route) {
        String[] parts = route.split("/",0);

        TrieNode node = root;

        for(int i=0; i<parts.length; i++) {
            if(node.children.get(parts[i]) !=null) {
                node = node.children.get(parts[i]);
            } else {
                if(node.children.containsKey("*")) {
                    node = node.children.get("*");
                } else {
                    return NOT_FOUND;
                }
            }

//            node = node.children.get(parts[i]);
//            if(node==null) return NOT_FOUND;
        }
        return node.handler!=null ? node.handler : NOT_FOUND;
    }
}
