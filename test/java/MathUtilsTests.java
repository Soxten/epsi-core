import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import fr.epsi.core.MathUtils;

class MathUtilsTests {

	@org.junit.jupiter.api.Test
	void test() {

	}

	@ParameterizedTest(name = "La factorielle de {0} est {1}")
	@CsvFileSource(resources = "/Factorial.csv", numLinesToSkip = 1)
	void factorial(int number, double expectedResult) {
		// assertEquals(MathUtils.factorial(number)).isEqual(expectedResult);
		assertEquals(expectedResult, MathUtils.factorial(number), 0);
	}

	@ParameterizedTest(name = "Le chiffre {0} est premier ")
	@ValueSource(ints = { 2, 3, 5, 7, 11 })
	void isPrimeNumber(int number) {
		assertTrue(MathUtils.isPrimeNumber(number));
	}

	@ParameterizedTest(name = "Le chiffre {0} est premier ")
	@ValueSource(ints = { 1, 4, 6, 8, 9})
	void isNotPrimeNumber(int number) {
		assertFalse(MathUtils.isPrimeNumber(number));
	}

}