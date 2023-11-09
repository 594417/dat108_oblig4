package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.hvl.dat108.oblig4.models.Deltager;
import no.hvl.dat108.oblig4.repositories.DeltagerRepository;
import no.hvl.dat108.oblig4.services.PasswordService;
import no.hvl.dat108.oblig4.utils.InputValidator;
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
@RequestMapping("/${app.url.registration}")
public class RegistrationController {

    @Value("${app.url.registration}") private String REGISTRATION_URL;
    @Value("${app.url.registered}") private String REGISTERED_URL;

    @Autowired
    private DeltagerRepository deltagerRepository;
    private PasswordService passwordService = new PasswordService();
    private InputValidator inputValidator = new InputValidator();

    @GetMapping
    public String serveRegistration() {
        return "paamelding";
    }

    @PostMapping
    public String registration(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String phone, @RequestParam String password, @RequestParam String repeatPassword, @RequestParam String gender, HttpServletRequest request, HttpServletResponse response, RedirectAttributes ra){

        if (!InputValidator.isValidFirstName(firstName) || !InputValidator.isValidLastName(lastName) || !InputValidator.isValidPassword(password, repeatPassword) || !InputValidator.isValidKjonn(gender) || !InputValidator.isValidPhone(phone)) {
            ra.addFlashAttribute("redirectMessage", "Påmeldingsdetaljer er ugyldige");
            System.out.println("Did not pass regex");
            return "redirect:" + REGISTRATION_URL;
        }

        Optional<Deltager> eksisterendeDeltager = deltagerRepository.findById(phone);

        if (eksisterendeDeltager.isPresent()) {
            ra.addFlashAttribute("redirectMessage", "Deltager med dette mobilnummeret er allerede påmeldt");
            System.out.println("User already exists");
            return "redirect:" + REGISTRATION_URL;
        }

        String salt = passwordService.genererTilfeldigSalt();
        String hash = passwordService.hashMedSalt(password, salt);

        Deltager deltager = new Deltager(phone, hash, salt, firstName, lastName, gender);

        deltagerRepository.save(deltager);

        ra.addFlashAttribute("redirectMessage", deltager);
        Cookie c = new Cookie ("user-id", phone);
        c.setAttribute("name", deltager.fornavn + " " + deltager.etternavn);
        c.setMaxAge(3600);
        response.addCookie(c);

        return "redirect:" + REGISTERED_URL;
    }
}