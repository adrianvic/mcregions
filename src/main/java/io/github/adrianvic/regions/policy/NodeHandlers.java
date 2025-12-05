package io.github.adrianvic.regions.policy;

import io.github.adrianvic.regions.policy.handlers.attackWith;

import java.util.HashMap;
import java.util.Map;

public class NodeHandlers {
    private static final Map<String, NodeHandler> handlers = new HashMap<>();
    
    static {
        handlers.put("attackWithItemInHand", new attackWith());
    }
    
    public static NodeHandler get(String type) {
        return handlers.get(type);
    }
}
