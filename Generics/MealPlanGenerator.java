
interface MealPlan {
    void showPlan();
}

class VegetarianMeal implements MealPlan {
    public void showPlan() {
        System.out.println("Vegetarian Meal Plan");
    }
}

class VeganMeal implements MealPlan {
    public void showPlan() {
        System.out.println("Vegan Meal Plan");
    }
}

class Meal<T extends MealPlan> {
    T plan;

    Meal(T plan) {
        this.plan = plan;
    }

    public void generate() {
        plan.showPlan();
    }

    public static <T extends MealPlan> void validateAndGenerate(T meal) {
        System.out.print("Generating: ");
        meal.showPlan();
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> meal = new Meal<>(new VegetarianMeal());
        meal.generate();
        Meal.validateAndGenerate(new VeganMeal());
    }
}
