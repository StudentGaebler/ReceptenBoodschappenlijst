package nl.miwgroningen.se.ch7.advanced.martijn.receptenBoodschappenlijst.controller;

import nl.miwgroningen.se.ch7.advanced.martijn.receptenBoodschappenlijst.model.Ingredient;
import nl.miwgroningen.se.ch7.advanced.martijn.receptenBoodschappenlijst.repository.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 05/01/2022
 * Alle interacties van de gebruiker met ingredienten
 */

@Controller
public class IngredientController {

    private IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/")
    protected String showIngredientOverview(Model model) {
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        return "ingredientOverview";
    }

    @GetMapping("ingredient/new")
    protected String showIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredientForm";
    }

    @PostMapping("ingredient/new")
    protected String saveOrUpdateIngredient(@ModelAttribute("ingredient") Ingredient ingredient, BindingResult result) {
        if (!result.hasErrors()) {
            ingredientRepository.save(ingredient);
        }
        return "redirect:/";
    }
}
