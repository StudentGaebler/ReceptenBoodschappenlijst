package nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.controller;

import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.model.Ingredient;
import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.repository.IngredientRepository;
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

    @GetMapping("/ingredients")
    protected String showIngredientOverview(Model model) {
        model.addAttribute("allIngredients", ingredientRepository.findAll());
        model.addAttribute("newIngredient", new Ingredient());
        return "ingredientOverview";
    }

    @PostMapping("ingredient/new")
    protected String saveOrUpdateIngredient(@ModelAttribute("newIngredient") Ingredient ingredient, BindingResult result) {
        if (result.hasErrors()) {
            return "ingredientOverview";
        }
        ingredientRepository.save(ingredient);
        return "redirect:/ingredients";
    }
}
