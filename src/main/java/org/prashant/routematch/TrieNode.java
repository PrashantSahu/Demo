package org.prashant.routematch;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    Map<String, TrieNode> children = new HashMap<>();
    String handler = null;

}
