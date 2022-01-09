package nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.controller;

import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.model.Recipe;
import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.repository.IngredientRepository;
import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.repository.RecipeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 08/01/2022
 * Dit is wat het programma doet.
 */

@Controller
public class RecipeController {

    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;

    public RecipeController(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping({"/", "/recipes"})
    protected String showRecipeOverview(Model model) {
        model.addAttribute("allRecipes", recipeRepository.findAll());
        return "recipeOverview";
    }

    @GetMapping("/recipe/new")
    protected String showRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        return "recipeForm";
    }

    @PostMapping("/recipe/new")
    protected String saveOrUpdateRecipe(@ModelAttribute("recipe") Recipe recipe, BindingResult result) {
        if(!result.hasErrors()) {
            recipeRepository.save(recipe);
        }
        return "redirect:/recipes";
    }

    @GetMapping("/recipes/update/{recipeName}")
    protected String showRecipeForm(@PathVariable("recipeName") String recipeName, Model model) {
        Optional<Recipe> recipe = recipeRepository.findByRecipeName(recipeName);
        if (recipe.isEmpty()) {
            return "redirect:/recipes";
        }
        model.addAttribute("recipe", recipe.get());
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        return "recipeForm";
    }

    @GetMapping("/recipe/details/{recipeName}")
    protected String showRecipeDetails(@PathVariable("recipeName") String recipeName, Model model) {
        Optional<Recipe> recipe = recipeRepository.findByRecipeName(recipeName);
        if (recipe.isEmpty()) {
            return "redirect:/recipes";
        }
        model.addAttribute("recipe", recipe.get());
        return "recipeDetails";
    }
}
