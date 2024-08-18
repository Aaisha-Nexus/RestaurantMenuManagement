# Restaurant Menu Management 

This is a simple Java-based program that manages a collection of dishes in a restaurant. The program allows users to add, remove, display, search, and update dish details like price and rating.

## Features

- **Add a Dish:** Add a new dish to the collection with a name, price, and rating.
- **Remove a Dish:** Remove a dish from the collection by its name.
- **Display All Dishes:** Show all dishes in the collection with their details.
- **Display Dishes by Price:** Filter and display dishes based on a specified price.
- **Display Dishes by Ratings:** Filter and display dishes based on a specified rating.
- **Search Dish by Name:** Search for a dish by its name and display its details.
- **Update Dish Details:** Update the price and rating of an existing dish.

## Classes and Methods

### `Dish`

#### Instance Variables:
- `String dishName`: Name of the dish.
- `double price`: Price of the dish.
- `int rating`: Rating of the dish (out of 5).

#### Constructors:
- `Dish(String dishName, double price)`: Creates a dish with a specified name and price, with a default rating of 3.
- `Dish(String dishName, double price, int rating)`: Creates a dish with the specified name, price, and rating.

#### Methods:
- `String getDishName()`: Returns the name of the dish.
- `double getPrice()`: Returns the price of the dish.
- `int getRating()`: Returns the rating of the dish.
- `void setDishName(String dishName)`: Updates the name of the dish.
- `void setPrice(double price)`: Updates the price of the dish.
- `void setRating(int rating)`: Updates the rating of the dish.
- `String toString()`: Returns a string representation of the dish, including its name, price, and rating.

### `DishCollection`

#### Instance Variables:
- `ArrayList<Dish> dishes`: A collection that holds multiple `Dish` objects.

#### Constructors:
- `DishCollection()`: Initializes an empty collection of dishes.

#### Methods:
- `void addDish(Dish dish)`: Adds a new dish to the collection.
- `void removeDish(String dishName)`: Removes a dish from the collection based on its name.
- `void displayDish()`: Displays all dishes currently in the collection.
- `void displayDishByPrice(double price)`: Displays all dishes that match the specified price.
- `void displayDishByRatings(int rating)`: Displays all dishes that match the specified rating.
- `void searchDishByName(String dishName)`: Searches for a dish by its name and displays its details.
- `void updateDish(String dishName, double newPrice, int newRating)`: Updates the price and rating of an existing dish based on its name.

## Contribution

Contributions are welcome! If you have any suggestions or find any issues, feel free to submit a pull request or open an issue.

