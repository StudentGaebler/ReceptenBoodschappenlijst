package nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.service;

import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.repository.ReceptenboekUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 09/01/2022
 * Dit is wat het programma doet.
 */

@Service
public class ReceptenboekUserDetailsService implements UserDetailsService {

    ReceptenboekUserRepository receptenboekUserRepository;

    public ReceptenboekUserDetailsService(ReceptenboekUserRepository receptenboekUserRepository) {
        this.receptenboekUserRepository = receptenboekUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return receptenboekUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " was not found."));
    }
}
