package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.HttpServletRequest;
import no.hvl.dat108.oblig4.models.Deltager;
import no.hvl.dat108.oblig4.repositories.DeltagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/${app.url.login}")
public class LoginController {
    @Value("${app.url.participants}") private String PARTICIPANTS_URL;
    @Value("${app.url.login}") private String LOGIN_URL;

    @Autowired
    private DeltagerRepository deltagerRepository;

    @GetMapping
    public String serveLogin() {
        return "innlogging";
    }

    @PostMapping
    public String login(@RequestParam String phone, @RequestParam String password, HttpServletRequest request, RedirectAttributes ra) {
        Optional<Deltager> deltager = deltagerRepository.findById(phone);

        if(deltager.isEmpty()) {
            ra.addFlashAttribute("redirectMessage", "Ugyldig brukernavn");
            return "redirect:" + LOGIN_URL;
        }

        // TODO: CHECK PASSWORD HERE BEFORE RETURNING USER

        return "redirect:" + PARTICIPANTS_URL;
    }
}
