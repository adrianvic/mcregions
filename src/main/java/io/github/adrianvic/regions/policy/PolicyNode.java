package io.github.adrianvic.regions.policy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record PolicyNode(String type, List<String> values) {
    public static List<PolicyNode> parseNodes(List<Map<String,Object>> raw) {
        List<PolicyNode> nodes = new ArrayList<>();

        for (Map<String, Object> m : raw) {
            for (Map.Entry<String, Object> entry : m.entrySet()) {

                String type = entry.getKey();
                List<String> values = new ArrayList<>();
                Object val = entry.getValue();
                
                if (val instanceof String s) {
                    values.add((s));
                } else if (val instanceof List<?> l) {
                    for (Object o : l) {
                        if (o instanceof String s) {
                            values.add(s);
                        }
                    }
                }
                nodes.add(new PolicyNode(type, values));
            }
        }
        return nodes;
    }
}