package fr.formation.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class CalculTest {
    
    private Calcul calcul;

    @BeforeEach // C'est la methode qui sera execute avant chaque test
    void setUp() throws Exception {
        calcul = new Calcul();
    }

    @AfterEach // C'est la methode qui sera execute aprèS chaque test
	void tearDown() throws Exception {
		calcul = null;
	}

    @DisplayName("Test de la methode somme(...)")
    @RepeatedTest(3)
    void testSomme(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom de la methode *** : " + testInfo.getTestMethod().get().getName());

        System.out.println("*** REPETITION DETAILS ***");
		System.out.println("*** Repetition courante *** : " + repetitionInfo.getCurrentRepetition());
		System.out.println("*** Repetitions totales *** : " + repetitionInfo.getTotalRepetitions());
        
        assertTrue(calcul.somme(0, 0) == 0, "entier x null");
        assertFalse(calcul.somme(2, 3) == 6, "2 entiers positifs");
        assertNotNull(calcul.somme(2, -3), "2 entiers designe differents");
        assertEquals(-15, calcul.somme(-12, -3), "2 entiers négatifs");
    }

    @DisplayName("Test de la methode division(...)")
	@Test
    void testDivision(TestInfo testInfo) {
        System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom de la methode *** : " + testInfo.getTestMethod().get().getName());
        
		assertEquals(4, calcul.division(-12, -3), "2 entiers negatifs");
		assertNotNull(calcul.division(-6, 3), "2 entiers de signe different");
        assertTrue(calcul.division(0, 3) == 0, "entier x nul");
    }

    @DisplayName("Test de la methode division(...) - Exception attendue")
	@Test
	void testDivisionByZero(TestInfo testInfo) {
		System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom de la methode *** : " + testInfo.getTestMethod().get().getName());
		
        assertThrows(ArithmeticException.class, () -> calcul.division(2, 0));
	}
}

