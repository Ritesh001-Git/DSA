import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FoodRatings {
    private Map<String, String> foodToCuisine = new HashMap<>();
    private Map<String, Integer> foodToRating = new HashMap<>();
    private Map<String, TreeSet<String>> cuisineFoods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
        }

        for (int i = 0; i < foods.length; i++) {
            String cuisine = cuisines[i];
            cuisineFoods.putIfAbsent(cuisine, new TreeSet<>((a, b) -> {
                int r1 = foodToRating.get(a);
                int r2 = foodToRating.get(b);
                if (r1 != r2) return r2 - r1; // higher rating first
                return a.compareTo(b); // lex order
            }));
            cuisineFoods.get(cuisine).add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> set = cuisineFoods.get(cuisine);

        set.remove(food);
        foodToRating.put(food, newRating);
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }
    public static void main(String[] args) {
        String[] foods = {"pizza", "pasta", "burger"};
        String[] cuisines = {"italian", "italian", "american"};
        int[] ratings = {8, 9, 7};
        
        FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
        
        System.out.println("Highest rated italian: " + obj.highestRated("italian")); // pasta
        System.out.println("Highest rated american: " + obj.highestRated("american")); // burger
        
        obj.changeRating("pizza", 10);
        System.out.println("After changing pizza rating to 10:");
        System.out.println("Highest rated italian: " + obj.highestRated("italian")); // pizza
    }
    }

