package no.hvl.dat108.oblig4.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("${app.url.participants}")
public class ParticipantsController {

    @Value("${app.url.login}") private String LOGIN_URL;
    @Value("${app.url.participants}") private String PARTICIPANTS_URL;
    @Autowired
    private DeltagerRepository deltagerRepository;

    @GetMapping
    public String serveParticipants(@CookieValue(name = "user-id")String userid, Model model) {
        Optional<Deltager> deltager = deltagerRepository.findById(userid);

        if (!deltager.isPresent()) {
            return "redirect:" + LOGIN_URL;
        }

        model.addAttribute("deltager", deltager.get());

        List<Deltager> deltagere = deltagerRepository.findAll();

        model.addAttribute("deltagere", deltagere);

        return "deltagerliste";
    }

    @PostMapping
    public String participants(HttpServletRequest req, HttpServletResponse res, RedirectAttributes ra){
        Cookie[] cookies = req.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                res.addCookie(cookie);
            }

        ra.addFlashAttribute("loginMessage", "Du er logget ut");
        return "redirect:" + LOGIN_URL;
    }
}

