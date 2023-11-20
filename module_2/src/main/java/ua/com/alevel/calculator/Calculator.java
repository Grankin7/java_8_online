package ua.com.alevel.calculator;

import ua.com.alevel.city.City;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Calculator {
    static final int MAX_COST = 200000;

    public static int findMinCost(City start, City end) {
        Map<City, Integer> costs = new HashMap<>();
        PriorityQueue<City> queue = new PriorityQueue<>((c1, c2) -> costs.get(c1) - costs.get(c2));

        for (City city : start.neighbors.keySet()) {
            costs.put(city, start.neighbors.get(city));
            queue.add(city);
        }

        while (!queue.isEmpty()) {
            City current = queue.poll();

            for (City neighbor : current.neighbors.keySet()) {
                int newCost = costs.get(current) + current.neighbors.get(neighbor);

                if (newCost < costs.getOrDefault(neighbor, MAX_COST)) {
                    costs.put(neighbor, newCost);
                    queue.add(neighbor);
                }
            }
        }

        return costs.getOrDefault(end, -1);
    }
}
