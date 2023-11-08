package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat108.oblig4.models.Deltager;
import no.hvl.dat108.oblig4.repositories.DeltagerRepository;
import no.hvl.dat108.oblig4.services.PasswordService;
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
    @Value("${app.url.registered}") private String REGISTERED_URL;
    @Value("${app.url.login}") private String LOGIN_URL;

    @Autowired
    private DeltagerRepository deltagerRepository;

    private PasswordService passwordService = new PasswordService();

    @GetMapping
    public String serveLogin() {
        return "innlogging";
    }

    @PostMapping
    public String login(@RequestParam String phone, @RequestParam String password, HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra) {
        Optional<Deltager> deltager = deltagerRepository.findById(phone);

        if(deltager.isEmpty()) {
            ra.addFlashAttribute("redirectMessage", "Ugyldig brukernavn");
            return "redirect:" + LOGIN_URL;
        }

        if(passwordService.erKorrektPassord(password, deltager.get().salt, deltager.get().hash)){
            ra.addFlashAttribute("redirectMessage", deltager);
            Cookie c = new Cookie ("user-id", phone);
            c.setAttribute("name", deltager.get().fornavn + " " + deltager.get().etternavn);
            c.setMaxAge(60);
            response.addCookie(c);
        } else {
            ra.addFlashAttribute("redirectMessage", "Ugyldig passord");
            return "redirect:" + LOGIN_URL;
        }
        return "redirect:" + REGISTERED_URL;
    }
}
