package AmazonNG;
import java.util.*;

class NearistCity {

     static class City{
        int x;
        int y;
        String name;
        public City(String name, int x, int y){
            this.x = x;
            this.y = y;
            this.name = name;
        }
    }

    public static String[] findNearestCities(int numOfCities, String[] cities, int[] xs, int[] ys, int numOfQueries, String[] queries){
        // WRITE YOUR BRILLIANT CODE HERE

        HashMap<Integer, TreeSet<City>> xmap = new HashMap<>(), ymap = new HashMap<>();
        HashMap<String, City> citymap = new HashMap<>();

        for (int i = 0; i< cities.length; i++){
            xmap.putIfAbsent(xs[i], new TreeSet<>((a,b) -> a.y == b.y ? a.name.compareTo(b.name) : b.y - a.y));
            xmap.get(xs[i]).add(new City(cities[i], xs[i], ys[i]));

            ymap.putIfAbsent(ys[i], new TreeSet<>((a,b) -> a.x == b.x ? a.name.compareTo(b.name) : b.x - a.x));
            ymap.get(ys[i]).add(new City(cities[i], xs[i], ys[i]));

            citymap.put(cities[i], new City(cities[i], xs[i], ys[i]));
        }

        String[] res = new String[numOfQueries];

        for (int i=0; i<queries.length; i++){
            String name = queries[i];
            TreeSet<City> cityX = xmap.get(citymap.get(name).x);
            TreeSet<City> cityY = ymap.get(citymap.get(name).y);

            City m = cityX.lower(citymap.get(name));
            while (m !=null && cityX.lower(m) != null && cityX.lower(m).y == m.y) {
                m = cityX.lower(m);
            }
            City x1 = m;
            City x2 = cityX.higher(citymap.get(name));

            City n = cityY.lower(citymap.get(name));
            while (n!=null && cityY.lower(n)!=null && cityY.lower(n).x == n.x) {
                n = cityY.lower(n);
            }

            City y1 = n;
            City y2 = cityY.higher(citymap.get(name));

            res[i] = getdist(citymap.get(name), new City[] {x1,x2,y1, y2});
        }
        return res;
    }

    private static String getdist(City m, City[] city){
        int minDist = Integer.MAX_VALUE;
        String res = "";
        for (City c : city){
            if (c == null) continue;
            if (c.name.equals(m.name)) continue;
            int newDist = Math.abs(m.x-c.x) + Math.abs(m.y-c.y);
            if ( newDist < minDist || (newDist == minDist && !res.equals("") && res.compareTo(c.name)>0)){
                minDist = newDist;
                res = c.name;
            }
        }
        if (minDist  == Integer.MAX_VALUE) {
            return "NONE"; // 注意:对于不符合的点的要求，看题意，返回null 或者 string的"null" 或者 String的"NONE"
        }
        return res ;
    }
}