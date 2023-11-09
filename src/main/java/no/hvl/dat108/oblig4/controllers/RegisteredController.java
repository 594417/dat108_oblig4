package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4.models.Deltager;
import no.hvl.dat108.oblig4.repositories.DeltagerRepository;
import no.hvl.dat108.oblig4.utils.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("${app.url.registered}")
public class RegisteredController {
    @Value("${app.url.login}")
    private String LOGIN_URL;
    @Value("${app.url.participants}")
    private String PARTICIPANTS_URL;

    @Autowired
    private DeltagerRepository deltagerRepository;

    @GetMapping
    public String serveRegistered(Model model, @CookieValue(name = "user-id")String userid) {
        Optional<Deltager> deltager = deltagerRepository.findById(userid);

        if (!deltager.isPresent()) {
            return "redirect:" + LOGIN_URL;
        }

        model.addAttribute("deltager", deltager.get());

        return "paameldt";
    }

}



