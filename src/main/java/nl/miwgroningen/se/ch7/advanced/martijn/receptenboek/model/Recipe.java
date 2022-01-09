package nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 07/01/2022
 * Recepten bestaan uit verschillende ingredienten met bijbehorende hoeveelheden.
 */

@Entity
@Getter @Setter
public class Recipe {

    @Id
    @GeneratedValue
    private Long recipeId;

    private String recipeName;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients = new HashSet<>();

    public String getIngredientsDisplayString() {
        StringBuilder ingredientsString = new StringBuilder();

        for (Ingredient ingredient : ingredients) {
            ingredientsString.append(ingredient.ingredientDisplayName()).append("\n");
        }

        return ingredientsString.toString();
    }
}
