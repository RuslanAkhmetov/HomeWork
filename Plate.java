package lesson7;

public class Plate {
    protected final int capacity;
    private int food;

    public Plate(int capаcity, int food) {
        this.capacity = capаcity;
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void printInfo(){
        System.out.println("В тарелке " + food + " едениц корма.");
    }

    public void increaseFood (int foodAmount){
        if (foodAmount > 0 )
            food = (foodAmount+food <= capacity) ? food += foodAmount: capacity;
    }

    public int decreaseFood(int foodToDecrease){
        if (foodToDecrease > 0) {
            int decreasedFood = foodToDecrease;
            if (foodToDecrease > food) {
                decreasedFood -= food;
                food = 0;
            } else {
                food -= foodToDecrease;
                decreasedFood = foodToDecrease;
            }
            return decreasedFood;
        }
        return 0;
    }
}
