import java.util.*;
public class MovieRentingSystem {
    // Price lookup: (shop, movie) -> price
    private Map<List<Integer>, Integer> priceMap = new HashMap<>();

    // For each movie -> available copies sorted by (price, shop)
    private Map<Integer, TreeSet<int[]>> available = new HashMap<>();

    // All rented movies sorted by (price, shop, movie)
    final private TreeSet<int[]> rented = new TreeSet<>((a, b) -> {
        if (a[2] != b[2]) return a[2] - b[2];   // by price
        if (a[0] != b[0]) return a[0] - b[0];   // by shop
        return a[1] - b[1];                     // by movie
    });
    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(Arrays.asList(shop, movie), price);
            available.computeIfAbsent(movie, _ -> new TreeSet<>((x, y) -> {
                if (x[2] != y[2]) return x[2] - y[2];   // price
                return x[0] - y[0];                     // shop
            })).add(new int[]{shop, movie, price});
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        Iterator<int[]> it = available.get(movie).iterator();
        while (it.hasNext() && res.size() < 5) {
            res.add(it.next()[0]);
        }
        return res;
    }
    
    public void rent(int shop, int movie) {
        int price = priceMap.get(Arrays.asList(shop, movie));
        int[] entry = new int[]{shop, movie, price};
        available.get(movie).remove(entry);
        rented.add(entry);
    }
    
    public void drop(int shop, int movie) {
        int price = priceMap.get(Arrays.asList(shop, movie));
        int[] entry = new int[]{shop, movie, price};
        rented.remove(entry);
        available.get(movie).add(entry);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        Iterator<int[]> it = rented.iterator();
        while (it.hasNext() && res.size() < 5) {
            int[] e = it.next();
            res.add(Arrays.asList(e[0], e[1]));
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] entries = {{0,1,5},{0,2,6},{0,3,7},{1,1,4},{1,2,7},{2,1,5}};
        MovieRentingSystem mrs = new MovieRentingSystem(n, entries);
        System.out.println(mrs.search(1)); // [1,0,2]
        mrs.rent(1,1);
        System.out.println(mrs.report()); // [[1,1]]
        mrs.drop(1,1);
        System.out.println(mrs.report()); // []
        mrs.rent(0,2);
        mrs.rent(2,1);
        System.out.println(mrs.report()); // [[2,1],[0,2]]
    }
}
