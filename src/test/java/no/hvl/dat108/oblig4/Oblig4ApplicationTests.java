package no.hvl.dat108.oblig4;

import jakarta.persistence.criteria.CriteriaBuilder;
import no.hvl.dat108.oblig4.models.Deltager;
import no.hvl.dat108.oblig4.utils.InputValidator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Oblig4ApplicationTests {

	@Test
	public void gyldigDeltager() {
		Deltager deltager = new Deltager("43521213", "", "", "Isak", "Georg", "kvinne");
		String validPassword = "validPassword";
		String validRepeatPassword = "validPassword";

		assertTrue(InputValidator.isValidFirstName(deltager.fornavn));
		assertTrue(InputValidator.isValidLastName(deltager.etternavn));
		assertTrue(InputValidator.isValidPhone(deltager.mobil));
		assertTrue(InputValidator.isValidKjonn(deltager.kjonn));
		assertTrue(InputValidator.isValidPassword(validPassword, validRepeatPassword));
	}

}
