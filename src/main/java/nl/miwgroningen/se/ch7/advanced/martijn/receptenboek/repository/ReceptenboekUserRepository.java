package nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.repository;

import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.model.ReceptenboekUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReceptenboekUserRepository extends JpaRepository<ReceptenboekUser, Long> {
    Optional<ReceptenboekUser> findByUsername(String username);
}
