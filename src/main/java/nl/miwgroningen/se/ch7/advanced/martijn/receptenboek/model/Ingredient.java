package nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 05/01/2022
 * Indredienten die voor recepten gebruikt kunnen worden.
 */

@Entity
@Getter @Setter
public class Ingredient {

    @Id
    @GeneratedValue
    private Long ingredientId;

    private String ingredientName;

    private double pricePerKilo;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Recipe> inRecipes = new HashSet<>();

    public String ingredientDisplayName() {
        return ingredientName;
    }
}
