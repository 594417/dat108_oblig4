package no.hvl.dat108.oblig4.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.oblig4.models.Deltager;

public class LoginUtil {

    private final static int MAX_INTERACTIVE_INTERVAL = 60;

    public static void loggUtBruker(HttpSession session){
        session.invalidate();
    }
    public static void loggInnBruker(HttpServletRequest request, Deltager deltager){

        loggUtBruker(request.getSession());

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
        session.setAttribute("deltager", deltager);
    }

    public static boolean erBrukerInnlogget(HttpSession session){
        return session != null && session.getAttribute("username") != null;

    }
}
