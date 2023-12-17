class FoodRatings {
    
    
    Map<String, PriorityQueue<Food>> pqMap = new HashMap<>();
    Map<String, Food> map = new HashMap<>();
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i=0; i<n; i++){
            Food curr = new Food(ratings[i], foods[i], cuisines[i]);
            if(pqMap.containsKey(cuisines[i]))
                pqMap.get(cuisines[i]).offer(curr);
            else{
                PriorityQueue<Food> pq = new PriorityQueue<>();
                pq.offer(curr);
                pqMap.put(cuisines[i], pq);
            }
            
            map.put(foods[i], curr);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food curr = map.get(food);
        pqMap.get(curr.cuisine).remove(curr);
        
        Food newCurr = new Food(newRating, food, curr.cuisine);
        pqMap.get(curr.cuisine).offer(newCurr);
        map.put(food, newCurr); // dont forget this line
    }
    
    public String highestRated(String cuisine) {
        return pqMap.get(cuisine).peek().name;
    }
}

class Food implements Comparable<Food>{
    int rating;
    String name;
    String cuisine;
    
    public Food(int r, String n, String c){
        rating = r;
        name = n;
        cuisine = c;
    }
    
    @Override
    public int compareTo(Food other){
        return this.rating == other.rating ? this.name.compareTo(other.name) :
        Integer.compare(other.rating, this.rating);
    }
}





/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */