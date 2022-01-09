package nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.controller;

import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.model.ReceptenboekUser;
import nl.miwgroningen.se.ch7.advanced.martijn.receptenboek.repository.ReceptenboekUserRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Martijn Gäbler <m.gabler@st.hanze.nl>
 * Date created: 09/01/2022
 * Dit is wat het programma doet.
 */

@Controller
@RequestMapping("users")
public class ReceptenboekUserController {

    ReceptenboekUserRepository receptenboekUserRepository;
    PasswordEncoder passwordEncoder;

    public ReceptenboekUserController(ReceptenboekUserRepository receptenboekUserRepository, PasswordEncoder passwordEncoder) {
        this.receptenboekUserRepository = receptenboekUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/new")
    @Secured("ROLE_ADMIN")
    protected String showUserForm(Model model) {
        model.addAttribute("newUser", new ReceptenboekUser());
        return "userForm";
    }

    @PostMapping("/new")
    @Secured("ROLE_ADMIN")
    protected String saveOrUpdateUser(@ModelAttribute("newUser") ReceptenboekUser user, BindingResult result) {
        if (result.hasErrors()) {
            return "userForm";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        receptenboekUserRepository.save(user);
        return "redirect:/";
    }
}
