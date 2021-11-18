import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import fr.epsi.core.StringUtils;

class StringUtilsTests {

	@ParameterizedTest(name = "La phrase {0} est palindrome ")
	@ValueSource(strings = { "esope reste ici et se repose" })
	void isPalindrome(String phrase) {
		assertTrue(StringUtils.isPalindrome(phrase));
	}

	@ParameterizedTest(name = "Les mots {0}, {1} ne sont pas des palindromes ")
	@ValueSource(strings = { "antoine" })
	void isNotPalindrome(String phrase) {
		assertFalse(StringUtils.isPalindrome(phrase));
	}

	@ParameterizedTest(name = "{1} décodé donne : {0} ")
	@CsvFileSource(resources = "/Cesar.csv", numLinesToSkip = 1)
	void cesarDecode(String sentence, String request, int step) {
		assertEquals(sentence, StringUtils.cesarDecode(request, step));
	}

	@ParameterizedTest(name = "{0} encodé donne :{1} ")
	@CsvFileSource(resources = "/Cesar.csv", numLinesToSkip = 1)
	void cesarEncode(String sentence, String request, int step) {
		assertEquals(request, StringUtils.cesarEncode(sentence, step));
	}
}
