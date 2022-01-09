package nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.repository;

import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
