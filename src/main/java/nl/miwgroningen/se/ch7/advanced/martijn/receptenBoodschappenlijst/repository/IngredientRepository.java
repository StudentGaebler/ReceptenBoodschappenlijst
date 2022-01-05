package nl.miwgroningen.se.ch7.advanced.martijn.receptenBoodschappenlijst.repository;

import nl.miwgroningen.se.ch7.advanced.martijn.receptenBoodschappenlijst.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
