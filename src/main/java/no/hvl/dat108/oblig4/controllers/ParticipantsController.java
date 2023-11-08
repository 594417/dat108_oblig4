package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4.repositories.DeltagerRepository;
import no.hvl.dat108.oblig4.utils.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("${app.url.participants}")
public class ParticipantsController {

    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.participants}") private String PARTICIPANTS_URL;
    @Autowired
    private DeltagerRepository deltagerRepository;

    @GetMapping
    public String serveParticipants(Model model) {
        model.addAttribute("deltagere", deltagerRepository.findAll());
        return "deltagerliste";
    }

    @PostMapping
    public String participants(HttpSession session, RedirectAttributes ra){
        if(LoginUtil.erBrukerInnlogget(session)){
            LoginUtil.loggUtBruker(session);
        }
        ra.addFlashAttribute("redirectMessage", "Du er logget ut");
        return "redirect:" + LOGIN_URL;
    }
}

