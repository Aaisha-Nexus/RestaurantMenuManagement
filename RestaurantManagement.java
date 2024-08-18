import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("******** THIS IS A RESTAURANT MANAGEMENT SYSTEM ********");

        DishCollection dishInfo = new DishCollection(); //instance creation(object)

        Dish dish1 = new Dish("Fettucine", 8.00, 4);
        Dish dish2 = new Dish("Fried Pasta", 7.50, 3);
        Dish dish3 = new Dish("Spaghetti Bolognaise", 6.50, 4);
        Dish dish4 = new Dish("Cheesy Lasagna", 8.50, 5);
        Dish dish5 = new Dish("Margherita Pizza", 9.50, 5);

        // Adding dishes to collection
        dishInfo.addDish(dish1);
        dishInfo.addDish(dish2);
        dishInfo.addDish(dish3);
        dishInfo.addDish(dish4);
        dishInfo.addDish(dish5);

        int option;
        do {
            System.out.println("CHOOSE ANY OPTION FROM BELOW");
            System.out.println(
                    "1) Add a Dish\n" +
                            "2) Remove a Dish\n" +
                            "3) Display All Dishes\n" +
                            "4) Display Dishes by Price\n" +
                            "5) Display Dishes by Ratings\n" +
                            "6) Search Dish by Name\n" +
                            "7) Update Dish Details\n" +
                            "8) Exit");

            option = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.println("Enter the dish name:");
                    String dishName = sc.nextLine();
                    System.out.println("Enter the price:");
                    double price = sc.nextDouble();
                    System.out.println("Enter the rating:");
                    int rating = sc.nextInt();

                    Dish newDish = new Dish(dishName, price, rating);
                    dishInfo.addDish(newDish);
                    break;
                case 2:
                    System.out.println("Enter the dish to remove:");
                    String removeDish = sc.nextLine();
                    dishInfo.removeDish(removeDish);
                    break;
                case 3:
                    dishInfo.displayDish();
                    break;
                case 4:
                    System.out.println("Enter your desired price:");
                    double priceFilter = sc.nextDouble();
                    dishInfo.displayDishByPrice(priceFilter);
                    break;
                case 5:
                    System.out.println("Enter your desired rating between 1-5:");
                    int ratingFilter = sc.nextInt();
                    dishInfo.displayDishByRatings(ratingFilter);
                    break;
                case 6:
                    System.out.println("Enter the dish name to search:");
                    String searchName = sc.nextLine();
                    dishInfo.searchDishByName(searchName);
                    break;
                case 7:
                    System.out.println("Enter the dish name to update:");
                    String updateName = sc.nextLine();
                    System.out.println("Enter the new price:");
                    double newPrice = sc.nextDouble();
                    System.out.println("Enter the new rating:");
                    int newRating = sc.nextInt();
                    dishInfo.updateDish(updateName, newPrice, newRating); //updating dish by setters
                    break;
                case 8:
                    System.out.println("The program exits!");
                    break;
                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
        } while (option != 8);
    }
}

class Dish {
    // Instance variables
    private String dishName;
    private double price;
    private int rating;

    // Constructor chaining using 2 arguments and default rating 3
    public Dish(String dishName, double price) {
        this(dishName, price, 3); // Default rating 3 if not provided
    }

    //constructor with all parameters
    public Dish(String dishName, double price, int rating) {
        this.dishName = dishName;
        this.price = price;
        this.rating = rating;
    }

    // Public getter methods
    public String getDishName() {
        return dishName;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    // Public setter methods
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Dish Name: " + dishName + ", Price: $" + price + ", Rating: " + rating + " stars";
    }
}

// Collection of dishes class
class DishCollection {
    private ArrayList<Dish> dishes; //declaring arraylist

    // Constructor to initialize an empty ArrayList
    public DishCollection() {
        dishes = new ArrayList<>();
    }

    // Method to add a dish
    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    // Method to remove a dish
    public void removeDish(String dishName) {
        dishes.removeIf(dish -> dish.getDishName().equalsIgnoreCase(dishName));
    }

    // Method to display all dishes
    public void displayDish() {
        for (Dish dish : dishes) {
            System.out.println(dish);  // Calls the toString method implicitly
        }
    }

    // Method to display dishes according to price
    public void displayDishByPrice(double price) {
        for (Dish dish : dishes) {
            if (dish.getPrice() == price) { //if user input and defined price matches then display that dish details
                System.out.println(dish);  // Calls the toString method
            }
        }
    }

    // Method to display dishes according to ratings
    public void displayDishByRatings(int rating) {
        for (Dish dish : dishes) {
            if (dish.getRating() == rating) {
                System.out.println(dish);  // Calls the toString method
            }
        }
    }

    // Method to search for a dish by name
    public void searchDishByName(String dishName) {
        for (Dish dish : dishes) {
            if (dish.getDishName().equalsIgnoreCase(dishName)) {
                System.out.println(dish);  // Calls the toString method
                return;
            }
        }
        System.out.println("Dish not found!");
    }

    // Method to update (dish price and rate) using setter
    public void updateDish(String dishName, double newPrice, int newRating) {
        for (Dish dish : dishes) {
            if (dish.getDishName().equalsIgnoreCase(dishName))
            {
                dish.setPrice(newPrice);
                dish.setRating(newRating);
                System.out.println("Dish updated: " + dish);  // Calls the toString method
                return;
            }
        }
        System.out.println("Dish not found!");
    }
}
