/**
 * @author Roberto Echeverria
 * @since 03/20/2024
 * @version 1.0
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CookIt {
    private ArrayList<String> knownIngredients;
    private List<String> foodList;
    private List<String> unknownFoods;
    private Map<String, List<String>> recipes;

    public CookIt() {
        knownIngredients = new ArrayList<>();
        knownIngredients.add("bananas");
        knownIngredients.add("apples");
        knownIngredients.add("potatoes");
        knownIngredients.add("onions");
        knownIngredients.add("lettuce");
        knownIngredients.add("pasta");
        knownIngredients.add("bread");
        knownIngredients.add("flour");
        knownIngredients.add("ham");
        knownIngredients.add("mayo");
        knownIngredients.add("eggs");
        knownIngredients.add("cheese");
        knownIngredients.add("milk");
        knownIngredients.add("rice");
        knownIngredients.add("chicken");
        knownIngredients.add("ground beef");
        knownIngredients.add("bacon");
        knownIngredients.add("peanut butter");
        knownIngredients.add("pancake syrup");
        knownIngredients.add("cereal");

        // creating arraylists are better than regular lists because
        // they are dynamic (grow and shrink size as more items are added).
        foodList = new ArrayList<>();
        unknownFoods = new ArrayList<>();
        recipes = new HashMap<>();

        storeRecipes();
        //System.out.print(recipes);
    }

    private void storeRecipes() {
        // Recipe 1: Ham Sandwich
        ArrayList<String> hamSandwichIngredients = new ArrayList<>();
        hamSandwichIngredients.add("bread");
        hamSandwichIngredients.add("ham");
        hamSandwichIngredients.add("mayo");
        hamSandwichIngredients.add("cheese");
        recipes.put("ham sandwich", hamSandwichIngredients);

        // Recipe 2: Chicken Salad
        ArrayList<String> chickenSaladIngredients = new ArrayList<>();
        chickenSaladIngredients.add("chicken");
        chickenSaladIngredients.add("lettuce");
        chickenSaladIngredients.add("tomato");
        recipes.put("chicken salad", chickenSaladIngredients);

        // Recipe 3: Cereal
        ArrayList<String> cerealIngredients = new ArrayList<>();
        cerealIngredients.add("milk");
        cerealIngredients.add("cereal");
        recipes.put("cereal", cerealIngredients);

        // Recipe 4: Italian Pasta
        ArrayList<String> italianPastaIngredients = new ArrayList<>();
        italianPastaIngredients.add("pasta");
        italianPastaIngredients.add("milk");
        italianPastaIngredients.add("chicken");
        italianPastaIngredients.add("cheese");
        recipes.put("italian pasta", italianPastaIngredients);

        // Recipe 5: Grilled Cheese
        ArrayList<String> grilledCheeseIngredients = new ArrayList<>();
        grilledCheeseIngredients.add("bread");
        grilledCheeseIngredients.add("cheese");
        recipes.put("grilled cheese", grilledCheeseIngredients);

        // Recipe 6: Baked Bread
        ArrayList<String> bakedBreadIngredients = new ArrayList<>();
        bakedBreadIngredients.add("flour");
        bakedBreadIngredients.add("water");
        bakedBreadIngredients.add("eggs");
        recipes.put("baked bread", bakedBreadIngredients);

        // Recipe 7: Cheeseburger
        ArrayList<String> cheeseburgerIngredients = new ArrayList<>();
        cheeseburgerIngredients.add("bread");
        cheeseburgerIngredients.add("cheese");
        cheeseburgerIngredients.add("mayo");
        cheeseburgerIngredients.add("ground beef");
        cheeseburgerIngredients.add("lettuce");
        cheeseburgerIngredients.add("tomato");
        recipes.put("cheeseburger", cheeseburgerIngredients);

        // Recipe 8: Side of Rice
        ArrayList<String> riceIngredients = new ArrayList<>();
        riceIngredients.add("rice");
        recipes.put("side of rice", riceIngredients);

        // Recipe 9: Grilled Chicken
        ArrayList<String> grilledChickenIngredients = new ArrayList<>();
        grilledChickenIngredients.add("chicken");
        recipes.put("grilled chicken", grilledChickenIngredients);

        // Recipe 10: French Toast
        ArrayList<String> frenchToastIngredients = new ArrayList<>();
        frenchToastIngredients.add("eggs");
        frenchToastIngredients.add("bread");
        frenchToastIngredients.add("pancake syrup");
        recipes.put("french toast", frenchToastIngredients);

        // Recipe 11: Scrambled Eggs
        ArrayList<String> scrambledEggsIngredients = new ArrayList<>();
        scrambledEggsIngredients.add("eggs");
        recipes.put("scrambled eggs", scrambledEggsIngredients);

        // Recipe 12: Side of Mashed Potatoes
        ArrayList<String> mashedPotatoesIngredients = new ArrayList<>();
        mashedPotatoesIngredients.add("potatoes");
        recipes.put("side of mashed potatoes", mashedPotatoesIngredients);
    }

    public void processIngredients() {
        Scanner scanner = new Scanner(System.in);
        boolean moreIngredients = true;

        // While this is true i will keep asking for additional ingredients
        while (moreIngredients) {
            System.out.println("Press 1 to view known ingredients or press 2 to input your own ingredients:");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // I ask the user if they want to see the list since the # of food items are limited
                if (choice == 1) {
                    // Call the display function
                    displayKnownIngredients();
                } else if (choice == 2) {
                    // Call on the function that asks for ingredients
                    inputUserIngredients(scanner);
                    // Then call on the recipe match function
                    displayMatchingRecipes();
                } else {
                    System.out.println("Invalid choice. Please choose either 1 or 2.");
                    continue;
                }

                // ask for more ingredients until user says no, then close out program.
                System.out.println("Would you like to add more ingredients? (yes/no)");
                String response = scanner.nextLine().toLowerCase();
                if (response.equals("no")) {
                    moreIngredients = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input to avoid an infinite loop
            }
        }

        scanner.close();
        System.out.println("Thank you for using CookIt! (beta)");
    }

    private void displayKnownIngredients() {
        System.out.println("\nKnown Ingredients:");
        // using a range based for loop that starts at the first ingredient and ends at
        // the last ingredient in knownIngredients, I print out the contents of 
        // that known ingredients list.
        for (String ingredient : knownIngredients) {
            System.out.println("- " + ingredient);
        }
    }

    private void inputUserIngredients(Scanner scanner) {
        System.out.println("\nEnter ingredients (one per line, type 'done' to finish):");
        String newIngredient;
        while (!(newIngredient = scanner.nextLine()).equals("done")) {
            if (knownIngredients.contains(newIngredient)) {
                foodList.add(newIngredient);
            } else {
                unknownFoods.add(newIngredient);
            }
        }
    }

    private void displayMatchingRecipes() {
        // Create a list to store matching recipes
    	ArrayList<String> matchingRecipes = new ArrayList<>();

        // Iterate through each recipe
        for (Map.Entry<String, List<String>> recipePlusIngredient : recipes.entrySet()) {
            String recipeName = recipePlusIngredient.getKey(); // Stores recipe name in a var
            List<String> recipeIngredients = recipePlusIngredient.getValue(); // Get the ingredients of the recipe

            // Check if any ingredient of the recipe is present in the user's input
            boolean anyIngredientFound = false;
            for (String ingredient : recipeIngredients) {
                if (foodList.contains(ingredient)) {
                    anyIngredientFound = true;
                    break; // No need to continue checking if one ingredient is found
                }
            }

            // If at least one ingredient of the recipe is found, add the recipe to the matching recipes list
            if (anyIngredientFound) {
                matchingRecipes.add(recipeName);
            }
        }

        // Display the result based on whether matching recipes were found or not
        if (matchingRecipes.isEmpty()) {
            System.out.println("No recipes found matching the provided ingredients.");
        } else {
            System.out.println("Recipes found:");
            for (String recipe : matchingRecipes) {
                System.out.println("- " + recipe); // Print each matching recipe
            }

            // Ask the user if they want to view the ingredients of a recipe
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to view the ingredients of a recipe? (yes/no)");
            String response = scanner.nextLine().toLowerCase();
            while (response.equals("yes")) {
                System.out.println("Enter the name of the recipe you want to view the ingredients for:");
                String recipeToView = scanner.nextLine().toLowerCase();
                List<String> ingredients = recipes.get(recipeToView);
                if (ingredients != null) {
                    System.out.println("Ingredients for " + recipeToView + ":");
                    for (String ingredient : ingredients) {
                        System.out.println("- " + ingredient);
                    }
                } else {
                    System.out.println("Recipe not found.");
                }
                // Ask if the user wants to view another recipe
                System.out.println("Would you like to view another recipe? (yes/no)");
                response = scanner.nextLine().toLowerCase();
            }
        }

        // Clear the user's ingredient list for the next set of ingredients
        foodList.clear();
    }

    public static void main(String[] args) {
        CookIt recipeFind = new CookIt();
        recipeFind.processIngredients();
    }
}

	
	
	
