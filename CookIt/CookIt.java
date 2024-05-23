import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CookIt {
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

        foodList = new ArrayList<>();
        unknownFoods = new ArrayList<>();
        recipes = new HashMap<>();

        storeRecipes();
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

    public String processUserInput(String userInput) {
        foodList.clear();
        unknownFoods.clear();
        for (String ingredient : userInput.split("\\s+")) {
            if (knownIngredients.contains(ingredient)) {
                foodList.add(ingredient);
            } else {
                unknownFoods.add(ingredient);
            }
        }
        return "User input processed.";
    }

    public String displayKnownIngredients() {
        StringBuilder sb = new StringBuilder("Known Ingredients:\n");
        for (String ingredient : knownIngredients) {
            sb.append("- ").append(ingredient).append("\n");
        }
        return sb.toString();
    }

    public String displayMatchingRecipes() {
        List<String> matchingRecipes = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : recipes.entrySet()) {
            String recipe = entry.getKey();
            List<String> ingredients = entry.getValue();
            boolean ingredientFound = false;
            for (int i = 0; i < ingredients.size(); i++) {
                if (foodList.contains(ingredients.get(i))) {
                    ingredientFound = true;
                    break; // Break loop once at least one ingredient is found
                }
            }
            if (ingredientFound) {
                matchingRecipes.add(recipe);
            }
        }
        if (matchingRecipes.isEmpty()) {
            return "No matching recipes found.";
        } else {
            StringBuilder sb = new StringBuilder("Matching Recipes:\n");
            for (String recipe : matchingRecipes) {
                sb.append("- ").append(recipe).append("\n");
            }
            return sb.toString();
        }
    }

}