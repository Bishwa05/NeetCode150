package graph;

import java.util.*;

/**
 * You are given a list of flight tickets tickets where tickets[i] = [from_i, to_i] represent the source airport and the destination airport.
 *
 * Each from_i and to_i consists of three uppercase English letters.
 *
 * Reconstruct the itinerary in order and return it.
 *
 * All of the tickets belong to someone who originally departed from "JFK". Your objective is to reconstruct the flight path that this person took, assuming each ticket was used exactly once.
 *
 * If there are multiple valid flight paths, return the lexicographically smallest one.
 *
 * For example, the itinerary ["JFK", "SEA"] has a smaller lexical order than ["JFK", "SFO"].
 * You may assume all the tickets form at least one valid flight path.
 *
 */
public class ReconstructFlightPath {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String>ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        dfs(graph, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph,
                     String src, List<String> res) {
        PriorityQueue<String> queue = graph.get(src);
        while (queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(graph, dst, res);
        }
        res.add(src);
    }

    public static void main(String[] args) {
        List<List<String>>tickets = List.of(
                List.of("HOU","JFK"),
                List.of("SEA","JFK"),
                List.of("JFK","SEA"),
                List.of("JFK","HOU"));

        // [["HOU","JFK"],["SEA","JFK"],["SEA","JFK"],["JFK","HOU"]]
        ReconstructFlightPath r = new ReconstructFlightPath();
        r.findItinerary(tickets).forEach(e-> System.out.println(e));
    }


}
