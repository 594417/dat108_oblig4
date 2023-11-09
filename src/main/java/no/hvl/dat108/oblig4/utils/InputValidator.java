package no.hvl.dat108.oblig4.utils;

public class InputValidator {
    public static final String FIRST_NAME = "[A-Z][a-zA-ZæøåÆØÅ+-+\\s]{2,19}";
    public static final String LAST_NAME = "[A-Z][a-zA-ZæøåÆØÅ+-]{2,19}";
    public static final String PASSORD = ".{5,}";
    public static final String NUMBER = "[0-9]{8}";
    public static final String GENDER = "(mann|kvinne)";

    public static boolean isValidFirstName(String firstName){
        return firstName != null && firstName.matches("^" + FIRST_NAME + "$");
    }
    public static boolean isValidLastName(String lastName){
        return lastName != null && lastName.matches("^" + LAST_NAME + "$");
    }
    public static boolean isValidPhone(String phone){
        return phone != null && phone.matches("^" + NUMBER + "$");
    }
    public static boolean isValidPassword(String password, String repeatPassword){
        return password != null && password.matches("^" + PASSORD + "$") && password.equals(repeatPassword);
    }
    public static boolean isValidKjonn(String gender){
        return gender != null && gender.matches("^" + GENDER + "$");
    }
}
