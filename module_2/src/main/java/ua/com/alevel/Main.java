package ua.com.alevel;

import ua.com.alevel.calculator.Calculator;
import ua.com.alevel.city.City;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {

            int n = Integer.parseInt(br.readLine());
            Map<String, City> cityMap = new HashMap<>();

            // Read cities and their neighbors
            for (int i = 0; i < n; i++) {
                String cityName = br.readLine().trim();
                City city = cityMap.computeIfAbsent(cityName, City::new);

                int p = Integer.parseInt(br.readLine().trim());
                for (int j = 0; j < p; j++) {
                    String[] neighborInfo = br.readLine().split(" ");
                    int nr = Integer.parseInt(neighborInfo[0]) - 1;
                    int cost = Integer.parseInt(neighborInfo[1]);
                    City neighbor = cityMap.computeIfAbsent("NAME" + (nr + 1), City::new);
                    city.addNeighbor(neighbor, cost);
                }
            }

            // Read paths to find
            int r = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < r; i++) {
                String[] pathInfo = br.readLine().split(" ");
                String startCityName = pathInfo[0];
                String endCityName = pathInfo[1];

                City startCity = cityMap.get(startCityName);
                City endCity = cityMap.get(endCityName);

                int minCost = Calculator.findMinCost(startCity, endCity);

                bw.write(minCost + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
