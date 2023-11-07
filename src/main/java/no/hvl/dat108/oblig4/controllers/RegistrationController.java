package no.hvl.dat108.oblig4.controllers;

import no.hvl.dat108.oblig4.repositories.DeltagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/${app.url.registration}")
public class RegistrationController {
    @Autowired
    private DeltagerRepository deltagerRepository;

    @GetMapping
    public String serveRegistration() {
        return "paamelding";
    }
}
