package calculator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class StringCalculatorShould {
	//1. take 0,1,2 number and sum 
	@Test
	public void sumsEmptyStringTo0() {
		assertThat(StringCalculator.add(""), is(0));
	}

	@Test
	public void sumsSingleNumberToItself() {
		assertThat(StringCalculator.add("5"), is(5));
		assertThat(StringCalculator.add("42"), is(42));
	}

	@Test
	public void sumsTwoNumbersSeperatedByComma() {
		assertThat(StringCalculator.add("1,2"), is(3));
		assertThat(StringCalculator.add("1,3"), is(4));
	}

	
	@Test
	public void sumsThreeNumbersSeperatedByComma() {
		assertThat(StringCalculator.add("1,2,3"), is(6));
	}


	//3.Allow the Add method to handle new lines between numbers  
	@Test
	public void sumsNumbersDelimitedByCommaOrNewline() {
		assertThat(StringCalculator.add("1,2\n3"), is(6));
	}

	//4.“//[delimiter]\n[numbers…]”  for example  “//;\n1;2” == 3 	
	@Test
	public void usesDelimiterSepcified() {
		assertThat(StringCalculator.add("//;\n1;2"), is(3));
		assertThat(StringCalculator.add("//.\n2.3.1"), is(6));
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
//5
	@Test
	public void throwsOnNegativeNumber() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -3");

		StringCalculator.add("-3");
	}
//6
	@Test
	public void throwsOnNegativeNumbersWithAllNumbersInExceptionMessage() {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage("negative number: -3,-5,-13");

		StringCalculator.add("1,-3,5,-5,-13");
	}
//9
	@Test
	public void mapsNumbersAbove1000ToLastThreeDigits() {
		assertThat(StringCalculator.add("1002"), is(2));
		assertThat(StringCalculator.add("1040,10002"), is(42));
	}
//10
	@Test
	public void acceptsDelimiterOfArbitraryLength() {
		assertThat(StringCalculator.add("//[***]\n1***2***3"), is(6));
	}
//11,12
	@Test
	public void acceptsMultipleDelimiters() {
		assertThat(StringCalculator.add("//[*][%]\n1*2%3"), is(6));
		
		assertThat(StringCalculator.add("//[**][%%]\n1**2%%3"), is(6));
	}
	

}