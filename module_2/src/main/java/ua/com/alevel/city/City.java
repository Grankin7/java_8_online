package ua.com.alevel.city;

import java.util.HashMap;
import java.util.Map;

public class City {
    String name;
    public Map<City, Integer> neighbors;

    public City(String name) {
        this.name = name;
        this.neighbors = new HashMap<>();
    }

    public void addNeighbor(City neighbor, int cost) {
        neighbors.put(neighbor, cost);
        neighbor.neighbors.put(this, cost);
    }
}
