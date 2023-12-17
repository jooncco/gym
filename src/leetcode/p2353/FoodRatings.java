package leetcode.p2353;
// https://leetcode.com/problems/design-a-food-rating-system/

import java.util.*;

/**
 * Sortings
 * | Time: O(n log(n) + q log(n))
 * | Space: O(n)
 */
public class FoodRatings {
    private Map<String, PriorityQueue<Food>> cuisineMap = new HashMap<>();
    private Map<String, Food> foodMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; ++i) { // O(n log(n))
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            cuisineMap.computeIfAbsent(cuisines[i], x -> new PriorityQueue<Food>(
                    (a, b) -> a.rating == b.rating
                            ? a.name.compareTo(b.name)
                            : Integer.compare(b.rating, a.rating)))
                    .add(food); // O(log(n))
            foodMap.put(foods[i], food);
        }
    }

    public void changeRating(String food, int newRating) {
        PriorityQueue<Food> pq = cuisineMap.get(foodMap.get(food).cuisine);
        pq.remove(foodMap.get(food)); // O(log(n))
        foodMap.get(food).setRating(newRating);
        pq.add(foodMap.get(food)); // O(log(n))
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).peek().name;
    }

    static class Food {
        private String name;
        private String cuisine;
        private int rating;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        public void setRating(int newRating) {
            this.rating = newRating;
        }
    }
}