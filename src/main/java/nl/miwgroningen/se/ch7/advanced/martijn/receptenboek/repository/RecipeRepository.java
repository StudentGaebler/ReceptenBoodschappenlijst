package nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.repository;

import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Optional<Recipe> findByRecipeName(String name);
}
