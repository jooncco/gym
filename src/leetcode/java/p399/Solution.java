package leetcode.java.p399;
// https://leetcode.com/problems/evaluate-division/

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Depth First Search (Binary relation as a graph)
 * | Time: O (n * len(queries) )
 * | Space: O (VE)
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = getGraph(equations, values);
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            ans[i] = getPathWeight(from, to, new HashSet<>(), graph);
        }
        return ans;
    }

    private Map<String, Map<String, Double>> getGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < values.length; ++i) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            graph.computeIfAbsent(x, adj -> new HashMap<>()).put(y, values[i]);
            graph.computeIfAbsent(y, adj -> new HashMap<>()).put(x, 1 / values[i]);
        }
        return graph;
    }

    private double getPathWeight(String from, String to, Set<String> seen, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(from))
            return -1.0;
        if (graph.get(from).containsKey(to))
            return graph.get(from).get(to);

        seen.add(from);
        for (String adjNode : graph.get(from).keySet()) {
            if (!seen.contains(adjNode)) {
                double subPathWeight = getPathWeight(adjNode, to, seen, graph);
                if (subPathWeight != -1.0) {
                    return graph.get(from).get(adjNode) * subPathWeight;
                }
            }
        }
        return -1.0;
    }
}