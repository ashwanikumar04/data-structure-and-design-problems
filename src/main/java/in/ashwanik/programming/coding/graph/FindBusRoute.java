package in.ashwanik.programming.coding.graph;

import java.io.BufferedInputStream;
import java.util.*;

public class FindBusRoute {
    private Map<String, Integer> map;
    private int stations;
    private UnionFind unionFind;

    public FindBusRoute() {
        map = new HashMap<>();
    }

    public boolean isRouteExist(String stationA, String stationB) {
        Integer p = map.get(stationA);
        Integer q = map.get(stationB);
        if (p == null || q == null) {
            return false;
        }
        return unionFind.isConnected(p, q);
    }

    public void preprocess(List<String> routes) {
        processRoutes(routes);
        unionFind = new UnionFind(stations);
        mapRoutes(routes);
    }

    private void processRoutes(List<String> routes) {
        for (String route : routes) {
            if (route.length() > 0) {
                String[] stationsOnRoute = route.split(" ");
                for (String station : stationsOnRoute) {
                    if (!map.containsKey(station)) {
                        map.put(station, stations);
                        stations++;
                    }
                }
            }
        }
    }

    private void mapRoutes(List<String> routes) {
        for (String route : routes) {
            if (route.length() > 0) {
                String[] stationsOnRoute = route.split(" ");
                if (stationsOnRoute.length > 1) {
                    for (int index = 1; index < stationsOnRoute.length; index++) {
                        int p = map.get(stationsOnRoute[index - 1]);
                        int q = map.get(stationsOnRoute[index]);
                        unionFind.connect(p, q);
                    }
                }
            }
        }
    }

    /*
  1 153 150 148 106 17 20 160 140 24
  2 5 142 106 11
  19 153 121 114 150 5
  13 153 148 169 106 11 12
  14 114 150 142 12 179 174 17
  6 5 138 148 12 174 118 16 19 184
  7 121 114 150 5 148 169 11
  8 142 138 148 169 106 11 12
  18 153 114 5 138
  11 121 114 148 169 12 16 155
   */
    public static void main(String[] args) {
        FindBusRoute findBusRoute = new FindBusRoute();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        List<String> routes = new ArrayList<>();

        while (stdin.hasNextLine()) {
            String current = stdin.nextLine();
            if (current != null && current.length() > 0) {
                String[] stations = current.split(" ");
                stations = Arrays.copyOfRange(stations, 1, stations.length);
                current = String.join(" ", stations);
                routes.add(current);
            } else {
                break;
            }
        }
        stdin.close();
        findBusRoute.preprocess(routes);
        System.out.println("Path Between: " + findBusRoute.isRouteExist("153", "121"));

    }
}
